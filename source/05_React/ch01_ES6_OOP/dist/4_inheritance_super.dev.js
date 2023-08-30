"use strict";

function _typeof(obj) { if (typeof Symbol === "function" && typeof Symbol.iterator === "symbol") { _typeof = function _typeof(obj) { return typeof obj; }; } else { _typeof = function _typeof(obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; }; } return _typeof(obj); }

function _possibleConstructorReturn(self, call) { if (call && (_typeof(call) === "object" || typeof call === "function")) { return call; } return _assertThisInitialized(self); }

function _assertThisInitialized(self) { if (self === void 0) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return self; }

function _get(target, property, receiver) { if (typeof Reflect !== "undefined" && Reflect.get) { _get = Reflect.get; } else { _get = function _get(target, property, receiver) { var base = _superPropBase(target, property); if (!base) return; var desc = Object.getOwnPropertyDescriptor(base, property); if (desc.get) { return desc.get.call(receiver); } return desc.value; }; } return _get(target, property, receiver || target); }

function _superPropBase(object, property) { while (!Object.prototype.hasOwnProperty.call(object, property)) { object = _getPrototypeOf(object); if (object === null) break; } return object; }

function _getPrototypeOf(o) { _getPrototypeOf = Object.setPrototypeOf ? Object.getPrototypeOf : function _getPrototypeOf(o) { return o.__proto__ || Object.getPrototypeOf(o); }; return _getPrototypeOf(o); }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function"); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, writable: true, configurable: true } }); if (superClass) _setPrototypeOf(subClass, superClass); }

function _setPrototypeOf(o, p) { _setPrototypeOf = Object.setPrototypeOf || function _setPrototypeOf(o, p) { o.__proto__ = p; return o; }; return _setPrototypeOf(o, p); }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var Person =
/*#__PURE__*/
function () {
  function Person(name, first, second) {
    _classCallCheck(this, Person);

    // 생성자 함수의 이름은 무조건 constructor
    //  console.log('생성자 함수 호출');
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
var hong = new Person('홍길동', 10, 20);
console.log('hong의 sum : ' + hong.sum()); // 새로운 클래스(상속)

var PersonPlus =
/*#__PURE__*/
function (_Person) {
  _inherits(PersonPlus, _Person);

  function PersonPlus(name, first, second, third) {
    var _this;

    _classCallCheck(this, PersonPlus);

    _this = _possibleConstructorReturn(this, _getPrototypeOf(PersonPlus).call(this, name, first, second)); // super() : 부모 클래스 생성자 함수

    _this.third = third;
    return _this;
  }

  _createClass(PersonPlus, [{
    key: "sum",
    value: function sum() {
      return _get(_getPrototypeOf(PersonPlus.prototype), "sum", this).call(this) + this.third; // super.sum() : 부모클래스의 sum()
    }
  }, {
    key: "avg",
    value: function avg() {
      return this.sum() / 3;
    }
  }]);

  return PersonPlus;
}(Person);

;
var hong = new Person('홍길동', 100, 90);
console.log('hong의 sum : ' + hong.sum());
var son = new PersonPlus('손흥민', 100, 100, 100);
console.log('son의 sum : ' + son.sum());
console.log('son의 avg :' + son.avg());