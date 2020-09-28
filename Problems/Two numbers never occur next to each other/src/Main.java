import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean notNext = true;

        int count = scanner.nextInt();
        scanner.nextLine();
        String numbers = scanner.nextLine();
        String[] splitNumbers = numbers.split(" ");
        int n = 0;
        int m = 0;

        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(splitNumbers[i]);
        }

        String untouchable = scanner.nextLine();
        String[] splitUntouchable = untouchable.split(" ");
        for (int i = 0; i < splitUntouchable.length; i++) {
            n = Integer.parseInt(splitUntouchable[0]);
            m = Integer.parseInt(splitUntouchable[1]);
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == n) {
                if (array[i - 1] == m) {
                    notNext = false;
                    break;
                } else if (array[i + 1] == m) {
                    notNext = false;
                    break;
                }
            } else if (array[i] == m) {
                if (array[i - 1] == n) {
                    notNext = false;
                    break;
                } else if (array[i + 1] == n) {
                    notNext = false;
                    break;
                }
            }
        }
        System.out.println(notNext);

    }

}
