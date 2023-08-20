import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String[] symbols = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = parseStringToArrayOfIntegers(capacity, symbols);
        int result = findQuantityOfRepeatedValue(numbers, n);
        System.out.println(result);
    }

    public static int[] parseStringToArrayOfIntegers(int capacity, String[] symbols) {
        int[] numbers = new int[capacity];
        for (int i = 0; i < Math.min(capacity, symbols.length); i++) {
            numbers[i] = Integer.parseInt(symbols[i]);
        }
        return numbers;
    }

    public static int findQuantityOfRepeatedValue(int[] numbers, int n) {
        int quantity = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                quantity += 1;
            }
        }
        return quantity;
    }
}