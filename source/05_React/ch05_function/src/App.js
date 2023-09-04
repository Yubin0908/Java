import { useState } from 'react';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import ReadContent from './components/ReadContent';
import Subject from './components/Subject';
import TOC from './components/TOC';
import UpdateContent from './components/UpdateContent';

let maxId = 3; // 전역변수

function App() {
  // 변수의 값이 바뀌면 rendering이 이루어져야할 변수(hook이용 cf.class컴포넌트에서는 state)
  // const _mode = useState('read');
  // const mode = _mode[0];
  // const setMode = _mode[1]; // 상태(mode)값을 변경할 때 사용할 함수
  const [mode, setMode] = useState('welcome');
  const [selectedId, setSelectedId]  = useState(0);
  const [contents, setContents] = useState(
    [
      {id:1, title:'HTML', desc:'HTML is HyperText Markup Langauge.'},
      {id:2, title:'CSS', desc:'CSS is for design.'},
      {id:3, title:'JS', desc:'JS is for interactive.'},
    ]
  );
  // redering과 무관한 변수
  const subject = "WEB";
  const welcome = {title:'Welcome', desc:'Hello, React!!'};
  let _article, _content =null;
  let getReadContent = () => {
    for(var i=0 ; i<contents.length ; i++){
      if(contents[i].id === selectedId){
        return contents[i];
      }
    }
  };//getReadContent함수
  if(mode === 'welcome'){
    _article = <ReadContent title={welcome.title} desc={welcome.desc}></ReadContent>
  }else if(mode === 'read'){
    _content = getReadContent();
    // console.log('아래 출력될 content 객체 :', _content);
    _article = <ReadContent title={_content.title} desc={_content.desc}></ReadContent>
  }else if(mode === 'create'){
    _article = <CreateContent
                  onCreate={(_title, _desc) => {
                    _content = {id:++maxId, title:_title, desc:_desc};
                  //  console.log('추가할 데이터 : ', _content);
                  let _contents = Array.from(contents); //copy contents
                  _contents.push(_content);
                  setContents(_contents);
                  setMode('read');
                  setSelectedId(maxId);
                  }}
              ></CreateContent>
  }else if(mode === 'update'){
    if(selectedId === 0){
      _article = <h4>수정할 데이터를 선택 후 Update 기능을 이용하세요.</h4>
    } else {
        _content = getReadContent();
        _article = <UpdateContent
                      data={_content}
                      onUpdate = {(_id, _title, _desc) => {
                        _content = {id:_id, title:_title, desc:_desc};
                      let _contents = Array.from(contents); //copy contents
                      for(var i=0 ; i<_contents.length ; i++){
                        if(_contents[i].id === _id){
                        _content[i].title = _title;
                        _content[i].desc = _desc;
                        break;
                        }
                      }
                      setContents(_contents);
                      setMode('read');
                      }}
                      ></UpdateContent>
      }
    }

  return (
    <>
      <Subject
        title={subject}
        onChangePage = {() => {
          //alert('welcome 모드로');
          //mode = 'welcome'; // 랜더링 안 이루어짐
          setMode('welcome');
          setSelectedId(0);
        }}
      ></Subject>
      <TOC
        data={contents}
        onChangePage = {_id => {
          setMode('read');
          setSelectedId(_id);
        }}
      ></TOC>
      <Control
        onChangeMode = {_mode => {
        //  alert(_mode);
        if(mode === 'delete'){
          // logic for delete
          if(selectedId !== 0 && window.confirm('삭제시 복구 불가. 삭제하시겠습니까?')){
            let _contents = Array.from(contents); //copy contents
            for(var idx=0; idx<_contents.length ; idx++){
              if(_contents[idx].id === selectedId){
                // delete data = _contents[idx];
                _contents.splice(idx, 1); //idx번째 1개 제거
                setContents(_contents);
                if(_contents.length > 0){
                  setMode('read');
                  setSelectedId(_contents[0].id);
                } else {
                  setMode('welcome');
                  setSelectedId(0);
                }
                break;
              }
            }
          } else if(selectedId === 0) {
            alert('삭제할 데이터를 선택한 후 삭제해주세요.');
          }
        } else {
          setMode(_mode);
        }
        }}></Control>
      {_article}
    </>
  );
}
export default App;