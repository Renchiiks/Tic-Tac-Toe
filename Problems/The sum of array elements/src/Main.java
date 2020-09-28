import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();

        }

        for (int number : array) {
            sum += number;
        }
        System.out.println(sum);
    }
}