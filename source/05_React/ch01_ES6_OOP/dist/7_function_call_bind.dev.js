"use strict";

// function call & bind
var hong = {
  name: 'hong',
  first: 10,
  second: 20
};
var shin = {
  name: 'shin',
  first: 30,
  second: 40
};
first = 100;
second = 99;

function sum() {
  var prefix = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : ' : ';
  return prefix + (this.first + this.second);
}

console.log('외부 변수의 합 sum()', sum());
console.log('외부 변수의 합 sum("-")', sum('-')); // call

console.log('hong의 합 sum.call(hong)', sum.call(hong)); // sum 내부의 this가 hong으로 인식된다.

console.log('hong의 합 sum.call(hong, "=")', sum.call(hong, "="));
console.log('shin의 합 sum.call(shin, "~")', sum.call(shin, "~")); // bind

var hongSum = sum.bind(hong); // this를 hong으로 하는 새로운 함수

console.log('bind를 이용한 hong의 합 ' + hongSum());
var shinSum = sum.bind(shin, '='); // 매개변수(prefix : '=')를 추가

console.log('bind를 이용한 shin의 합 ' + shinSum());