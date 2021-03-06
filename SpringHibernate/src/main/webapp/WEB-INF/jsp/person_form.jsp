<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Save Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<springForm:form method="POST" modelAttribute="person">
	<table>
		<tr>
			<td>Name : </td>
			<td><springForm:input path="name"/></td>
			<td><springForm:errors path="name" cssClass="error"></springForm:errors></td>
		</tr>
		
		<tr>
			<td>Email : </td>
			<td><springForm:input path="email"/></td>
			<td><springForm:errors path="email" cssClass="error"></springForm:errors></td>
		</tr>
		
		<tr>
			<td>Phone : </td>
			<td><springForm:input path="phone"/></td>
			<td><springForm:errors path="phone" cssClass="error"></springForm:errors></td>
		</tr>
		<tr>
			<td>Gender : </td>
			<td>
				<springForm:select path="gender">
					<springForm:option value="" label="Select Gender"></springForm:option>
					<springForm:option value="Male" label="Male"></springForm:option>
					<springForm:option value="Female" label="Female"></springForm:option>
				</springForm:select>
			</td>
			<td><springForm:errors path="gender" cssClass="error"></springForm:errors></td>
		</tr>
		<tr>
			<td>Birthday : </td>
			<td><springForm:input path="birthday" placeholder="dd/MM/yyyy"/></td>
			<td><springForm:errors path="birthday" cssClass="error"></springForm:errors></td>
		</tr>
		
		<tr>
				<td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
         </tr>
	</table>
</springForm:form>
</body>
</html>