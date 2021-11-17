package com.btc.app;

import java.util.Scanner;

import com.btc.app.ui.UserAppUI;

public class MainRunner {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in)) {
			UserAppUI appUI = new UserAppUI();
			while (true) {
				System.out.println("Enter a option :\n [1 - New User] \n [2 - LogIn]");
				int choice = scanner.nextInt();
				switch (choice)
				{
				case 1:
					appUI.addUser();
					break;
				case 2:
					if(appUI.uesrLogIn()) {
					System.out.println("Enter a option :\n [1 - Add User] \n [2 - Search User] \n [3 - Delete User] \n [4 - Update User] \n [5 - Display All Users] \n [0 - Exit]");
					int option = scanner.nextInt();
					
					switch (option) {
					case 1:
						appUI.addUser();
						break;
					case 2:
						appUI.showUserById();
						break;
					case 3:
						appUI.deleteUserById();
						break;
					case 4:
						appUI.updateUser();;
						break;
					case 5:
						appUI.showAllUserDetails();;
						break;
					case 0:
						System.exit(1);
						break;

					default:
						throw new IllegalArgumentException("Invalid Option: " + option);
					}
					}
					else {
						System.out.println("Invalid User ID and Password");
					}
				default:
					throw new IllegalArgumentException("Invalid Option: " + choice);
				}
				
				System.out.println("\n");

			}
		}

	}

}