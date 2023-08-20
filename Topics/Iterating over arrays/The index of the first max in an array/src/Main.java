import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        System.out.println(findFirstIndexOfMaxValue(strToArrOfNums()));

    }

    /**
     * Reads an integer size from the console, followed by a space-separated string of numbers.
     * Converts the string of numbers into an integer array and returns it.
     * @return An integer array representation of the entered numbers.
     */
    public static int[] strToArrOfNums() {

        //Initializing the scanner object to read input from console
        Scanner sc = new Scanner(System.in);
        //Read the size of the array from the user and parse it to an integer
        int size = Integer.parseInt(sc.nextLine());
        // Read the next line containing space-separated numbers
        String str = sc.nextLine();
        // Split the string into individual number strings using space as a delimiter
        String[] symbols = str.split(" ");
        // Initialize an integer array with the specified size
        int[] numbers = new int[size];

        // Convert each number string into an integer and populate the numbers array
        // Use Math.min to ensure we don't go out of bounds if the user enters more numbers than the specified size
        for (int i = 0; i < Math.min(size, symbols.length); i++) {
            numbers[i] = Integer.parseInt(symbols[i]);
        }

        // Return the populated numbers array
        return numbers;
    }

    /**
     * Finds the index of the first occurrence of the maximum value in the provided array.
     * @param numbers The array in which to find the maximum value's index.
     * @return The index of the first occurrence of the maximum value.
     */
    public static int findFirstIndexOfMaxValue(int[] numbers) {

        // Start by assuming the first number is the maximum
        int index = 0;
        int maxValue = numbers[0];

        // Loop through the array starting from the second number
        for (int i = 1; i < numbers.length; i++) {

            // If we find a number greater than our current maximum
            if (maxValue < numbers[i]) {
                // Update the maximum value and its index
                maxValue = numbers[i];
                index = i;
            }
        }

        // Return the index of the first occurrence of the maximum value
        return index;
    }
}