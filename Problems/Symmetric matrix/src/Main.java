import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        String isSymmetric = "YES";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = scanner.nextInt();
                array[i][j] = number;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] != array[j][i]) {
                    isSymmetric = "NO";
                    break;
                }
            }
            
            if (isSymmetric.equals("NO")) {
                break;
            }
        }

        System.out.println(isSymmetric);
    }


}
