import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input = 0;
		String country;
		String file;

		System.out.println("Welcome to the Countries Maintenance Application!");

		Path filePath = Paths.get("countries.txt");

		if (Files.notExists(filePath) == true) {
			System.out.println("countries.txt does not exist.  Would you like to create the file? (y/n)");
			file = scan.next();
			if (file.equalsIgnoreCase("y")) {
				CountriesTextFile.createFile();
				System.out.println("Your list currently contains no countries.");
				System.out.println();
			} else {
				System.out.println("Application cannot function without countries.txt. Goodbye!");
				input = 3;
			}
		}

		while (input != 3) {
			System.out.println("1 - See the list of countries");
			System.out.println("2 - Add a country");
			System.out.println("3 - Exit");
			System.out.println();
			System.out.println("Enter a menu number: ");

			input = scan.nextInt();
			input = scan.nextInt();

			if (input == 1) {
				CountriesTextFile.readFromFile();
			} else if (input == 2) {
				System.out.println("Enter the country to add: ");
				scan.nextLine();
				country = scan.nextLine();
				CountriesTextFile.writeToFile(country);
				System.out.println("This country has been saved!");
			} else if (input == 3) {
				System.out.println("Goodbye!");
			}
			System.out.println();
		}

		scan.close();

	}

}
