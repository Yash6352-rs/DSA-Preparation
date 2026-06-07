import java.util.*;
class Main {
    static boolean allDigitsSame(int M, int B) {
        Set<Integer> digits = new HashSet<>();
        int temp = M;

        while (temp > 0) {
            digits.add(temp % B); 
            temp /= B;
        }

        return digits.size() == 1;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        int minBase = 2;

        for (int B=minBase; B<M; B++) {
            if (allDigitsSame(M, B)) {
                System.out.println("Minimum Base:" + B);
                break;
            }
        }
        sc.close();
    }
}