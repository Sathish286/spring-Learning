<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome to SpringMvc
	<!-- <form action="add">
	Enter the first Number:<input type="text" name="num1"><br>
	Enter the second Number:<input type="text" name="num2">
	<input type="submit">
	</form> -->
	
	<form action="addHuman" method="post">
		Enter the id <input type="text" name="id">
		Enter the name<input type="text" name="name">
		<input type="submit">
		</form>
		
		<form action="getHuman" method="get">
		Enter the id:<input type="text" name="id">
		<input type="submit">
		</form>
		
		<form action="getHumanByName" method="get">
		Enter the Name:<input type="text" name="name">
		<input type="submit">
		</form>
</body>
</html>