// Title: Lab No 16
// Author: John Aoraha
// Date: May 9, 2018

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {

	public static void readFromFile() {
		Path readFile = Paths.get("countries.txt");
		File file = readFile.toFile(); // convert to a file object

		try {
			FileReader fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}

	public static void writeToFile(String country) {

		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));// FileOutputStream can take 2
																					// parameters
			outW.println(country);
			outW.close(); // flushes data closes the stream

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}

	}


	public static void createFile() {

		Path filePath = Paths.get("countries.txt");

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation");
			}
		}

		System.out.println("File Name: " + filePath.getFileName());
		System.out.println("Absolute Path: " + filePath.toAbsolutePath());
	}
	
	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Please choose a valid menu option.");
			else if (i > max)
				System.out.println("Please choose a valid menu option.");
			else
				isValid = true;
		}
		return i;
	}
}
