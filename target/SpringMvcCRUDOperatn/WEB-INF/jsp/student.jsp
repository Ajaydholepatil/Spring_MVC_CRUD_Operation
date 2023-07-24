<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Student Page</title>
</head>
<body>
<form:form method="post">
<table>
<tr>
<td>Roll no</td>
<td><form:input path="rno" readonly="true"></form:input></td>
</tr>

<tr>
<td>Student Name </td>
<td><form:input path="name"></form:input></td>

</tr>

<tr>
<td>Qualifiaction </td>
<td><form:input path="qualification"></form:input></td>
</tr>

<tr>
<td>Percentage</td>
<td><form:input path="percentage"></form:input></td>
</tr>

<tr>
<td>
<input type="submit" value="Submit"/>
</td>
</tr>

</table>
</form:form>

<hr/>

<h2>All Students Details</h2>

<table border="1">
<thead>
<tr>
<th>Roll no</th>
<th>Studnet Name</th>
<th>Qualifiaction</th>
<th>Percentage</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="c" items="${student}">
<tr>
<td>${c.rno}</td>
<td>${c.name}</td>
<td>${c.qualification}</td>
<td>${c.percentage}</td>
<td colspan="2">
<a href="/CrudOperation/edit/${c.rno}">Edit</a>
&nbsp;
<a href="/CrudOperation/delete/${c.rno}">Delete</a>
</td>
</c:forEach>
</tbody>
</table>
</body>
</html>
