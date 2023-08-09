"use strict";

// 동적인 부분(DB연동 x) - javascript 문법
var name = prompt("이름입력 : ", "홍길동"); //취소 클릭 시, 'null' return

if (name != "null" && name != "") {
  document.write(name + " 반갑습니다.<br>");
}