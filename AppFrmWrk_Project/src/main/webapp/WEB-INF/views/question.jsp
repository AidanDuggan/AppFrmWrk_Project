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
<form method="GET" action="ClassRoomPage">
	<input name="create" type="submit" value="Back">
</form>
<h1>Insert New Exam Questions:</h1>

	<form method="post" action="InsertQuestion">
		Question Text:<input name="questiontextin" type="text" value=""> <br>
		Answer 1:<input name="answer1" type="text" value=""> <br>
		Answer 2:<input name="answer2" type="text" value=""> <br>
		Answer 3:<input name="answer3" type="text" value=""> <br>
		Answer 4:<input name="answer4" type="text" value=""><br>
		Correct Answer Number:<input name="correctanswer" type="text" value=""><br>
		Classroom:<input name="classroom_id" type="text" value=""><br>
		 
		<input name="create1"type="submit" value="Insert">
	</form>
	<br><br>
<h1>Current Questions:</h1>

	<c:forEach items="${allQuestions}" var="question" varStatus="row">
		<form method="post" action="${question.question_id}">
			<input name="_method" type="hidden" value="delete"> 
			Question:${row.index+1}<br>Question: ${question.questiontext}
			<br>Answer 1:${question.answer1}<br>Answer 2:${question.answer2}
			<br>Answer 3:${question.answer3}<br>Answer 4:${question.answer4}
			<br>Correct Answer:${question.correctanswer}<br>Classroom ID:${question.classroom_id}
			<br><input name="delete" type="submit" value="Delete Q${row.index+1}"> 
		</form>
	
	</c:forEach>

</body>
</html>