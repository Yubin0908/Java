"use strict";

// 첫글자는 대문자로
function Item(title, price) {
  this.title = title;
  this.price = price;

  this.showPrice = function () {
    console.log("가격은 $(price)원 입니다");
  };
}

var item1 = new Item("인형", 5000);
var item2 = new Item("장갑", 1000);
var item3 = new Item("마스크", 2500);
console.log(item1, item2, item3);
item1.showPrice();