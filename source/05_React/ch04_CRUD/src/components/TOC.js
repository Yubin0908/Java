import { Component } from 'react';
class TOC extends Component{
  shouldComponentUpdate(newProps /* rendering 이전 props값 */) {
    // this.props가 변결될 때만 render() 실행
    if(this.props.data === newProps.data){
      return false; //shouldComponentUpdate() 실행 후 render를 실행되지 않도록 약속
    }
    return true; //shouldComponentUpdate() 실행 후 render를 실행한다.
  }
  render(){
    console.log('TOC render 수행');
    var lists = [];
    var data = this.props.data;
    for(var i=0 ; i<data.length ; i++){
      lists.push(<li key={data[i].id}>
                  <a href={data[i].id+".html"}
                    //  data-id={data[i].id}
                    onClick={function(id, e){
                      e.preventDefault();
                      // console.log(e.target.dataset.id, typeof(e.target.dataset.id));
                      // this.props.onChangePage(e.target.dataset.id);
                      this.props.onChangePage(id);
                    }.bind(this, data[i].id)}>
                    {data[i].title}
                  </a>
                </li>);
    }
    return(
      <nav>
        <ul>
          {lists}
        </ul>
      </nav>
    );
  }
}
export default TOC;