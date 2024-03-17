/**
 * Provides the main method as well as methods to read input and obtain output files for the program.
 *  
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Andrew Dang
 * @since March 17, 2024
 *
 */
package Prog01_aOrderedList; 

import java.io.File;  // Imports the File class
import java.io.PrintWriter; // Imports the PrintWriter class
import java.util.Arrays; // Imports the Arrays class
import java.util.List; // Imports the Lists class
import java.util.Scanner; //Import the Scanner class
import java.io.FileNotFoundException; //Imports the FileNotFoundException class

public class Prog01_aOrderedList {

   /**
	* Main method that prompts the user for a valid input file and then writes that onto a valid output file. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Andrew Dang
	* @since March 17, 2024
	*
	*/
	public static void main(String[] args) throws FileNotFoundException {
		// input file
		Scanner input = getInputFile("Enter input filename: ");
		
		// output file
		PrintWriter output = getOutputFile("Enter output filename: ");
		
		// The ordered list of element cars
		aOrderedList<Car> order = new aOrderedList<Car>(); 
		
		while (input.hasNextLine()) {
			// Reads the current line of input
			String curr = input.nextLine().replace(" ", "");
			
			// Splits the string stored in 'curr' by commas and converts the substrings into a list of strings
			List<String> string = Arrays.asList(curr.split(",")); 
		
			if (string.get(0).equals("A")) {
				order.add(new Car(string.get(1), Integer.parseInt(string.get(2)), Integer.parseInt(string.get(3))));
			} 
			else if (string.get(0).equals("D") && string.size() == 3) {
				// The target model that's being deleted
				String make = string.get(1); 
				
				// The target year that's being deleted
				int year = Integer.parseInt(string.get(2)); 
				
				while (order.hasNext()) {
					Car car = order.next(); 
					if (car.getMake().equals(make) && car.getYear() == year) {
						order.remove(); 
					}
				}
				order.reset(); 
			} 
			else if (string.get(0).equals("D") && string.size() == 2)
			{
				// Index of the deleted element
				int index = Integer.parseInt(string.get(1)); 
				order.remove(index); 
			}
		}
		
		output.println("Number of cars:\t" + order.size()); 
		
		for (int i = 0; i < order.size(); i++) {
			// The element car at index i
			Car car = order.get(i); 
			output.printf("\nMake:%15s\nYear:%15d\nPrice:%14s\n",
                    car.getMake(), car.getYear(), "$" + car.getPrice());
		}
		
		input.close(); 
		output.close(); 
	}
	
   /**
	* Reads the input file specified by the user.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
    * @param userPrompt The prompt to ask the user for the input file path.
    * @return A Scanner object for the input file.
    * @throws FileNotFoundException If the specified input file is not found.
	* @since March 17, 2024
	*
	*/
	public static Scanner getInputFile(String userPrompt) throws FileNotFoundException {
		return getFile(userPrompt, false); 
	}
	
   /**
	*
	* Obtains the output file specified by the user.
    * 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @param userPrompt The prompt to ask the user for the output file path.
    * @return A PrintWriter object for the output file.
    * @throws FileNotFoundException If the specified output file cannot be created or written to.
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public static PrintWriter getOutputFile(String userPrompt) throws FileNotFoundException {
		return getFile(userPrompt, true); 
	}
	
   /**
	* Obtains the file specified by the user. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @param userPrompt The prompt to ask the user for the file path.
    * @param isOutput Determines whether the file is an output file.
    * @return A Scanner or PrintWriter object based on the file type.
    * @throws FileNotFoundException If the specified file is not found.
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	@SuppressWarnings("unchecked")
	private static <T> T getFile (String userPrompt, boolean isOutput) throws FileNotFoundException {
		// the file path of the output file. 
		String filePath = null; 
		
		// The user's choice of either Y or N .
		String choice = null; 
		
		// Scanner for user input. 
		Scanner scan = new Scanner(System.in); 
		
			while (true) {
				System.out.print(userPrompt);
	            filePath = scan.nextLine();
	            try {
	                if (isOutput) {
	                    return (T) new PrintWriter(filePath);
	                } 
	                else {
	                    return (T) new Scanner(new File(filePath));
	                }
	            } catch (FileNotFoundException e) {
	            	
	            	do {
		                System.out.println("File not found: " + e.getMessage());
		                System.out.println("Would you like to continue? (Y/N)");
		                choice = scan.nextLine();
		                if (choice.equalsIgnoreCase("Y")) {
		                	continue; 
		                }
		                else if (choice.equalsIgnoreCase("N")) {
		                	scan.close(); 
		                    throw new FileNotFoundException("Operation aborted");
		                } 
		                else if (!choice.equalsIgnoreCase("Y")) {
		                    System.out.println("Invalid choice. Please enter Y or N.");
		                }
	            	} while (!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))); 
	            }
	        }
	}
}

