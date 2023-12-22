<%@ page import="entity.User" %>
<jsp:include page="include/header.jsp"/>

<h1>Home Page</h1>
<% 
User loggedInUser = (User) session.getAttribute("loggedInUser");
if (loggedInUser != null) {
    out.println("Logged In User ID: " + loggedInUser.getUser_id());
    out.println("Name:"+loggedInUser.getUsername());
    out.println("password:"+loggedInUser.getPassword());
    out.println("age:"+loggedInUser.getAge());
    out.println("phone Number: "+loggedInUser.getPhonenumber());
    out.println("designation:"+loggedInUser.getDesignation());
    // Display other user information as needed
}
%>
<jsp:include page="include/footer.jsp"/>