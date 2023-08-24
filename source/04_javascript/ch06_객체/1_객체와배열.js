/*
* JAVA Source
  class Person {
    private String name;
    private String age;
    public Person(String name, String age) {
      this.name=name;
      this.age=age;
    }
    public void setName(String name) {
      this.name=name;
    }
  }
  Person person = new Person("홍길동", 20);
  person.setName("신길동");
*/

const arr = ['홍길동', 20];
const person = {'name':'홍길동','age':20}; // 객체생성
person.name = '김길동'; // person 객체의 name 변경

console.log(person.name + ' / ' + person.age);
console.log(person['name'], ' / ' , person['age'])
