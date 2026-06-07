import java.util.*;
class Main {
      public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int exp = sc.nextInt();

        int[][] monsters = new int[n][2];
        for (int i=0; i<n; i++) {
            monsters[i][0] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            monsters[i][1] = sc.nextInt();
        }

        Arrays.sort(monsters, (a, b) -> a[0] - b[0]);
        int count = 0;

        for (int i=0; i<n; i++) {
            int power = monsters[i][0];
            int bonus = monsters[i][1];

            if (exp >= power) {
                exp += bonus;
                count ++;
            }
        }
        System.out.println(count);
    }
}     