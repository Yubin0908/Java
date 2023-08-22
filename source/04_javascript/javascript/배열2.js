// arr.sort() : 배열 재정렬
// 숫자형 정렬
let arr = [1,5,4,2,3];

arr.sort();

console.log(arr);
// 문자열 정렬
let arrStr = ['a', 'c', 'd', 'e', 'b'];

arrStr.sort();

console.log(arrStr);
// 인수로 정렬 로직을 담은 함수를 받음
let arr1 = [27, 8, 5, 13];

function fn(a,b) {
  return a-b;
};

arr1.sort(fn);

console.log(arr1);

// arr.reduce() : 인수로 함수를 받음
// (누적 계산값, 현재값) => { return 계산값 };

// let result = 0 ;

// arr.forEach(num => {
//   result += num;
// });

// console.log(result);

const result = arr.reduce((prev, cur) => {
  return prev + cur;
}, 0);

console.log(result);

// ex. 19세 이상 성인만 출력
let userList = [
  {name: 'Mike', age:30},
  {name: 'Tom', age:10},
  {name: 'Jane', age:27},
  {name: 'Sue', age:26},
  {name: 'Harry', age:42},
  {name: 'Steve', age:60},
];

let result1 = userList.reduce((prev, cur) => {
  if (cur.age > 19) {
    prev.push(cur.name);
  }
  return prev;
}, []);

console.log(result1);
