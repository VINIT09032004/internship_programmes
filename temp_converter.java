package internship_programmes;

import java.util.Scanner;

	class TemperatureConverter {

    // Convert Celsius to Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Convert Celsius to Kelvin
    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Convert Fahrenheit to Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Convert Fahrenheit to Kelvin
    private static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    // Convert Kelvin to Celsius
    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Convert Kelvin to Fahrenheit
    private static double kelvinToFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter the temperature value:");
        double temperature = scanner.nextDouble();

        System.out.println("Enter the original unit (C for Celsius, F for Fahrenheit, K for Kelvin):");
        String unit = scanner.next().toUpperCase();

        // Perform conversions based on the original unit
        switch (unit) {
            case "C":
                double fahrenheit = celsiusToFahrenheit(temperature);
                double kelvin = celsiusToKelvin(temperature);
                System.out.printf("%.2f°C is equivalent to:\n", temperature);
                System.out.printf("%.2f°F\n", fahrenheit);
                System.out.printf("%.2fK\n", kelvin);
                break;

            case "F":
                double celsius = fahrenheitToCelsius(temperature);
                kelvin = fahrenheitToKelvin(temperature);
                System.out.printf("%.2f°F is equivalent to:\n", temperature);
                System.out.printf("%.2f°C\n", celsius);
                System.out.printf("%.2fK\n", kelvin);
                break;

            case "K":
                celsius = kelvinToCelsius(temperature);
                fahrenheit = kelvinToFahrenheit(temperature);
                System.out.printf("%.2fK is equivalent to:\n", temperature);
                System.out.printf("%.2f°C\n", celsius);
                System.out.printf("%.2f°F\n", fahrenheit);
                break;

            default:
                System.out.println("Invalid unit. Please enter C, F, or K.");
                break;
        }

        scanner.close();
    }
}