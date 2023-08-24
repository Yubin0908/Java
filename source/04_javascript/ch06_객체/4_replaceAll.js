/*var str = '안녕00방가00좋은 수요일00내일은 목요일';
console.log('원본 : ', str);
var splitStr = str.split('00');
console.log(splitStr);
var joinStr = splitStr.join('x');
console.log(joinStr);*/

function replaceAll(str, oldStr, newStr) { // str 안에 oldStr을 newStr로 교체한 문자를 return
//  let splitStr = str.split(oldStr);
//  let joinResult = splitStr.join(newStr);
//  return joinResult;
  return str.split(oldStr).join(newStr);
}

// var replaceStr = replaceAll('안녕xx방가xx잘가', 'xx', ', ')

// console.log(replaceStr);