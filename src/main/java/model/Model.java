package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConfig;
import entity.User;

public class Model {

	
	
	public List<User> listuser() throws SQLException, InstantiationException, IllegalAccessException{
		  List<User> listusers=new ArrayList<User>();
		  Connection con=DatabaseConfig.getConnection();
		  Statement st=null;
		  ResultSet rs=null;
		  
		  String query="select user_id,username,age,password,phonenumber,designation from employee";
		  
		  try {
			  st= con.createStatement();
			  rs=st.executeQuery(query);
			  
			  while(rs.next()){
				 int id=rs.getInt("user_id");
				  String name=rs.getString("username");
				  String password=rs.getString("password");
				  int age=rs.getInt("age");
				  long phonenumber=rs.getLong("phonenumber");
				  String designation=rs.getString("designation");
				  listusers.add(new User(id,name,password,age,phonenumber,designation));
			  }
			  
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  
		return listusers;
		  
	  }
	
	public void addUser(User newuser) throws InstantiationException, IllegalAccessException, SQLException {
		  Connection connect=null;
		  PreparedStatement statement=null;
		  
		  connect=DatabaseConfig.getConnection();
		  String username=newuser.getUsername();
		 String password=newuser.getPassword();
		 int age=newuser.getAge();
		 long phonenumber=newuser.getPhonenumber();
		 String designation=newuser.getDesignation();
		 
		  String query= "insert into employee (username,password,age,phonenumber,designation) values (?,?,?,?,?);";
		  
		 statement=connect.prepareStatement(query);
		 statement.setString(1, username);
		 statement.setString(2, password);
		 statement.setInt(3, age);
		 statement.setLong(4, phonenumber);
		 statement.setString(5, designation);
		 statement.execute();
		  
	  }
	
	public List<User> checkuser(String uname,String pass) throws SQLException, InstantiationException, IllegalAccessException{
		  List<User> listusers=new ArrayList<User>();
		  Connection con=DatabaseConfig.getConnection();
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  
		  String query= "SELECT user_id, username, password,age,phonenumber,designation FROM employee WHERE username = ? AND password = ?";
		 
		  try {
			  ps = con.prepareStatement(query);
		        ps.setString(1, uname);
		        ps.setString(2, pass);
			  rs=ps.executeQuery();
			  
			  while(rs.next()){
				 int id=rs.getInt("user_id");
				  String name=rs.getString("username");
				  String password=rs.getString("password");
				  int age=rs.getInt("age");
				  long phonenumber=rs.getLong("phonenumber");
				  String designation=rs.getString("designation");
				  listusers.add(new User(id,name,password,age,phonenumber,designation));
			  }
			  
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  
		return listusers;
		  
	  }

	public void updateUser(User updateuser) throws InstantiationException, IllegalAccessException, SQLException {
		
		
		 Connection connect=null;
		  PreparedStatement statement=null;
		  
		  connect=DatabaseConfig.getConnection();
		  int userId=updateuser.getUser_id();
		  String username=updateuser.getUsername();
		  String password = updateuser.getPassword();
			int age=updateuser.getAge();
			long phonenumber=updateuser.getPhonenumber();
			String designation=updateuser.getDesignation();
		  
		  String query="update employee set username=?,password=?,age=?,phonenumber=?,designation=? where user_id=?";
		  
		  
			 statement=connect.prepareStatement(query);
			 statement.setString(1, username);
			 statement.setString(2, password);
			 statement.setInt(3, age);
			 statement.setLong(4, phonenumber);
			 statement.setString(5, designation);
			 statement.setInt(6, userId);
			 statement.executeUpdate();
		
	}
	
	 public void deleteUser(int userid)throws InstantiationException, IllegalAccessException, SQLException {
		  Connection connect=null;
		  PreparedStatement statement=null;
		  
		  connect=DatabaseConfig.getConnection();
		  
		  String query="delete from employee where user_id=?";
		 
		  statement = connect.prepareStatement(query);
		  statement.setInt(1, userid );
		  statement.execute();
	 }

	
}
