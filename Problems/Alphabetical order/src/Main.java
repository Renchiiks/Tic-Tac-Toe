import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        boolean isAlphabetic = true;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i].compareTo(inputArray[i + 1]) <= 0) {
                isAlphabetic = true;
            } else if (inputArray[i].compareTo(inputArray[i + 1]) > 0) {
                isAlphabetic = false;
            }
        }
        System.out.println(isAlphabetic);
    }
}