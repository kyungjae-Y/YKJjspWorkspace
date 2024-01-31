<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="ex04_form03.jsp">form03 으로 이동</a>
	<button onclick="movePage()">form03 으로 이동</button>

	<form action="ex08_form06pro.jsp">
		<input type="number" id="num" name="num" /> <input type="button" id="btn1" value="전송1" /> <input type="submit" value="버튼1" />
		<!-- input type="submit" 기능이 같다 -->
		<button>버튼2</button>
	</form>
	<!-- input type="button" 기능이 같다 -->
	<button onclick="goNextPage()">전송2</button>
</body>
</html>

<script>
	document.querySelector("#btn1").addEventListener("click", goNextPage);

	function movePage() {
		location.href = "ex04_form03.jsp";
	}
	function goNextPage(num) {
		let value = document.querySelector("#num").value;
		location.href = "ex08_form06pro.jsp?num=" + value;
	}
</script>