/**
 * Desc : Sorting the object of string array in alphabetical order.
 * @author Aman Soni
 *
 */
public class SortStringAssignment {

	public static void main(String[] args) {
		/*
		 * Creating array of string objects.
		 */
		String[] countries = {"Zimbabwe", "South-Africa", "India", "America", "Yugoslavia", " Australia", "Denmark", "France", "Netherlands", "Italy", "Germany"};  
		/*
		 * A variable to store sorted array of string objects.
		 */
		String[] sortedCountries = sortStrings(countries);
		/*
		 * Printing the sorted array of string objects.
		 */
		System.out.print("Countries after sorting: ");
		for(String s:sortedCountries) {
			System.out.print(s + " ");
		}

	}
	/*
	 * A method which accept an array of String objects and sort in Alphabetical order.
	 */
	public static String[] sortStrings(String[] stringArray) {
		/*
		 * Applying bubble sort to sort the object of string array.
		 */
		for(int i=0;i<stringArray.length-1;i++) {
			/*
			 * A local variable to check if the swapping is done in the internal loop.
			 */
			boolean swap = false;
			for(int j=0;j<stringArray.length-i-1;j++) {
				if(stringArray[j].compareTo(stringArray[j+1])>0) {
					swap = true;
					String temp = stringArray[j];
					stringArray[j] = stringArray[j+1];
					stringArray[j+1] = temp;
				}
			}
			/*
			 * If swapping is not done then this signifies the array of string object is sorted hence just terminating the loop.
			 */
			if(!swap)
				break;
		}
		/*
		 * Now converting the left half of the list to upper case and right half in lower case as directed by question
		 * If the list length is odd then half of list is (length/2) + 1 (Given in question).
		 * If the list length is even then half of list is (length/2).
		 */
		int half;
		/*
		 * For even length.
		 */
		if((stringArray.length)%2==0) {
			half = stringArray.length/2;
		}
		/*
		 * For odd length.
		 */
		else {
			half = (stringArray.length/2) + 1;
		}
		/*
		 * Converting left half of array of string object to upper case.
		 */
		for(int i=0;i<half;i++) {
			stringArray[i] = stringArray[i].toUpperCase();
		}
		/*
		 * Converting right half of array of string object to lower case.
		 */
		for(int i=half;i<stringArray.length;i++) {
			stringArray[i] = stringArray[i].toLowerCase();
		}
		return stringArray;
	}
}
