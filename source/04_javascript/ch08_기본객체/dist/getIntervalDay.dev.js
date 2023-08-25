"use strict";

// let now = new Date();
// let openday = new Date(2023, 5, 26, 9, 30, 0);
Date.prototype.getIntervalDay = function (that) {
  // now.getIntervalDay(openday) : now는 this, openday는 that

  /*  if (this > that) {
      var intervalMiliseconds = this.getTime() - that.getTime() / 1000;
    } else {
      var intervalMiliseconds = that.getTime() - this.getTime() / 1000;
    } */
  var intervalMillisec = Math.abs(this.getTime() - that.getTime());
  return Math.trunc(intervalMillisec / (1000 * 60 * 60 * 24));
}; // console.log('now ~ openday 날짜 : ' + now.getIntervalDay(openday));
// console.log('now ~ openday 날짜 : ' + openday.getIntervalDay(now));