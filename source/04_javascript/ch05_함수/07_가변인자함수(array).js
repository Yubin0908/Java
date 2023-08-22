// array 함수 : 매개변수가 0개 일때 > length가 0인 배열을 return
//              매개변수가 1개 일때 > length가 매개변수만큼의 크기를 가지는 배열을 return
//              매개변수가 2개 이상 일때는 매개변수로 배열을 생성하여 return

array(1,'hi');
function array() { //arguments 배열에 실행시의 매개변수 들어옴
  let result = [];
  if(arguments.length==1) { //length가 arguments[0]인 배열 : array(3)
    for(let cnt=1; cnt<=arguments.length[0]; cnt++) {
      result.push(null);
    }
  } else if(arguments.length>=2) { //arguments[0], arguments[1] ... 을 배열로 : array(1,2,3)
    for(let idx=0; idx<arguments.length; idx++){ // arguments는 시스템이 자동 생성한 배열 : 일반for문, for-in문
      result.push(arguments[idx]);
    }
  }
  return result;
};

arr1 = array();
arr2 = array(3);
arr3 = array(273, 2, 'hello');
arr4 = array(273, 2, 2, 3, 'hi');

console.log('arr1(빈배열)', arr1);
console.log('arr2 = ', arr2);
console.log('arr3 = ', arr3);
console.log('arr4 = ', arr4);