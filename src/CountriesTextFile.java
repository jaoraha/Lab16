import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
//
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
	}}
//
//	public static void createDirectory(String path) {
//		Path dirPath = Paths.get(path);
//
//		if (Files.notExists(dirPath)) {
//
//			try {
//				Files.createDirectories(dirPath);
//			} catch (IOException e) {
//				System.out.println("Something went wrong!");
//			}
//
//		}
//	}
//
//}
//
