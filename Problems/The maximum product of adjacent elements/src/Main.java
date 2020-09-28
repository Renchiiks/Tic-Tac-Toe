import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] numbers = new int[length];
        int product = 0;
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            int product1 = numbers[i] * numbers[i + 1];
            if (product1 > product) {
                product = product1;
            }
        }
        System.out.println(product);
    }
}
