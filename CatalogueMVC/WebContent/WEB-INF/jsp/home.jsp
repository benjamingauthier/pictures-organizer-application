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
Display all declared fields and their values.

    <ul>
        <c:forEach var="field" items="${b}">
        	<p>Catalogue numero :<c:out value="${field.value.getId()}"></c:out><p>
           	<p>Catalogue titre: <c:out value="${field.value.getTitre()}"></c:out><p>
           	test : <c:out value="${field.value.getListPhoto().get(1).value}"></c:out><p>
           	<c:forEach var="p" items="${field.value.getListPhoto()}">
  				<c:out value="${p.value.getSource()}"></c:out><p>
  			</c:forEach>
        </c:forEach>
    </ul>

<!--<c:forEach var="photo" items="${listPhoto}"> 
	<img src="public/images/${photo.value.getTitre()}" />
</c:forEach>
<c:out value="${message}"/>--->
</body>
</html>