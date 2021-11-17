package com.btc.app.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.btc.app.exception.InvalidAgeException;
import com.btc.app.exception.InvalidEmailException;
import com.btc.app.exception.InvalidEmpNameException;
import com.btc.app.exception.InvalidEmployeeId;
import com.btc.app.exception.InvalidPasswordException;
import com.btc.app.exception.NotFoundException;
import com.btc.app.exception.InvalidPhoneNoException;
import com.btc.app.exception.InvalidRestaurantIdException;
import com.btc.app.model.User;
import com.btc.app.service.UserService;
import com.btc.app.service.UserServiceImpl;

public class UserAppUI {
		
		private Scanner scanner=new Scanner(System.in);
		private static UserService service=new UserServiceImpl();
		
		
		public void addUser()  {
			User user= new User();
			System.out.println("Enter User Details :  ");
			System.out.print("User ID : ");
			int userId=scanner.nextInt();
			try {
				
				if(userId<1000)
				{
					throw new InvalidRestaurantIdException("Enter four digit User Id : "+userId);
				}
				user.setUserId(userId);
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the Integer Value ");
			}
			
				System.out.print("User Name : ");
				String userName=scanner.next()+scanner.nextLine();
				try {
					if(userName.length()<2)
					{
						throw new InvalidEmpNameException("Enter correct User Name :"+userName);
					}
					user.setUserName(userName);
				} catch (InputMismatchException e) {
					// TODO: handle exception
					e.getMessage();
					System.out.println("Enter the correct name : "+userName);
				}
				
				System.out.print("Email : ");
				String email=scanner.next()+scanner.nextLine();
				String regex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				
					if(email.matches(regex)) {
						System.out.println("Correct Email Address");
						user.setUserEmail(email);
					}
					else {
						throw new InvalidEmailException("Enter Correct Email Address");
					}
				
				System.out.print("Password : ");
				String password = scanner.next()+scanner.nextLine();
				if(password.length()<8)
				{
					throw new InvalidPasswordException("Passowrd Atleast 8 character");
				}
				else {
					user.setPassword(password);
				}
				
				System.out.print("Age : ");
				int age = scanner.nextInt();
				if(age<10)
				{
					throw new InvalidAgeException("Enter valid Age");
				}
				else {
					user.setAge(age);
				}
				
				System.out.println("Phone-No : ");
				int phone_no = scanner.nextInt();
				
					user.setPhoneNo(phone_no);
				
				User savedUser;
				try {
					savedUser = service.addUser(user);
					System.out.println("User Added Successfully..");
					System.out.println(savedUser);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			
		}
		
		
		public void showUserById() {
			System.out.print("User ID : ");
			int userId=0;
			try {
				userId=scanner.nextInt();
				if(userId<1000)
				{
					throw new InvalidEmployeeId("Enter four digit UserId : "+userId);
				}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the Integer Value ");
			}
			
			User user;
			try {
				user = service.searchUserById(userId);
				if(user==null)
				{
					throw new NotFoundException("User ID Not Found : "+userId);
				}
				
				System.out.println(user); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void deleteUserById() 
		{
			System.out.print("User ID : ");
			int userId=0;
			try {
				userId=scanner.nextInt();
				if(userId<1000)
				{
					throw new InvalidEmployeeId("Enter four digit UserId : "+userId);
				}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the Integer Value ");
			}
			
			try {
				boolean value = service.deleteUserById(userId);
				if(value==false)
				{
					throw new NotFoundException("User ID Not Found : "+userId);
				}
				else {
					System.out.println("Deleted Successfully");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void updateUser()
		{
			System.out.println("Enter User Details :  ");
			System.out.print("User ID : ");
			int userId=scanner.nextInt();
			try {
				
				if(userId<1000)
				{
					throw new InvalidEmployeeId("Enter four digit UserId : "+userId);
				}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the Integer Value ");
			}
			
			try {
					System.out.print("User Name : ");
					String userName=scanner.next()+scanner.nextLine();
					System.out.print("Email : ");
					String email=scanner.next()+scanner.nextLine();
					System.out.print("Password : ");
					String password=scanner.next()+scanner.nextLine();
					System.out.print("Age : ");
					int age=scanner.nextInt();
					System.out.print("Phone_No : ");
					int phoneNo=scanner.nextInt();
					User user1= new  User(userId, userName, password, age, email, phoneNo);
					 service.updateUser(user1);
					 System.out.println("Update Successfully");
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		public void showAllUserDetails() {
			// TODO Auto-generated method stub
			List<User> uList;
			try {
				uList=service.getAllUser();
				for (User user :uList) {
					System.out.println(user.toString());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public boolean uesrLogIn()
		{
			System.out.print("Email : ");
			String email=scanner.next()+scanner.nextLine();
			System.out.print("Password : ");
			String password=scanner.next()+scanner.nextLine();
			try {
				return service.userLogIn(email, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

}