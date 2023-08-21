// Symbol.for : 전역심볼
// 하나의 심볼만 보장받을 수 있음
// 없으면 만들고, 있으면 가져옴
// Symbol 함수는 매번 다른 값을 가져오지만
// Symbol.for 메소드는 하나를 생성 후 키를 통해 같은 심볼을 공유함
const id1 = Symbol.for('id');
const id2 = Symbol.for('id');

console.log(id1 == id2);

console.log(Symbol.keyFor(id1));
// keyfor() 는 생성한 값을 알려줌


//ex.
// 다른 개발자가 만들어 놓은 객체
const user = {
  name :'Mike',
  age : 30,
};

// 내가 만든 객체
const showName = Symbol("show name");
user[showName] = function () {
  console.log(this.name);
};

user[showName] ();

// 사용자가 접속하면 보는 메세지
for (let key in user) {
  console.log(`His ${key} is ${user[key]}.`);
}


