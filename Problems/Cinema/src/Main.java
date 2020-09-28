import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] seats = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();
        int count = 0;
        int row = 0;

        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < m; j++) {
                if (seats[i][j] == 0) {
                    count++;
                    if (count == k) {
                        row = i + 1;
                        break;
                    }
                } else {
                    count = 0;
                }
            }
            if (count == k) {
                break;
            }
        }
        System.out.println(row);
    }

}