// map() method를 이용하여 객체 배열을 순환 처리하는 방법
let user = [
  {firstName: 'Susan', lastName: 'Steward'},
  {firstName: 'Daniel', lastName: 'Longbottom'},
  {firstName: 'Michael', lastName: 'Harrison'},
]

let userFullName = user.map(function(element) {
  return `${element.firstName} ${element.lastName}`;
});

console.log(userFullName);

// map() method의 완전한 구문
// arr.map(function(element, index, array) { }, this);
// collback 함수 function은 객 배열 요소에 대해 호출됨,
// map() method는 현재의 element와 그것의 index 

// map() method의 this 인수에 숫자 값 할당하기
let arr = [2,3,5,7]

arr.map(function(element, index, array) {
  console.log(this);
}, 80);
