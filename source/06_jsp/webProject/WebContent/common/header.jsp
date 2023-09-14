<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="<%=conPath %>/css/header.css" rel="stylesheet">
</head>
<body>
	<div id="header">
		<div id="lnb">
			<div class="lnb_left">
				<ul>
					<li><a href="<%=conPath%>/login.jsp">로그인</a></li>
					<li><a href="<%=conPath%>/signin.jsp">회원가입</a></li>
					<li><a href="<%=conPath%>/custom.jsp">고객센터</a></li>
				</ul>
			</div>
			<div class="logo">
				LOGO
			</div>
			<div class="lnb_right">
			</div>
		</div>
		<div id="gnb">
			<div class="gnb_wrap">
				<div class="gnb_menu gnb_about">
					<ul>
						<li><a href="#">멍이랑 냥이랑</a>
							<div class="gnb_depth gnb_depth_01">
								<ul>
									<li><a href="<%=conPath%>/about.jsp">About</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_dog">
					<ul>
						<li><a href="#">강아지</a>
							<div class="gnb_depth gnb_depth_02">
								<ul>
									<li><a href="<%=conPath%>/dog_all.jsp">전체 보기</a></li>
									<li><a href="<%=conPath%>/dog_type.jsp">견종별 보기</a></li>
									<li><a href="<%=conPath%>/dog_loc.jsp">지점별 보기</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_cat">
					<ul>
						<li><a href="#">고양이</a>
							<div class="gnb_depth gnb_depth_03">
								<ul>
									<li><a href="<%=conPath%>/cat_all.jsp">전체 보기</a></li>
									<li><a href="<%=conPath%>/cat_type.jsp">묘종별 보기</a></li>
									<li><a href="<%=conPath%>/cat_loc.jsp">지점별 보기</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_review">
					<ul>
						<li><a href="#">고객 게시판</a>
							<div class="gnb_depth gnb_depth_04">
								<ul>
									<li><a href="<%=conPath%>/interview.jsp">가족 인터뷰</a></li>
									<li><a href="<%=conPath%>/review.jsp">가족 리뷰</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_service">
					<ul>
						<li><a href="#">service</a>
							<div class="gnb_depth gnb_depth_05">
								<ul>
									<li><a href="<%=conPath%>/cat_hotel.jsp">고양이 호텔</a></li>
									<li><a href="<%=conPath%>/dog_hotel.jsp">강아지 호텔</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_system">
					<ul>
						<li><a href="#">system</a>
							<div class="gnb_depth gnb_depth_06">
								<ul>
									<li><a href="<%=conPath%>/notice.jsp">공지사항</a></li>
									<li><a href="<%=conPath%>/before.jsp">사전점검 서비스</a></li>
									<li><a href="<%=conPath%>/sales.jsp">협력업체</a></li>
									<li><a href="<%=conPath%>/after.jsp">사후 서비스</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>