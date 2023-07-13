<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/orderTicket.css"/>
    </head>
    <body>
        <c:set var="orderTicket" value="${requestScope.orderTicket}" />

        <div class="container-fluid">
            <div class="card">
                <div class="card-header">
                    <h1>Order Ticket Management</h1>

                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered" style="background: white">
                            <thead>
                                <tr style="background: #F44D06; color: white">
                                    <th>Order ID</th>
                                    <th>User ID</th>
                                    <th>Date</th>
                                    <th>Promotion ID</th>
                                    <th>Tax</th>
                                    <th>Total Amount</th>
                                    <th>Is Confirmed</th>
                                    <th>Delete Order Ticket</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${orderTicket}" var="orderTicket">
                                    <tr>
                                        <td>${orderTicket.getOrderID()}</td>
                                        <td>${orderTicket.getUserID()}</td>
                                        <td>${orderTicket.getDate()}</td>
                                        <td>${orderTicket.getPromotionID()}</td>
                                        <td>${orderTicket.getTax()}</td>
                                        <td>${orderTicket.getTotalAmount()}</td>
                                        <td><c:choose>
                                                <c:when test="${orderTicket.getIsConfirmed() eq 'false'}">
                                                    <a href="ConfirmServlet?orderTicketID=${orderTicket.getOrderID()}" class="btn btn-info" role="button" style="background: #F44D06; color: white">Confirm</a>
                                                </c:when>
                                                <c:otherwise>
                                                    ${orderTicket.getIsConfirmed()}
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:if test="${orderTicket.getIsConfirmed() eq 'false'}">
                                                <a href="DeleteOrderTicketServlet?orderTicketID=${orderTicket.getOrderID()}" class="btn btn-info" role="button" style="background: #F44D06; color: white">Delete</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div> 
        </div>
    </form>
</body>
</html>
