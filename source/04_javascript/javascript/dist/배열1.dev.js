"use strict";

// 특정 요소 지움 : arr.splice(n, m)
var arr = [1, 2, 3, 4, 5];
arr.splice(1, 2);
console.log(arr); // 특정 요소 지우고 추가

var arr1 = [1, 2, 3, 4, 5];
arr1.splice(1, 3, 100, 2000);
console.log(arr1); // 삭제된 요소를 반환

var arr2 = [1, 2, 3, 4, 5];
var result = arr2.splice(1, 2);
console.log(arr2);
console.log(result); // n ~ m 까지 반환 : arr.slice(n, m)

var arr3 = [1, 2, 3, 4, 5];
console.log(arr3.slice(1, 4));