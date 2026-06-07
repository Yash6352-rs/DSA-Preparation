import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int total = 1 << N;

        for (int mask=0; mask<total; mask++) {

            ArrayList<Integer> list = new ArrayList<>();
            int xor = 0;

            for (int i=0; i<N; i++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(arr[i]);
                    xor ^= arr[i];
                }
            }

            boolean valid = true;
            for (int i=1; i<list.size(); i++) {
                if (list.get(i) < list.get(i-1)) {
                    valid = false;
                    break;
                }
            }

            if (valid && xor >= M) {
                answer = Math.max(answer, list.size());
            }
        }       

        System.out.println("Answer");
        System.out.println(answer);
    }
}       