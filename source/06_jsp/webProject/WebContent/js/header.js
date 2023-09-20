// header Top guide Function
window.addEventListener("scroll", function () {
  var header = document.getElementById("header");
  if (window.pageYOffset > 0) {
    header.classList.add("fixed-header");
  } else {
    header.classList.remove("fixed-header");
  }
});
// scroll 했을 때 header 메뉴 축소
window.addEventListener("scroll", function () {
  var lnb = document.getElementById("lnb");
  var gnb = document.getElementById("gnb");
  
  // 스크롤 위치를 확인하여 lnb와 gnb를 조절
  if (window.pageYOffset > 100) { // 스크롤 위치 조정 필요
    lnb.style.display = "none"; // lnb 숨김
    gnb.style.display = "block"; // gnb 표시
  } else {
    lnb.style.display = "flex"; // lnb 표시
    gnb.style.display = "block"; // gnb 숨김
  }
});