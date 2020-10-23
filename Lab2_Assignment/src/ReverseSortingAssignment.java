/**
 * Desc : Sorting the array of integers after reversing each numbers in it.
 * @author Aman Soni
 *
 */
public class ReverseSortingAssignment {

	public static void main(String[] args) {
		/*
		 * Creating an array of numbers.
		 */
		int[] numberArray = {980,123,13,456};
		/*
		 * Calling the getSorted method to sort the number after reversing each of them.
		 */
		numberArray = getSorted(numberArray);
		/*
		 * Printing the reversed number sorted array.
		 */
		System.out.print("Sorted array after reversing each number in it: ");
		for(Integer i:numberArray) {
			System.out.print(i + " ");
		}
	}
	/*
	 * A method to sort the number in integer array after reversing each number in it.
	 */
	public static int[] getSorted(int[] numberArray) {
		/*
		 * Reversing each number in the number array got as argument.
		 */
		for(int i=0;i<numberArray.length;i++) {
			String numberString = Integer.toString(numberArray[i]);
			String reverse = "";
			for(int j=numberString.length()-1;j>=0;j--) {
				reverse += Character.toString(numberString.charAt(j));
			}
			numberArray[i] = Integer.parseInt(reverse);
		}
		/*
		 * Sorting the reversed number array using bubble sort.
		 */
		for(int i=0;i<numberArray.length-1;i++) {
			/**
			 * Checking if swapping is done in internal loop.
			 */
			boolean swap = false;
			for(int j=0;j<numberArray.length-i-1;j++) {
				if(numberArray[j]>numberArray[j+1]) {
					swap = true;
					int temp = numberArray[j];
					numberArray[j] = numberArray[j+1];
					numberArray[j+1] = temp;
				}
			}
			/**
			 * If no swapping is done then that means array is already sorted hence no need to run loop again.
			 */
			if(!swap)
				break;
		}
		/*
		 * Return the reverse number sorted array
		 */
		return numberArray;
	}

}
