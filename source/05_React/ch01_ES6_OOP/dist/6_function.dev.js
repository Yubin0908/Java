"use strict";

function sum() {
  var x = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 10;
  var y = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 20;
  // x, y 초기값 설정가능.
  return x + y;
}

console.log('sum(10,2) : ' + sum(10, 2));
console.log('sum(10) : ' + sum(10));
console.log('sum() : ' + sum());