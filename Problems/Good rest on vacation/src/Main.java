import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int foodPerDay = scanner.nextInt();
        int flight = scanner.nextInt();
        int costPerNight = scanner.nextInt();

        int sum = (days * foodPerDay) + (flight * 2) + ((days - 1) * costPerNight);
        System.out.println(sum);
    }
}