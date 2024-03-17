/**
 * Represents an object Car with attributes make, year, and price.
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Andrew Dang
 * @since March 17, 2024
 */

package Prog01_aOrderedList; 

public class Car implements Comparable<Car> {
	// The make of the car. 
	private String make; 
	
	// The year of the car. 
	private int year; 
	
	// The price of the car. 
	private int price; 
	
   /**
	* Initializes the Car class and assigns initial values to the class'
	* attributes make, year, and price.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @param Make The make of the car.
    * @param Year The year of the car.
    * @param Price The price of the car.
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public Car(String Make, int Year, int Price) {
		make = Make; 
		year = Year; 
		price = Price; 
	}
	
   /**
	* Returns the value of the class attribute make.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return The make of the car. 
	* @author Andrew Dang
	* @since March 17, 2024
	*
	*/
	public String getMake() {
		return make; 
	}
	
   /**
	* Returns the value of the class attribute year.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return The year of the car. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public int getYear() {
		return year; 
	}
	
   /**
	* Returns the value of the class attribute price.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return The price oßf the car. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public int getPrice() {
		return price; 
	}
	
   /**
	* Compares the Car object to another Car object based on make and then year. 
	* car1 < car2 when the make of car1 is less than the make of car 2 or
	* the make of both cars are the same and the year of car 1 is less than the year of car 2. 
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @param other The Car object to compare to.
	* @return A negative integer, zero, or a positive integer if this object is
	* less than, equal to, or greater than the specified object, respectively.
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public int compareTo(Car other) 
	{
		if (make.compareTo(other.getMake()) != 0) {
			return make.compareTo(other.getMake()); 
		} 
		else {
			return Integer.compare(this.year, other.getYear());
		}
	}
	
   /**
	* Returns a string representation of the object
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Andrew Dang
	* @since March 17, 2024
	* @return A string representation of the object
	*/
	@Override
	public String toString() {
		return "Make: " + make + ", Year: " + year + ", Price: " + price + ";"; 
	}
}
