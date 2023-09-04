import { Component } from "react";
class UpdateContent extends Component{
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.data.id,
      title: this.props.data.title,
      desc: this.props.data.desc,
    };
    this.inputHandler = this.inputFormHandler.bind(this);
  }
  inputFormHandler = (e) => {
    this.setState({
      [e.target.name] : e.target.value,
    });
  }
  render(){
    return (
      <article>
        <h2>UPDATE</h2>
        <form onSubmit={function(e){
          e.preventDefault();
          this.props.onSubmitUpdate(
            e.target.id.value,
            e.target.title.value,
            e.target.desc.value);

        }.bind(this)}>
          <input type="hidden" name="id" defaultValue={this.state.id}/>
          {/* <p><input type="text" name="title" defaultValue={this.props.data.title}/></p>
          <p><textarea name="desc" defaultValue={this.props.data.desc}/></p> */}
          <p><input type="text" name="title" value={this.state.title} onChange={this.inputHandler}/></p>
          <p><textarea name="desc" value={this.state.desc} onChange={this.inputHandler}/></p>
          <p><input type="submit" value="수정"/></p>
        </form>
      </article>
    );
  }
}
export default UpdateContent;