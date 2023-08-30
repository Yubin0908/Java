class Person {
  constructor(name, first, second) { // 생성자 함수의 이름은 무조건 constructor
  //  console.log('생성자 함수 호출');
    this.name = name;
    this.first = first;
    this.second = second;
  };
  sum() {
  return this.first + this.second;
  };
};

var hong = new Person('홍길동', 10, 20);
console.log('hong의 sum : ' + hong.sum());

// 새로운 클래스(상속)
class PersonPlus extends Person {
  constructor(name, first, second, third) {
    super(name, first, second); // super() : 부모 클래스 생성자 함수
    this.third = third;
  };
  sum() {
    return super.sum() + this.third; // super.sum() : 부모클래스의 sum()
  };
  avg() {
    return this.sum() / 3;
  }
};

var hong = new Person('홍길동', 100, 90);
console.log('hong의 sum : ' + hong.sum());
var son = new PersonPlus('손흥민', 100, 100, 100);
console.log('son의 sum : ' + son.sum());
console.log('son의 avg :'+ son.avg());

