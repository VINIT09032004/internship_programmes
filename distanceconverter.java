package internship_programmes;
import java.util.Scanner;

public class distanceconverter {

	

	    // Method to convert kilometers to miles
	    public static double kilometersToMiles(double kilometers) {
	        return kilometers * 0.621371;
	    }

	    // Method to convert miles to kilometers
	    public static double milesToKilometers(double miles) {
	        return miles / 0.621371;
	    } 

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Distance Converter");
	        System.out.println("1. Convert Kilometers to Miles");
	        System.out.println("2. Convert Miles to Kilometers");
	        System.out.print("Choose an option (1 or 2): ");
	        int choice = scanner.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.print("Enter distance in kilometers: ");
	                double kilometers = scanner.nextDouble();
	                double miles = kilometersToMiles(kilometers);
	                System.out.printf("%.2f kilometers is equal to %.2f miles.%n", kilometers, miles);
	                break;

	            case 2:
	                System.out.print("Enter distance in miles: ");
	                double milesInput = scanner.nextDouble();
	                double kilometersOutput = milesToKilometers(milesInput);
	                System.out.printf("%.2f miles is equal to %.2f kilometers.%n", milesInput, kilometersOutput);
	                break;

	            default:
	                System.out.println("Invalid choice. Please run the program again.");
	        }

	        scanner.close();
	    }
	}


