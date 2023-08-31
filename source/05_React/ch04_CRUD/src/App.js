import { Component } from 'react';
import './App.css';
import ReadContent from './components/ReadContent';
import Subject from './components/Subject';
import TOC from './components/TOC';
import './subject.css';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
    mode : 'read',
    selected_content_id : 1,
    subject : {title: 'WEB', sub:'World Wide Web'},
    contents: [
      {id:1, title: 'HTML', desc:'HTML is HyperText MarkUp Language'},
      {id:2, title:'CSS', desc:'CSS is for Design'},
      {id:3, title:'JavaScript', desc:'JavaScript is for Interactive'},
      {id:4, title:'React', desc:'React is for UI'},
    ],
    welcome: {title: 'Welcome', desc: 'Hello, React!!'},
  };
}


  render() {
    var _title, _desc, _article = null;
    if(this.state.mode ==='welcome') {
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc} />
    } else if(this.state.mode ==='read') {
      for(var i = 0; i < this.state.contents.length; i++) {
        var data = this.state.contents[i];
        if(data.id === this.state.selected_content_id) {
          _title = data.title;
          _desc = data.desc;
          break;
        }
      }
      _article = <ReadContent title={_title} desc={_desc} />
    } else if(this.state.mode === 'create') {
      // _article = <CreateContent />
    } else if(this.state.mode === 'update') {
      // _article = <UpdateContent />
    }

    return (
      <div className="App">
        <Subject title={this.state.subject.title}
                sub={this.state.subject.sub}
                onChangePage={function() {
                  this.setState({
                    mode:'welcome'
                  });
                }.bind(this)}>
        </Subject>

        <TOC data={this.state.contents}
            onChangePage={function(id){
              this.setState({
                mode:'read',
                selected_content_id: Number(id),
              })
            }.bind(this)}>
        </TOC>

        {_article}
      
      </div>

    );
  }
};

export default App;