"use strict";
"usr strict";

var memberArray = ['hong', 'park', 'kim'];
var copyArray = memberArray; // 얕은 복사
// var copyArray = [...memberArray]; // 객체의 깊은 복사

var copyArray = Array.from(memberArray); // 배열의 깊은 복사

copyArray[0] = '홍길동';
copyArray[1] = '박길동';
copyArray[2] = '김길동';
console.group('memberArray for-loop');

for (var i = 0; i < memberArray.length; i++) {
  console.log(i, '번째: ' + memberArray[i]);
}

console.groupEnd('memberArray for-loop');
console.group('copyArray for-loop');

for (var i = 0; i < copyArray.length; i++) {
  console.log(i, '번째: ' + copyArray[i]);
}

console.groupEnd('copyArray for-loop');
var memberObject = {
  name: 'hong',
  age: 20
}; // var copyObject = {...memberObject}; // 객체 복사 시 '{}' 사용
// var copyObject = Object.assign({}, memberObject);
// assign : 복사할 객체를 빈 객체에 복사 memberObject -> {빈 객체}

var copyObject = Object.assign({
  id: 1
}, memberObject); // {id:1, name:hong, age:20}

copyObject.name = '홍길동';
copyObject.age = 30;
console.group('memberObject for-loop');

for (var key in memberObject) {
  console.log(key, ':', memberObject[key]);
}

console.groupEnd('memberObject for-loop');
console.group('copyObject for-loop');

for (var key in copyObject) {
  console.log(key, ':', copyObject[key]);
}

console.groupEnd('copyObject for-loop');