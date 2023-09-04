import { Component } from "react";
import './Control.css';
class Control extends Component{
  render(){
    return(
      <ul className="control">
        <li>
          {/* <a href="#" onClick={function(e){e.preventDefault();this.props.onChangeMode('create');}.bind(this)}>CREATE</a> */}
          <button onClick={function(){
            this.props.onChangeMode('create');
          }.bind(this)}>CREATE</button>
        </li>
        <li>
          <button onClick={function(){
            this.props.onChangeMode('update');
          }.bind(this)}>UPDATE</button>
        </li>
        <li>
          <button onClick={function(){
            this.props.onChangeMode('delete');
          }.bind(this)}>DELETE</button>
        </li>
      </ul>
    );
  }
}
export default Con