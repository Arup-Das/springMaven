<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Hibernate</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Persons</h2>  
    <table>
        <tr>
            <td>NAME</td><td>Email</td><td>Phone</td><td>Gender</td><td>BirthDay</td>
        </tr>
        <c:forEach items="${persons}" var="person">
            <tr>
            <td>${person.name}</td>
            <td>${person.email}</td>
            <td>${person.phone}</td>
            <td>${person.gender}</td>
            <td>${person.birthday}</td>
            <td><a href="<c:url value='/edit-${person.id}-person' />"><img alt="edit" src='<c:url value = "/images/edit.png"/>' height="25" width="25"></a></td>
            <td><a href="<c:url value='/delete-${person.id}-person' />"><img alt="delete" src='<c:url value = "/images/delete.png"/>' height="25" width="25"></a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/newperson' />">Add New Person</a>
</body>
</html>
