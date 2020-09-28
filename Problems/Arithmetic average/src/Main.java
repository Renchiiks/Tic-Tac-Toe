import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double sum = 0;
        double count = 0;
        double average = 0.0;

        for (double i = a; i <= b; i++) {
            if (i % 3 == 0) {
                sum += i;
                count++;
            }

        }
        if (count == 0) {
            count = 1;
        }
        average = (double) sum / (double) count;
        System.out.println(average);
    }
}