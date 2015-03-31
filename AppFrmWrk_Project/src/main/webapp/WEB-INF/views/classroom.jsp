<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Step 1) Select Class For Exam:</title>
</head>
<body>
<h1>Step 1) Select Class For Exam:</h1>
<!-- 
<form method="post" action="../classroom/">
	<input name="text" type="text" value=""> <input name="create"
		type="submit" value="Create">
</form>
 -->
  
<!-- 
<form method="put" action="../classroom/">
	<input name="text" type="text" value=""> <input name="updateSelected test"
		type="submit" value="Select">
</form>
  -->
  
<!--
<c:forEach items="${classrooms}" var="classroom" varStatus="row">
	 ${row.index}. ${classroom.class_name} <br />
	</form>
</c:forEach>
-->

<!--  need to fix this as can only seem to use value="delete" at the moment - want to use "update" -->
	<c:forEach items="${classrooms}" var="classroom" varStatus="row">
		<form method="post" action="Class${classroom.classroom_id}">
			<input name="_method" type="hidden" value="post"> 
			<input name="select" type="submit" value="Select" >  
			${classroom.classroom_id}. ${classroom.class_name}  ${classroom.isselected}
		</form>
	</c:forEach>

	<br> or <br>
<form method="GET" action="QuestionPage">
	<input name="create" type="submit" value="Enter/View All Questions">
</form>
	<!--
	<c:forEach items="${classrooms}" var="classroom" varStatus="row">
	 ${row.index}. ${classroom.class_name} <br />
	</form>
 
	<form method="post" action="${classroom.classroom_id}">
		<input name="_method" type="hidden" value="delete"> <input
			name="delete" type="submit" value="Delete"> ${row.index}.
		 ${classroom.class_name}
	</form>
</c:forEach>
	 -->

</body>
</html>