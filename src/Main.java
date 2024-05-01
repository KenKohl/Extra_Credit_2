//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * Problem: Develop an algorithm (Java or C++) that can find the ratio of the sum of the largest two numbers divided by
 * the sum of the smallest two numbers in an array. The solution should be linear or better.
 *
 * For example:
 * If the input is
 * int[] a={3,5,12,450,1,1,5,6,23,6,8,9,321,2,3};
 *
 * The ratio is (450+321) / (1+1) = 385.5.
 *
 * Author: Ken Kohlhof
 *
 * Time Complexity: O(n) This is because the code iterates through the whole array only once to get the 1st and 2nd
 * biggest and smallest numbers.
 *
 * Space Complexity: O(1) The amount of space used never changes.
 */

public class Main {

    //findRatio finds the smallest 2 numbers and largest 2 numbers in the array, calls calculateRatio, and prints results
    public static void findRatio(int[] array){

        //Declaration of the smallest and largest variables setting them to appropriate max value or min value
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        //Checks to make sure the array is big enough to perform the method as intended
        if(array.length < 4){
            System.out.println("The array needs to have at least 4 numbers to use this method.");
        }

        //For loop that goes through the length of the array
        for(int i = 0; i < array.length; i++){
            //if the value at array index i is smaller than the firstSmallest variable
            if(array[i] < firstSmallest){
                secondSmallest = firstSmallest;//Sets secondSmallest as current firstSmallest variable
                firstSmallest = array[i];//Sets firstSmallest as value at array index i
            }
            //Else if the value of array index i is smaller than the secondSmallest variable
            else if(array[i] < secondSmallest){
                secondSmallest = array[i]; //Sets secondSmallest to the value at array index i
            }

            //if the value at array index i is larger than the firstLargest variable
            if(array[i] > firstLargest){
                secondLargest = firstLargest;//Sets secondLargest to current firstLargest variable
                firstLargest = array[i];//Sets firstLargest as value at array index i
            }
            //Else if the value at array index i is larger than the secondLargest variable
            else if(array[i] > secondLargest){
                secondLargest = array[i];//Sets secondLargest as value at array index i
            }

        }


        //Sets variable answer as the return value from calculateRatio method
        double answer = calculateRatio(firstLargest,secondLargest,firstSmallest,secondSmallest);

        //Prints message to user in the format that was given in example of the problem.
        System.out.println("The ratio is (" + firstLargest + "+" + secondLargest + ")/(" + firstSmallest + "+" + secondSmallest +
                ") = " + answer);

    }

    //Method calculates the ratio with formula from example of the problem and returns the result as a double.
    public static double calculateRatio(double firstLargest, double secondLargest, double firstSmallest, double secondSmallest){
        return (firstLargest + secondLargest)/(firstSmallest + secondSmallest);
    }


    public static void main(String[] args) {
        //instantiates array a from example of the problem
        int[] a = {3,5,12,450,1,1,5,6,23,6,8,9,321,2,3};

        //calls findRatio method and passes the array
        findRatio(a);

    }
}