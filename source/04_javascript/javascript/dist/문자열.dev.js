"use strict";

// length() : 문자열 길이
var desc = '안녕하세여.';
console.log(desc.length); // 특정 문자 반환

console.log(desc[2]); // 대소문자 변환

var eng = "Hi Guys. Nice to meet you.";
console.log(eng.toUpperCase());
console.log(eng.toLowerCase()); // str.substring(n, m) : n과 m 사이 문자 반환

console.log(desc.substring(2, 5));
console.log(desc.substring(5, 2)); // str.substr(n, m) : n에서 m개를 반환

console.log(desc.substr(2, 4));
console.log(desc.substr(-4, 2)); // ex.

var list = ["01, 들어가며", "02, JS의 역사", "03, 자료형", "04, 함수", "05, 배열"];
var newList = [];

for (var i = 0; i < list.length; i++) {
  newList.push(list[i].slice(4));
}

console.log(newList);