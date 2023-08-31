import React, { Component } from 'react';
import './App.css';
import ReadContent from './components/ReadContent';
import Subject from './components/Subject';
import TOC from './components/TOC';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mode : "read",
      selected_content_id : 1,
      subject : {title: "WEB", sub: "World Wide Web!"},
      contents : [
        {id: 1, title: "HTML", desc: "HTML is HyperText MarkUp Language."},
        {id: 2, title: "CSS", desc: "CSS is for Design."},
        {id: 3, title: "Javascript", desc: "Javascript is for Interactive."},
        {id: 4, title: "React", desc: "React is for UI."},
      ],
      welcome : {title: "Welcome", desc: "Hello, React!"},
    };
  }
  render() {
    var _title, _desc, _article = null;
    if(this.state.mode === "welcome") {
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>
    } else if(this.state.mode === "read") {
      // var data = this.state.contents[this.state.selected_content_id-1]; 이방법을 사용하면 데이터 수정(삭제) 시 결과값이 다를 수 있음
      // _title = data.title;
      // _desc = data.desc;
      for(var i = 0; i < this.state.contents.length; i++) {
        var data = this.state.contents[i];
        if(data.id === this.state.selected_content_id) {
          _title = data.title;
          _desc = data.desc;
          break;
        }
      }
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>
    } else if(this.state.mode === "create") {
      // _article = <CreateContent></CreateContent>;
    } else if(this.state.mode === "update") {
      // _article = <UpdateContent></UpdateContent>;
    }
    return (
      <div className="App">
        <Subject title={this.state.subject.title}
                sub={this.state.subject.sub}
                onChangePage={function() {
                  this.setState({
                    mode:'welcome'
                  });
                }.bind(this)}
                ></Subject>

        <TOC data={this.state.contents}
            onChangePage={function(id) {
              this.setState({
                mode:'read',
                selected_content_id: Number(id),
              })

            }.bind(this)}></TOC>

        {_article}
        
        </div>
    );
  }
};
export default App; // 외부에서 import 할 수 있도록 해주는 역할
