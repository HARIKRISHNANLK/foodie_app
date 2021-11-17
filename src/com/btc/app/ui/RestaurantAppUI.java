package com.btc.app.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.btc.app.model.Restaurant;
import com.btc.app.model.User;
import com.btc.app.service.RestaurantService;
import com.btc.app.service.RestaurantServiceImpl;

import com.btc.app.exception.NotFoundException;
import com.btc.app.exception.InvalidAgeException;
import com.btc.app.exception.InvalidEmailException;
import com.btc.app.exception.InvalidEmpNameException;
import com.btc.app.exception.InvalidEmployeeId;
import com.btc.app.exception.InvalidPasswordException;
import com.btc.app.exception.InvalidRestaurantIdException;
import com.btc.app.exception.InvalidRestaurantNameException;


public class RestaurantAppUI 
{
	
	private static final String Restaurant1 = null;
	private Scanner scanner=new Scanner(System.in);
	private static RestaurantService service=new RestaurantService();
	
	
	public void addRestaurant()  {
		Restaurant restaurant= new Restaurant();
		System.out.println("Enter Restaurant Details :  ");
		System.out.print("Restaurant ID : ");
		int restaurantId=scanner.nextInt();
		try {
			
			if(restaurantId<1000)
			{
				throw new InvalidRestaurantIdException("Enter four digit User Id : "+restaurantId);
			}
			restaurant.setRestaurantId(restaurantId);
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
			System.out.print("Restaurant Name : ");
			String restaurantName=scanner.next()+scanner.nextLine();
			try {
				if(restaurantName.length()<2)
				{
					throw new InvalidEmpNameException("Enter correct User Name :"+restaurantName);
				}
				restaurant.setRestaurantName(restaurantName);
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the correct name : "+restaurantName);
			}
			
			
			System.out.print("Restaurant Location : ");
			String restaurantLocation=scanner.next()+scanner.nextLine();
			try {
				if(restaurantLocation.length()<2)
				{
					throw new InvalidEmpNameException("Enter correct User Name :"+restaurantLocation);
				}
				restaurant.setLocation(restaurantLocation);
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the correct Location : "+restaurantLocation);
			}
			
			System.out.print("Restaurant Type : ");
			String restaurantType=scanner.next()+scanner.nextLine();
			try {
				if(restaurantType.length()<2)
				{
					throw new InvalidEmpNameException("Enter correct Restaurant Type :"+restaurantType);
				}
				restaurant.setType(restaurantType);
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the correct Type : "+restaurantType);
			}
			
			
			System.out.print("Restaurant Category : ");
			String restaurantCategory=scanner.next()+scanner.nextLine();
			try {
				if(restaurantCategory.length()<2)
				{
					throw new InvalidEmpNameException("Enter correct Restaurant Category :"+restaurantCategory);
				}
				restaurant.setCategory(restaurantCategory);
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the correct Category : "+restaurantCategory);
			}
			
			
			
			
			
			Restaurant savedRestaurant;
			try {
				savedRestaurant = service.addRestaurant(restaurant);
				System.out.println("Restaurant Added Successfully..");
				System.out.println(savedRestaurant);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
	}
	
	
	public void SearchRestaurant() {
		System.out.print("Restaurant ID : ");
		int restaurantId=0;
		try {
			restaurantId=scanner.nextInt();
			if(restaurantId<1000)
			{
				throw new InvalidRestaurantIdException("Enter four digit RestaurantId : "+restaurantId);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
		Restaurant restaurant;
		try {
			restaurant = service.searchByRestaurant(restaurantId);
			if(restaurant==null)
			{
				throw new NotFoundException("Restaurant ID Not Found : "+restaurantId);
			}
			
			System.out.println(restaurant); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteRestaurant() 
	{
		System.out.print("Restaurant ID : ");
		int restaurantId=0;
		try {
			restaurantId=scanner.nextInt();
			if(restaurantId<1000)
			{
				throw new InvalidRestaurantIdException("Enter four digit UserId : "+restaurantId);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
		try {
			boolean value = service.deleteRestaurant(restaurantId);
			if(value==false)
			{
				throw new NotFoundException("Restaurant ID Not Found : "+restaurantId);
			}
			else {
				System.out.println("Deleted Successfully");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateRestaurant()
	{
		System.out.println("Enter restaurant Details :  ");
		System.out.print("restaurant ID : ");
		int restaurantId=scanner.nextInt();
		try {
			
			if(restaurantId<1000)
			{
				throw new InvalidRestaurantIdException("Enter four digit RestaurantId : "+restaurantId);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
		try {
				System.out.println("Restaurant Id");
				int RestaurantId = scanner.nextInt();
				System.out.print("Restaurant Name : ");
				String RestaurantName=scanner.next()+scanner.nextLine();
				System.out.print("Location : ");
				String Location=scanner.next()+scanner.nextLine();
				System.out.print("Type : ");
				String Type=scanner.next()+scanner.nextLine();
				System.out.print("Category : ");
				String Category=scanner.next()+scanner.nextLine();
				
				Restaurant restaurant1= new  Restaurant(RestaurantId, RestaurantName, Location, Type, Category);
				 service.updateRestaurant(Restaurant1);
				 System.out.println("Update Successfully");
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void getAllRestaurant() {
		// TODO Auto-generated method stub
		List<Restaurant> uList;
		try {
			uList=service.getAllRestaurant();
			for (Restaurant restaurant :uList) {
				System.out.println(restaurant.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	

}