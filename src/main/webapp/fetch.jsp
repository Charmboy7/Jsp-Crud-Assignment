<jsp:include page="include/header.jsp"/>
<%@page import="entity.User"%>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
        /* Add CSS styles for table */
        table {
            width: 100%;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        /* Add more styles as desired */
    </style>
    <script>
function confirmdelete(){
	if(confirm("Are you sure you want to delete")){
		return true;
	}
	else
		{
		return false;
		}
}
</script>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>User Id</th>
                <th>User Name</th>
                <th>User Email</th>
                <th>Phone Number</th>
                <th>Designation</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<User> userlist = (List<User>) request.getAttribute("listusers");
                if (userlist != null) {
                    for (User _user : userlist) {
            %>
                       <tr>
                          <td><%= _user.getUser_id() %></td>
                          <td><%= _user.getUsername() %></td>
                          <td><%= _user.getAge() %></td>
                          <td><%= _user.getPhonenumber() %></td>
                          <td><%= _user.getDesignation() %></td>
                       </tr>

                     
            <% 
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
<jsp:include page="include/footer.jsp"/>