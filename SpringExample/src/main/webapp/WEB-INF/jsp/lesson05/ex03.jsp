<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 라이브러리</title>
</head>
<body>
	<h1>1. 숫자 출력</h1>
	<c:set var="number" value="12345678" />
	<!-- set으로 변수 저장 var : 변수명 , />으로 저장 -->
	<!-- 12,345,678 이런식으로 ,로 나뉘어짐 -->
	<fmt:formatNumber value="${number}" />
	
	<h3>Type</h3>
	<%-- number --%>
	숫자 : <fmt:formatNumber value="${number}" type="number" /><br>
	숫자 3자리마다 콤마 제거 : <fmt:formatNumber value="${number}" type="number" groupingUsed = "false" /><br>
	
	<%-- percent --%>
	100%: <fmt:formatNumber type="percent" value="1" /><br>
	40%: <fmt:formatNumber type="percent" value="0.4" /><br>
	
	<%-- currency(통화) --%>
	통화(원): <fmt:formatNumber type="currency" value="${number}" /><br>
	통화(달러): <fmt:formatNumber type="currency" value="${number}" currencySymbol="$" /><br>
	
	<h3>Pattern</h3>
	
	3.14: <fmt:formatNumber value="3.14" /><br>
	<%--소수점 아래 자리 숫자를 맞춰줌 --%>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000" /><br>
	<%-- 소수점 아래 수가 0이면 생략하겠다. --%>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####" /><br>
	3.141592653(#.####): <fmt:formatNumber value="3.141592653" pattern="#.####" /><br>
	
	<hr>
	
	<h1>Date 객체를 String 형태로 출력(fmt:formatDate)</h1>
	Date: ${now}><br>
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /><br>
	
	<%-- 바로 출력 안하고 pt2라는 변수에 담았다가 내가 원하는 때에 출력 --%>
	<fmt:formatDate value="${now}" pattern="yyyy/MM/dd HH:mm:ss" var="pt2" /><br>
	pt2: ${pt2}
	
	<h1>String을 Date 객체로 변환(fmt:parseDate)</h1>
	<fmt:parseDate value="${pt2}" pattern="yyyy/MM/dd HH:mm:ss" /><br>
	
</body>
</html>