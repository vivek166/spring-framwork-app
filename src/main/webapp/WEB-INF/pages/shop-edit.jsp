<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
   <h1>Edit team page</h1>
<p>Here you can edit the existing team.</p>
<p>${message}</p>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/edit/${team.id}.html">
<table>
<tbody>
    <tr>
        <td>Name:</td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td>Rating:</td>
        <td><form:input path="rating" /></td>
    </tr>
    <tr>
        <td><input type="submit" value="Edit" /></td>
        <td></td>
    </tr>
</tbody>
</table>
</form:form>
 
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>