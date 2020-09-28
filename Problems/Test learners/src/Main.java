import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String answer = null;

        switch (number) {
            case 1:
                answer = "Yes!";
                break;
            case 2:
            case 3:
            case 4:
                answer = "No!";
                break;
            default:
                answer = "Unknown number";
                break;
        }
        System.out.println(answer);
    }
}