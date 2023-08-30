// class : ECMAScript 6이상을 지원하는 브라우저에서만 가능
// http://caniuse.com/ 사이트를 이용하여 지원 브라우저 확인.
class Person {
  constructor(name, first, second) { // 생성자 함수의 이름은 무조건 constructor
    console.log('생성자 함수 호출');
    this.name = name;
    this.first = first;
    this.second = second;
  };
  sum() {
  return this.first + this.second;
  };
};
var kim = new Person('kim', 10, 20);
console.log(kim.name, ',', kim.first, ',', kim.second, ',', kim.sum());
// 전체 sum 변경
Person.prototype.sum = function() {
  return '수정된 sum : ' + (this.first + this.second);
};

console.log(kim.name, ',', kim.first, ',', kim.second, ',', kim.sum());

var lee = new Person('lee', 30, 40);
console.log(lee.name, ',', lee.first, ',', lee.second, ',', lee.sum());