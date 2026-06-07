import java.util.*;
class Main {
    static int n;
    static List<Integer>[] tree;
    static int[] values;
    static long totalBeauty = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        tree = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }

        int[] parent = new int[n+1];
        for (int i=1; i<=n; i++) {
            parent[i] = sc.nextInt();
        }

        values = new int[n+1];
        for (int i=1; i<=n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i=2; i<=n; i++) {
            tree[parent[i]].add(i);
        }

        for (int i=1; i<=n; i++) {
            ArrayList<Integer> subtree = new ArrayList<>();

            getSubtreeNodes(i, subtree);

            long beauty = countGoodPairs(subtree);
            totalBeauty += beauty; 
        }
        System.out.println(totalBeauty);
    }

    static void getSubtreeNodes(int node, ArrayList<Integer> subtree) {

        subtree.add(values[node]);

        for (int child: tree[node]) {
            getSubtreeNodes(child, subtree);
        }
    }

    static long countGoodPairs(ArrayList<Integer> arr) {

        long count = 0;
        int size = arr.size();

        for (int i=0; i<size; i++) {
            for (int j=i+1; j<size; j++) {

                long product = 1L * arr.get(i) * arr.get(j);

                if (isPerfectSquare(product)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isPerfectSquare(long num) {
        long sqrt = (long)Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}