<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Student For Exam:</title>
</head>
<body>
<h1>Select Student For Exam:</h1>
<!--  Note: Lesson learned. Had to prefix the action with "Student" as we had duplicate actions with other
	classes (eg classrooms) -->
	<c:forEach items="${selectedStudents}" var="student" varStatus="row">
		<form method="post" action="Student${student.student_id}">
			<input name="_method" type="hidden" value="post"> 
			<input name="select" type="submit" value="Select">  
			${student.student_id}. ${student.firstname} ${student.lastname}, Is Selected: ${student.isselected}
		</form>
	</c:forEach>
  
<form method="post" action="StartTest">
	<input name="create" type="submit" value="Start Test">
</form>
</body>
</html>