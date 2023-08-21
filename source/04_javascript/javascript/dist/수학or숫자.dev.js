"use strict";

// toString()
// 숫자를 문자로 변환
var num = 10;
console.log(num.toString()); // 2진수로 변환

console.log(num.toString(2)); // 16진수로 변환

console.log(num.toString(16));
var num2 = 255;
console.log(num2.toString(16));
console.log(Math.PI); // 올림

console.log(Math.ceil(5.1));
console.log(Math.ceil(5.7)); // 내림

console.log(Math.floor(5.1));
console.log(Math.floor(5.1)); // 반올림

console.log(Math.round(5.1));
console.log(Math.round(5.7)); // 소수점 자릿수
// rate : 소수점 둘째자리 까지 표현 (셋째 자리에서 반올림)

var userRate = 30.1234;
console.log(Math.round(userRate * 100) / 100); // 소수점을 int로 받아 변환 : toFixed()

console.log(userRate.toFixed(2));
console.log(userRate.toFixed(0));
console.log(userRate.toFixed(6)); //toFixed는 문자로 반환하므로 계산 할때 숫자형으로 변환이 필요함.
// 문자형을 숫자로 반환 : parseInt()

var margin = '10px';
console.log(parseInt(margin));
console.log(Number(margin)); // 문자형을 부동소수점으로 반환 : parseFloat()

var padding = '18.5%';
console.log(parseInt(padding));
console.log(parseFloat(padding)); // 랜덤 숫자 생성 random()

console.log(Math.floor(Math.random() * 100) + 1); // 최솟값, 최댓값 반환 : min(), max()

console.log(Math.max(1, 4, -1, 5, 10, 9, 5.54));
console.log(Math.min(1, 4, -1, 5, 10, 9, 5.54)); // 절대값 : abs()

var num1 = -1;
console.log(Math.abs(num1));
console.log(Math.abs(num1) == 1); // 제곱 : pow()

console.log(Math.pow(2, 10));