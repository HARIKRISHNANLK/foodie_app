package com.btc.app;

import java.util.Scanner;

import com.btc.app.ui.RestaurantAppUI;

public class RestaurantRunner
{

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in)) {
			RestaurantAppUI appUI = new RestaurantAppUI();
			while (true) {
					System.out.println("Enter a option :\n [1 - Add Restaurant] \n [2 - Search Restaurant] \n [3 - Delete Restaurant] \n [4 - Update Restaurant] \n [5 - Display All Restaurant] \n [0 - Exit]");
					int option = scanner.nextInt();
					
					switch (option) {
					case 1:
						appUI.addRestaurant();
						break;
					case 2:
						appUI.SearchRestaurant();
						break;
					case 3:
						appUI.deleteRestaurant();
						break;
					case 4:
						appUI.updateRestaurant();
						break;
					case 5:
						appUI.getAllRestaurant();
						break;
					case 0:
						System.exit(1);
						break;

					default:
						throw new IllegalArgumentException("Invalid Option: " + option);
					
				}
				
				System.out.println("\n");

			}
		}

	}

}
