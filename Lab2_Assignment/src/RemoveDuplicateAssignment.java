/**
 * Desc : Removing duplicates from the integer array and then sorting it in descending order.
 * @author Aman Soni
 *
 */
public class RemoveDuplicateAssignment {

	public static void main(String[] args) {
		/*
		 * Creating an array of duplicate numbers.
		 */
		int numberArray[] = {10,10,3,3,50,20,70,70};
		/*
		 * Calling the modifyArray method to remove all the duplicates and sorting it in descending order 
		 * Then storing the returned array in noDuplicateArray variable. 
		 */
		int noDuplicateArray[] = modifyArray(numberArray);
		/*
		 * Printing the resultant array.
		 */
		System.out.print("Array after removing all the duplicates and sorted in descending order is: ");
		for(Integer i: noDuplicateArray) {
			System.out.print(i+" ");
		}
	}
	/*
	 * A method to remove all the duplicates from the integer array and then sort it in descending order.
	 */
	public static int[] modifyArray(int[] numberArray) {
		/*
		 * First let's just sort the array in ascending order this will help in finding duplicates.
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
		 * An array to store whether the number at particular index is duplicate or not.
		 */
		boolean[] duplicates  = new boolean[numberArray.length];
		/*
		 * Finding duplicates at particular index and according updating the duplicates array.
		 */
		for(int i=0;i<numberArray.length-1;i++) {
			for(int j=i+1;j<numberArray.length;j++) {
				if(numberArray[j]==numberArray[i]) {
					duplicates[j] = true;
				}
			}
		}
		/*
		 * Finding the length of array having no duplicates
		 */
		int nonDuplicateArrayLength = 0;
		for(int i=0;i<duplicates.length;i++) {
			if(!duplicates[i]) {
				nonDuplicateArrayLength += 1;
			}
		}
		/*
		 * Instantiating a non duplicate array.
		 */
		int nonDuplicateArray[] = new int[nonDuplicateArrayLength];
		/*
		 * Filling the non duplicate array using a variable index that keeps count of non duplicate array index filled.
		 */
		int index = 0;
		for(int i=0;i<duplicates.length;i++) {
			if(!duplicates[i]) {
				nonDuplicateArray[index] = numberArray[i];
				index += 1;
			}
		}
		/*
		 * Sorting the non duplicate array in descending order.
		 */
		for(int i=0;i<nonDuplicateArray.length-1;i++) {
			/**
			 * Checking if swapping is done in internal loop.
			 */
			boolean swap = false;
			for(int j=0;j<nonDuplicateArray.length-i-1;j++) {
				if(nonDuplicateArray[j]<nonDuplicateArray[j+1]) {
					swap = true;
					int temp = nonDuplicateArray[j];
					nonDuplicateArray[j] = nonDuplicateArray[j+1];
					nonDuplicateArray[j+1] = temp;
				}
			}
			/**
			 * If no swapping is done then that means array is already sorted hence no need to run loop again.
			 */
			if(!swap)
				break;
		}
		return nonDuplicateArray;
		
	}

}
