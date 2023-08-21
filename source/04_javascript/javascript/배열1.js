// 특정 요소 지움 : arr.splice(n, m)
let arr = [1,2,3,4,5];
arr.splice(1,2);

console.log(arr);

// 특정 요소 지우고 추가
let arr1 = [1,2,3,4,5]
arr1.splice(1,3,100,2000);
console.log(arr1);

// 삭제된 요소를 반환
let arr2 = [1,2,3,4,5];

let result = arr2.splice(1,2);

console.log(arr2)
console.log(result)

// n ~ m 까지 반환 : arr.slice(n, m)
let arr3 = [1,2,3,4,5];
console.log(arr3.slice(1,4));

// 기존 배열들을 합쳐서 새배열로 반환 : arr.concat(arr1, arr2)
let arrall = [1,2];

console.log(arrall.concat([3,4]));
console.log(arrall.concat([3,4],[5,6]));

// 배열 반복 : forEach
let arr4 = ['Mike', 'Tom', 'Jane'];

arr4.forEach((name, index) => {console.log(`${index + 1}. ${name}`)
});