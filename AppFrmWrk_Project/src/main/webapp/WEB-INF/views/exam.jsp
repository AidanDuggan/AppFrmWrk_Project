<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Step 3) Answer Exam Questions</title>
</head>
<body>
<form method="GET" action="StudentPage">
	<input name="create" type="submit" value="Back">
</form>
<h1>Step 3) Answer Exam Questions</h1>

	<table>
	<col width="20%">
  	<col width="80%">
	<c:forEach items="${selectedQuestions}" var="question" varStatus="row">
		<form method="post" action="InsertAnswer">
		<tr>
    		<td>Question:${row.index+1}: </td>
			<td>${question.questiontext}</td>
		</tr>
		<tr>
			<td>Answer 1:</td>
			<td>${question.answer1}</td>
		</tr>
		<tr>
			<td>Answer 2:</td>
			<td>${question.answer2}</td>
		</tr>
		<tr>
			<td>Answer 3:</td>
			<td>${question.answer3}</td>
		</tr>
		<tr>
			<td>Answer 4:</td>
			<td>${question.answer4}</td>
		</tr>
		<tr>
			<td>Choose An Answer:</td>
			<td>
			<input name="answerQ${question.question_id}" type="text" value="">
			</td>
		</tr>
		<tr><td>-<td/></tr>
		</form>
	</c:forEach>
	</table>
	<input name="Submit" type="submit" value="Submit">
</body>
</html>