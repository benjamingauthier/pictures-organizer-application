<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
   
<c:forEach var="catalogue" items="${catalogues}">
	<c:forEach var="photos" items="${catalogue.value.getListPhoto()}">
		<c:forEach var="photo" items="${photos}">
			<li>
				<img style="width:100%" src=" data/${photo.value.getSource() }"> 
			</li>
		</c:forEach>
	</c:forEach>
</c:forEach>
</body>
</html>