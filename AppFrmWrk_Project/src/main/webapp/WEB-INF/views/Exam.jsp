<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Questions:</title>
</head>
<body>
<h1>Exam:</h1>

	<c:forEach items="${selectedQuestions}" var="question" varStatus="row">
		<form method="post" action="${question.question_id}">
			<input name="_method" type="hidden" value="delete"> 
			Question:${row.index+1}<br>Question: ${question.questiontext}
			<br>Answer 1:${question.questiontext}<br>Answer 2:${question.answer2}
			<br>Answer 3:${question.answer1}<br>Answer 4:${question.answer4}
			Correct Answer:<input name="answer" type="text" value=""> <br>
			<br><input name="Submit" type="submit" value="Delete Q${row.index+1}"> 
		</form>
	
	</c:forEach>

</body>
</html>