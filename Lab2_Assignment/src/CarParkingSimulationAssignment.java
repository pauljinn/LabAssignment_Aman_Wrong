/**
 * Desc : Creating a 5 story car parking system simulation.
 * @author Aman Soni
 *
 */
import java.util.Scanner;

class CarDetail{
	private String name;
	private String registrationNumber;
	
	public CarDetail(String name, String registrationNumber) {
		this.name = name;
		this.registrationNumber = registrationNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
	
}

public class CarParkingSimulationAssignment {
	/*
	 * Method to initialize the car parking slots.
	 * Displaying Car parking menu.
	 * Choosing a option from menu.
	 * Then displaying user content according to that.
	 */
	public static void main(String[] args) {
		/*
		 * Initializing the car parking slots in 5 story parking.
		 * First story have 100 cars parking capacity.
		 * Second story have 70 cars parking capacity.
		 * Third story have 50 cars parking capacity.
		 * Fourth story have 20 cars parking capacity.
		 * Fifth story have 10 cars parking capacity.
		 */
		CarDetail parkingSlots[][] = new CarDetail[5][];
		parkingSlots[0] = new CarDetail[100];
		parkingSlots[1] = new CarDetail[70];
		parkingSlots[2] = new CarDetail[50];
		parkingSlots[3] = new CarDetail[20];
		parkingSlots[4] = new CarDetail[10];
		int choice;
		/*
		 * Displaying the car parking menu.
		 */
		do {
			System.out.println("Welcome to 5 story car parking system");
			System.out.println("1. Park car");
			System.out.println("2. Get car");
			System.out.println("3. Get available space");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			in.nextLine();
			switch(choice) {
				case 1:
					System.out.print("Enter the car name: ");
					String carName = in.nextLine();
					System.out.print("Enter the car registration number: ");
					String registrationNumber = in.nextLine();
					CarDetail car = new CarDetail(carName,registrationNumber);
					if(parkCar(parkingSlots,car)){
						System.out.println("Car is successfully parked");
					}
					else {
						System.out.println("Car parking is full");
					}
					break;
				case 2:
					System.out.println("Enter the registration number of car: ");
					String registrationNumberToSearch = in.nextLine();
					CarDetail carSearched = getCar(parkingSlots,registrationNumberToSearch);
					if(carSearched==null) {
						System.out.println("No car is parked with the given registration number");
					}
					else {
						System.out.println("Car Found");
						System.out.println("Car name: "+carSearched.getName());
						System.out.println("Car registration number: "+carSearched.getRegistrationNumber());
					}
					break;
				case 3:
					System.out.println("Total space left in the parking: "+getSpace(parkingSlots));
					break;
			}
			
		}while(choice!=4);

	}
	/*
	 * Method for parking the car
	 * Return true if the car is successfully parked
	 * Return false if the parking is full.
	 */
	public static boolean parkCar(CarDetail[][] parkingSlots,CarDetail car) {
		  for(int i=0;i<parkingSlots.length;i++) {
			  for(int j=0;j<parkingSlots[i].length;j++) {
				  if(parkingSlots[i][j]==null) {
					  parkingSlots[i][j] = car;
					  return true;
				  }
			  }
		  }
		  return false;
	}
	/*
	 * Method to get the car from the parking slot using it's registration number.
	 * Return the car from the parking slot of given registration number.
	 * Put null in place of the car with provided registration number.
	 * Return null if no car of that registration number is present.
	 */
	public static CarDetail getCar(CarDetail[][] parkingSlots,String registrationNumber) {
		for(int i=0;i<parkingSlots.length;i++) {
			  for(int j=0;j<parkingSlots[i].length;j++) {
				  if(parkingSlots[i][j]!=null) {
					  if(parkingSlots[i][j].getRegistrationNumber().equals(registrationNumber)) {
						  CarDetail requiredCar = parkingSlots[i][j];
						  parkingSlots[i][j] = null;
						  return requiredCar;
					  }
				  }
			  }
		  }
		return null;
	}
	/*
	 * Method to return the available space in the parking.
	 * Basically counts of all the places where car is not parked.
	 */
	public static int getSpace(CarDetail[][] parkingSlots) {
		int availableSpace = 0;
		for(int i=0;i<parkingSlots.length;i++) {
			  for(int j=0;j<parkingSlots[i].length;j++) {
				  if(parkingSlots[i][j]==null) {
					  availableSpace += 1;
				  }
			  }
		}
		return availableSpace;
	}

}
