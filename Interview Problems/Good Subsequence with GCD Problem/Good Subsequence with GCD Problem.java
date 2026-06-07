import java.util.*;
class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int p = sc.nextInt();
        int q = sc.nextInt();  // queries

        int yesCount = 0;

        for (int k=0; k<q; k++) {

            int index = sc.nextInt();
            int value = sc.nextInt();
            arr[index - 1] = value;

            int currentGCD = 0;
            int count = 0;

            for (int num: arr) {

                if (num % p == 0) {
                    count++;

                    if (currentGCD == 0) {
                        currentGCD = num;
                    } 
                    else {
                        currentGCD = gcd(currentGCD, num);
                    }
                }
            }
            if (count > 0 && currentGCD == p) {
                if (count < n || currentGCD == p) {
                    yesCount++;
                }
            }
        }
        System.out.println(yesCount);
    }
}