"use strict";

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

// class : ECMAScript 6이상을 지원하는 브라우저에서만 가능
// http://caniuse.com/ 사이트를 이용하여 지원 브라우저 확인.
var Person =
/*#__PURE__*/
function () {
  function Person(name, first, second) {
    _classCallCheck(this, Person);

    // 생성자 함수의 이름은 무조건 constructor
    console.log('생성자 함수 호출');
    this.name = name;
    this.first = first;
    this.second = second;
  }

  _createClass(Person, [{
    key: "sum",
    value: function sum() {
      return this.first + this.second;
    }
  }]);

  return Person;
}();

;
var kim = new Person('kim', 10, 20);
console.log(kim.name, ',', kim.first, ',', kim.second, ',', kim.sum()); // 전체 sum 변경

Person.prototype.sum = function () {
  return '수정된 sum : ' + (this.first + this.second);
};

console.log(kim.name, ',', kim.first, ',', kim.second, ',', kim.sum());
var lee = new Person('lee', 30, 40);
console.log(lee.name, ',', lee.first, ',', lee.second, ',', lee.sum());