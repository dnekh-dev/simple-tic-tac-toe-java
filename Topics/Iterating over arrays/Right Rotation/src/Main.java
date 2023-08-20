import java.util.Scanner;
import java.util.Arrays;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {

        int[] rotatedArray = new int[arr.length];

        int difference = steps % arr.length;

        for (int i = difference, j = 0; i > 0; i--, j++) {
            rotatedArray[j] = arr[arr.length - i];
        }
        for (int i = difference; i < rotatedArray.length; i++) {
            rotatedArray[i] = arr[i - difference];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rotatedArray[i];
        }

    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}