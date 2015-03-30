<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1>Classes:</h1>
<c:forEach items="${classes}" var="class1" varStatus="row">
${row.index}. ${class1.class_name} <br />
</c:forEach>
</html>