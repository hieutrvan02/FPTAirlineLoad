<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User" %>
<%@page import="Model.dao.UserDAO" %>
<%@page import="DBcontext.DB" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/employeeManagement.css"/>
    </head>
    <body>
        <c:set var="employees" value="${requestScope.employees}" />
        <div class="container-fluid">
            <div class="card">
                <div class="card-header">
                    <h1>Employee Management</h1>
                    <a href="CreateEmployeeServlet" class="btn btn-info" role="button" style="background: #F44D06; color: white">Create employee</a>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered" style="background: white">
                            <thead>
                                <tr style="background: #F44D06; color: white">
                                    <th>User ID</th>
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th>Name</th>
                                    <th>Gender</th>
                                    <th>Birthday</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Nationality</th>
                                    <th>CCCD</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${employees}" var="employee">
                                    <tr>
                                        <td>${employee.getUserID()}</td>
                                        <td>${employee.getEmail()}</td>
                                        <td>${employee.getPassword()}</td>
                                        <td>${employee.getName()}</td>
                                        <td>${employee.getGender()}</td>
                                        <td>${employee.getBirthday()}</td>
                                        <td>${employee.getPhone()}</td>
                                        <td>${employee.getAddress()}</td>
                                        <td>${employee.getNationality()}</td>
                                        <td>${employee.getCccd()}</td>
                                        <td>
                                            <a href="DeleteEmployeeServlet?id=${employee.getUserID()}" class="btn btn-info" role="button" style="background: #F44D06; color: white">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div> 
        </div>
    </body>
</html>
