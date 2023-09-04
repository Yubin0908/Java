import { Component } from 'react';
import './App.css';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import ReadContent from './components/ReadContent';
import Subject from './components/Subject';
import TOC from './components/TOC';
import UpdateContent from './components/UpdateContent';

class App extends Component{
  constructor(props){
    super(props);
    this.maxId = 4; // state에 넣으면 불필요한 rendering 이루어짐
    this.state = {
      mode : 'welcome',
      selected_content_id : 0,
      subject : {title:'WEB', sub:'World Wide Web!'},
      contents : [
        {id:1, title:'HTML', desc:'HTML is HyperText Markup Language.'},
        {id:2, title:'CSS', desc:'CSS is for Design.'},
        {id:3, title:'JavaScript', desc:'JavaScript is for Interactive.'},
        {id:4, title:'React', desc:'React is for UI'},
      ],
      welcome : {title:'Welcome', desc:'Hello, React!'},
    };
  }
  getReadContent(){
    for(var i=0 ; i<this.state.contents.length ; i++){
      var data = this.state.contents[i];
      if(data.id === this.state.selected_content_id){
        return data;
      }//if
    }//for
  }
  getContent(){
    var _title, _desc, _article, _content = null;
    if(this.state.mode === 'welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>;
    }else if(this.state.mode === 'read'){
      _content = this.getReadContent();
      _article = <ReadContent title={_content.title} desc={_content.desc}></ReadContent>;
    }else if(this.state.mode === 'create'){
      _article = <CreateContent
                    onSubmitCreate = {function(_title, _desc){
                      // alert(_title + '/' + _desc);
                      // _title과 _desc로 {id:8, title:_title, desc:_desc}를 this.state.contents에 추가
                      this.maxId ++;
                      _content = {id:this.maxId, title:_title, desc:_desc}; // contents에 추가할 객체
                      // 비추천
                    //  this.state.contents.push(_content);
                    //  this.setState({
                    //    contents : this.state.contents, });
                    //  var _contents = Array.from(this.state.contents); // 복제
                      var _contents = this.state.contents.concat(_content); // this.state.contents 변경안됨
                      _contents.push(_content);
                      this.setState({
                        contents : _contents,
                        mode : 'read',
                        selected_content_id : this.maxId,
                      })
                    }.bind(this)}
                  ></CreateContent>;
    }else if(this.state.mode === 'update'){
      _content = this.getReadContent();
      if(_content){
        _article = <UpdateContent
                      data={_content}
                      onSubmitUpdate={function(_id, _title, _desc) {
                      var _contents = Array.from(this.state.contents); // 성능 튜닝할 지 모르니 복제
                      for(var idx = 0; idx < _contents.length; idx++){
                        if(_contents[idx].id === Number(_id)){
                          _contents[idx] = {id:Number(_id), title:_title, desc:_desc};
                          console.log(idx, '번째 수정 완료! 수정된 데이터는 : ' + _contents[idx]);
                          break;
                        }
                      }
                      this.setState({
                        contents : _contents,
                        mode :'read',
                      })
                      }.bind(this)
                      }>

        </UpdateContent>;
      } else {
        this.setState({
          mode : 'welcome',
          welcome : {title:'수정유의사항', desc:'수정할 데이터를 선택 후 수정하세요.'},
        });
      }
    }
    return _article;
  }
  render(){
    console.log('App render수행');
    return (
      <div>
        <Subject  title={this.state.subject.title}
                  sub={this.state.subject.sub}
                  onChangePage={function(){
                    this.setState({
                      mode:'welcome'
                    });
                  }.bind(this)}></Subject>
        <Control
          onChangeMode = {function(_mode){
            // this.state.mode = _mode; state의 값을 바꾸려면 setState()함수 이용
            if(_mode === 'delete') {
              if(this.state.selected_content_id !== 0 && window.confirm('정말로 삭제하시겠습니까 ?')) {
                // True 일때 삭제
                var _contents = [...this.state.contents];
                for(var idx = 0; idx < _contents.length; idx++){
                  if(_contents[idx].id === Number(this.state.selected_content_id)) {
                    _contents.splice(idx,1);
                    alert(this.state.selected_content_id + '번 삭제완료!');
                    break;
                  }
                }
                this.setState({
                  contents : _contents,
                  mode :'welcome',
                  selected_content_id : 0,
                });
              } else if(this.state.selected_content_id === 0) {
                alert('삭제할 데이터를 선택한 후 삭제하세요.');
              }
            } else {
            this.setState({
              mode : _mode,
            });}
          }.bind(this)}
        ></Control>
        <TOC data={this.state.contents}
            onChangePage={function(id){
              this.setState({
                mode : 'read',
                selected_content_id : Number(id),
              });
            }.bind(this)}></TOC>
        {this.getContent()}
      </div>
    );
  }
}
export default App;
