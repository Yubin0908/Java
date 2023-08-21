// 유일한 식별자 생성.
const id = Symbol('id');
const id2 = Symbol('id');
const user = {
  name : 'Mike',
  age : 30,
  [id] : 'myid'
}

console.log(Object.keys(user));
console.log(Object.values(user));
console.log(Object.entries(user));

console.log(id == id2);