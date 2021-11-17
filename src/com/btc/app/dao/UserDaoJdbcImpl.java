package com.btc.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.btc.app.exception.DuplicateDataException;
import com.btc.app.model.User;
public class UserDaoJdbcImpl implements UserDao{

	    private Connection con;
		
		private PreparedStatement smt;

		@Override
	    public User addUser(User user) {
			
			String query = "insert into user values(?,?,?,?,?,?)";
			try {
			   con=ConnectionUtil.getDbConnection();
			   smt= con.prepareStatement(query);
			
				smt.setInt(1, user.getUserId());
				smt.setString(2, user.getUserName());
				smt.setInt(3, user.getAge());
				smt.setString(4, user.getUserEmail());
				smt.setInt(5, user.getPhoneNo());
				smt.setString(6, user.getPassword());
				
				int insertedRowCount = smt.executeUpdate();
				if(insertedRowCount>0) {
					return user;
				}
			} catch (DuplicateDataException | SQLException e) {
				// TODO: handle exception
			   throw new DuplicateDataException("Employee Already Exists");
			}
			
			return null;
		}

		@Override
		public User searchUserById(int userId) throws SQLException  {
	      
			String query="select * from user where uid=?";
			smt=con.prepareStatement(query);
			
			smt.setInt(1, userId);	
			
			ResultSet queryResult = smt.executeQuery();
			
			User us=null;
			
			if(queryResult.next()) {
				us=new User();
				us.setUserId(userId);
				us.setUserName(queryResult.getString("uname"));
				us.setAge(queryResult.getInt("age"));
				us.setUserEmail(queryResult.getString("email"));
				us.setPhoneNo(queryResult.getInt("phone_no"));
				us.setPassword(queryResult.getString("password"));
			}
			
			return us;

		}

		@Override
		public boolean deleteUserById(int userId) throws SQLException{
			 String query = "delete from user where uid=?";
			   con=ConnectionUtil.getDbConnection();
			   smt= con.prepareStatement(query);
			   smt.setInt(1, userId);
			   int deleted = smt.executeUpdate();
			   if(deleted==0)
			   {
				   return false;
			   }else {
				   return true;
			   }
			
		}

		@Override
		public User updateUser(User user) throws SQLException {
	        
			
			String query = "UPDATE user SET uid = ?,uname=? ,age=?,email =?,phone_no =?,password =? WHERE uid =?";
		
			con=ConnectionUtil.getDbConnection();
			smt= con.prepareStatement(query);
			
			smt.setInt(1, user.getUserId());
			smt.setString(2, user.getUserName());
			smt.setInt(3, user.getAge());
			smt.setString(4, user.getUserEmail());
			smt.setInt(5, user.getPhoneNo());
			smt.setString(6, user.getPassword());
			smt.setInt(7, user.getUserId());
			
			int insertedRowCount = smt.executeUpdate();
			if(insertedRowCount>0) {
				return user;
			}  
			return null;
		}

		@Override
		public List<User> getAllUser() throws SQLException {
			String query="select * from user";
			con=ConnectionUtil.getDbConnection();
			smt= con.prepareStatement(query);
			
			ResultSet rst = smt.executeQuery();
			
			List<User> employee=new ArrayList<User>();
			
			while(rst.next()) {
				User us = new User();
				us.setUserId(rst.getInt("uid"));
				us.setUserName(rst.getString("uname"));
				us.setAge(rst.getInt("age"));
				us.setUserEmail(rst.getString("email"));
				us.setPhoneNo(rst.getInt("phone_no"));
				us.setPassword(rst.getString("password"));
				employee.add(us);
			}
			
			return employee;
		}

		@Override
		public boolean userLogIn(String userEmail, String password) {
			// TODO Auto-generated method stub
			String query="select * from user where email=? and password=?";
			try {
				smt=con.prepareStatement(query);
				smt.setString(1, userEmail);
				smt.setString(2, password);
				
				ResultSet queryResult = smt.executeQuery();
				
				
				if(queryResult.next()) {
					return true;
				}
				
			} catch (SQLException  | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				return false;
		}

}