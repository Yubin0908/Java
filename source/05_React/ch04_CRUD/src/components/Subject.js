import { Component } from 'react';
import './Subject.css';
class Subject extends Component{
  render(){
    return(
      <header>
        <h1>
          <a href="/" onClick={function(e){
                        e.preventDefault(); // a 태그의 기본 동작 막음
                        this.props.onChangePage();
                      }.bind(this)}>
            {this.props.title}
          </a>
        </h1>
        {this.props.sub}{/* 주석 */}
      </header>
    );
  }
}
export default Subject;