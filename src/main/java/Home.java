import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Model;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
       // response.getWriter().append("Served at: "+page).append(request.getContextPath());
        if (page != null) {
            switch (page) {
                case "home": {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                }
                case "login": {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                }
                case "signup": {
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                    break;
                }
                case "preview": {
                    request.getRequestDispatcher("preview.jsp").forward(request, response);
                    break;
                }
                case "fetch": {
    				List<User> users=new ArrayList<>();
    				try {
    					users=new Model().listuser();
    				} catch (InstantiationException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IllegalAccessException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				request.setAttribute("listusers", users);
                    request.getRequestDispatcher("fetch.jsp").forward(request, response);
                    break;
                }case "delete":{
                	 request.getRequestDispatcher("delete.jsp").forward(request, response);
                     break;
                }
                default: {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
        } else {
            // Handle the case where 'page' parameter is null
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	 String form = request.getParameter("form");
    	
    	 switch (form) {
    	    case "adduseroperation": {
    	        String username = request.getParameter("name");
    	        String password = request.getParameter("password");
    	        int age = Integer.parseInt(request.getParameter("age")); // Default age value if parsing fails
    	        long phoneNumber = Long.parseLong(request.getParameter("phoneNumber")); // Default phone number value if parsing fails
    	        String designation = request.getParameter("designation");

    	        //String username, String password, int age, long phoneNumber2, String designation
    	        
    	        User user = new User(username, password,age,phoneNumber,designation);
    			request.setAttribute("users", user);
    			try {
    				new Model().addUser(user);
    			} catch (InstantiationException | IllegalAccessException | SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			List<User> users=new ArrayList<>();
				try {
					users=new Model().listuser();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("listusers", users);
                request.getRequestDispatcher("fetch.jsp").forward(request, response);
    	        break;
    	    }
    	    case "login": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                try {
                    List<User> users = ((Model) new Model()).checkuser(username, password);
                    if (!users.isEmpty()) {
                        // User found in the database, valid credentials
                    	
                        request.getSession().setAttribute("loggedInUser", users.get(0)); // Storing user info in session
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        // User not found or invalid credentials
                        // You might redirect back to login or display an error message
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } catch (InstantiationException | IllegalAccessException | SQLException e) {
                    // Handle exceptions appropriately
                    e.printStackTrace();
                    // Redirect to an error page or display an error message
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
            }
    	    case "updateuseroperation":{
    			String id1=request.getParameter("user_id");
    			int id=Integer.parseInt(id1);
    			String username = request.getParameter("username");
    			String password = request.getParameter("password");
    			int age=Integer.parseInt(request.getParameter("age"));
    			long phonenumber=Long.parseLong(request.getParameter("phoneNumber"));
    			String designation=request.getParameter("designation");
    			
    			User user = new User(id,username, password,age,phonenumber,designation);
    			request.setAttribute("users", user);
    			
    			
    			try {
    				new Model().updateUser(user);
    			} catch (InstantiationException | IllegalAccessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			List<User> users = new ArrayList<>();
    			try {
    				users = new Model().listuser();
    			} catch (InstantiationException | IllegalAccessException | SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			request.setAttribute("listusers", users);
    			request.getRequestDispatcher("index.jsp").forward(request, response);
    			break; 
    		}
    	    
    	    
    	    case "deleteuseroperation": {
    	        HttpSession session = request.getSession(false); // Get the existing session if it exists without creating a new one

    	        if (session != null) {
    	            User loggedInUser = (User) session.getAttribute("loggedInUser");
    	            
    	            if (loggedInUser != null) {
    	                int userId = loggedInUser.getUser_id();

    	                try {
    	                    // Delete the user from the database
    	                    new Model().deleteUser(userId);

    	                    // Remove the user from the session
    	                    session.removeAttribute("loggedInUser");

    	                    // Redirect or perform necessary actions after deletion
    	                    List<User> users = new ArrayList<>();
    	                    try {
    	                        users = new Model().listuser();
    	                    } catch (InstantiationException | IllegalAccessException | SQLException e) {
    	                        // Handle exceptions appropriately
    	                        e.printStackTrace();
    	                    }

    	                    request.setAttribute("listusers", users);
    	                    request.getRequestDispatcher("index.jsp").forward(request, response);
    	                } catch (InstantiationException | IllegalAccessException | SQLException e) {
    	                    // Handle exceptions appropriately
    	                    e.printStackTrace();
    	                }
    	            }
    	        }
    	        break;
    	    }

    	    }	
    	    }

    
    
    
    

	 

    
}
