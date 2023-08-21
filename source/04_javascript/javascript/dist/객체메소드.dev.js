"use strict";

// Object.assign() : 객체 복제
var user1 = {
  name: 'Mike',
  age: 30
};
console.log(user1);
var newUser = Object.assign({}, user1);
console.log(newUser); // Object.key() : 키 배열 반환

var user2 = {
  name: 'Mike',
  age: 30,
  gender: 'male'
};
Object.keys(user2);
console.log(Object.keys(user2)); // Object.values() : 값 배열 반환

console.log(Object.values(user2)); // Object.entries() : 키/값 배열 반환

console.log(Object.entries(user1)); // Object.fromEntries() : 키/값 배열을 객체로 변환

var arr = [["name", "Mike"], ["age", 30], ["gender", "male"]];
console.log(Object.fromEntries(arr));