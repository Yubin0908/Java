"use strict";

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

// 유일한 식별자 생성.
var id = Symbol('id');
var id2 = Symbol('id');

var user = _defineProperty({
  name: 'Mike',
  age: 30
}, id, 'myid');

console.log(Object.keys(user));
console.log(Object.values(user));
console.log(Object.entries(user));
console.log(id == id2);