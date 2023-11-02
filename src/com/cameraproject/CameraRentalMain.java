package com.cameraproject;

import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;




class Cameras {
	int id;
	String brand;
	String model;
	double pricePerDay;
	boolean isAvailable;

	public Cameras(int id, String brand, String model, double pricePerDay, boolean isAvailable) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
	}
	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}
}


public class CameraRentalMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		ArrayList<Cameras> myCameras = new ArrayList<>();

		// Initialize cameras
		myCameras.add(new Cameras(11, "Sam", "DS123", 600.0, true));
		myCameras.add(new Cameras(12, "Sony", "HD214", 500.0, true));
		myCameras.add(new Cameras(14, "Pana", "XC", 500.0, true));
		myCameras.add(new Cameras(15, "Can", "XLR", 500.0, true));
		myCameras.add(new Cameras(17, "Fuji", "35", 200.0, true));

		System.out.println();
		System.out.println("       WELCOME TO CAMERA RENTAL APP");
		System.out.println("+--------------------------------------+");

		System.out.println("\nPlease login to continue....");
		int i=1;
		while(true) {
			System.out.println("User Name: ");
			String user=sc.nextLine();
			System.out.println("Password: ");
			String password=sc.nextLine();
			if(user.equals("admin")&&password.equals("admin123")) {
				System.out.println("Login successfull");
				break;
			}
			else {
				System.out.println("Please enter correct user and password ");
				continue;
			}
		}

		System.out.println();



		while(true) {
			double walletBalance = 1000;
			System.out.println("Camera Rental Application Menu:");
			System.out.println("1. My Camera");
			System.out.println("2. Rent a Camera");
			System.out.println("3. View All Camera");
			System.out.println("4. My Wallet");
			System.out.println("5. Exit");
			System.out.print("Select your option between 1 to 5: ");
			System.out.println();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:

				System.out.println(" 1. Add\n 2. Remove\n 3. View my camera \n 4. Go to previous menu ");
				System.out.println("Enter the choich");
				int ch=sc.nextInt();
				switch(ch) {
				case 1:
					System.out.print("Enter Camera ID: ");
					int newId = sc.nextInt();
					System.out.print("Enter Brand: ");
					String newBrand = sc.next();
					System.out.print("Enter Model: ");
					String newModel = sc.next();
					System.out.print("Enter Price per Day: $");
					double newPricePerDay = sc.nextDouble();

					myCameras.add(new Cameras(newId, newBrand, newModel, newPricePerDay, true));
					System.out.println("New camera added to your collection.");
					System.out.println();
					break;
				case 2:
					System.out.print("Enter the Camera ID to remove: ");
					int cameraIdToRemove = sc.nextInt();
					boolean removed = false;

					for (Cameras camera : myCameras) {
						if (camera.getId() == cameraIdToRemove) {
							myCameras.remove(camera);
							System.out.println("Camera removed successfully.");
							removed = true;
							break;
						}
					}

					if (!removed) {
						System.out.println("Camera not found or is already removed.");
					}
					System.out.println();
					break;
				case 3:
					System.out.println("CAMERA ID\tBRAND\t        MODEL\t         STATUS\t         PRICE (PER DAY)");
					for (Cameras camera : myCameras) {
						String status = camera.isAvailable ? "Available" : "Rented";
						System.out.println(camera.id + "\t\t" + " "+camera.brand + "\t\t"+ ""+camera.model + "\t\t"+ ""+status +"\t\t" + camera.pricePerDay);
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Go to previous menu");
					System.out.println();
					break;
				}
				break;



			case 2:
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("CAMERA ID\tBRAND\t        MODEL\t         STATUS\t         PRICE (PER DAY)");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");

				for (Cameras camera : myCameras) {
					String status = camera.isAvailable ? "Available" : "Rented";
					System.out.println(camera.id + "\t\t" + " "+camera.brand + "\t\t"+ ""+camera.model + "\t\t"+ ""+status +"\t\t" + camera.pricePerDay);
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");


				System.out.println();
				System.out.print("Enter the Camera ID to rent the camera show in above list: ");
				int rentId = sc.nextInt();
				for (Cameras camera : myCameras) {
					if (camera.getId() == rentId && camera.isAvailable()) {
						camera.setAvailable(false);
						if(walletBalance>=camera.pricePerDay) {
							System.out.println("Camera rented successfully!");
							walletBalance=walletBalance-camera.pricePerDay;
							System.out.println("Your remaining wallete amount is: "+(walletBalance));

						}
						else {
							System.out.println("Insufficient amount please add the amount.....");
						}

					} else if (camera.getId() == rentId) {
						System.out.println("Camera is already rented. Please choose another camera");
					}




				}
				System.out.println();

				break;
			case 3:
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("CAMERA ID\tBRAND\t        MODEL\t         STATUS\t         PRICE (PER DAY)");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");

				for (Cameras camera : myCameras) {
					String status = camera.isAvailable ? "Available" : "Rented";
					System.out.println(camera.id + "\t\t" + " "+camera.brand + "\t\t"+ ""+camera.model + "\t\t"+ ""+status +"\t\t" + camera.pricePerDay);
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");


				System.out.println();
				break;




			case 4:

				walletBalance = 1000.0;

				while (true) {
					System.out.println("My Wallet Balance: $" + walletBalance);
					System.out.print("Do you want to add money to your wallet? (yes/no): ");
					String ans = sc.next();

					if (ans.equalsIgnoreCase("yes")) {
						System.out.print("Enter the amount you want to add: $");
						double amount = sc.nextDouble();
						walletBalance += amount;
						System.out.println("Amount added successfully.");
					} else if (ans.equalsIgnoreCase("no")) {
						System.out.println("Thank you for using the Wallet Balance Tracker. Have a great day!");
						break;
					} else {
						System.out.println("Invalid input. Please enter 'yes' to add money or 'no' to exit.");
					}
				}
				System.out.println();
				break;



			case 5:
				System.out.println("Exiting the program.");
				System.exit(0);
				break;

			default:
				System.out.println("Enter the number between 1 to 5");
				break;

			}

		}

	}

}

