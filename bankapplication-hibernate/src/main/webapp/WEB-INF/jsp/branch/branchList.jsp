<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Branch</title>
<%@ page isELIgnored="false" %>
</head>
<body>
    <a href="/FinalBankApplication/branch/add">Add new Branch</a>

     <table width="100%" border="1">
      <tr>
       <td>ID</td>
       <td>Name</td>
       <td colspan="2">Action</td>
      </tr>
<c:forEach items="${list}" var="branch" >
   <tr>
    <td>${branch.idbranch }</td>
    <td>${branch.name }</td>
    <td>
            <a href="/FinalBankApplication/branch/update/${branch.idbranch }">Update</a>
        </td>
        <td>
         <a href="/FinalBankApplication/branch/delete/${branch.idbranch }">Delete</a>
        </td>
    </tr>
</c:forEach>
</body>
</html>