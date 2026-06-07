import java.util.*;
class Main {
    static ArrayList<Integer>[] tree;
    static int[] val;

    static ArrayList<String> paths;

    // DFS to generate root-to-leaf binary strings
    static void dfs(int node, String current) {

        current += val[node];

        if (tree[node].size() == 0) {
            paths.add(current);
            return;
        }

        for (int child: tree[node]) {
            dfs(child, current);
        }
    }

    // Generate all paths
    static ArrayList<String> getAllPaths(int N) {

        paths = new ArrayList<>();
        dfs(0, "");
        return paths;
    }

    // Check whether query exists in any path
    static boolean containsQuery(String q, ArrayList<String> allPaths) {

        for (String p: allPaths) {
            if (p.contains(q)) {
                return true;
            }
        }
        return false;
    }

    // Flip edge values
    static void flip(int u, int v) {

        val[u] ^= 1;
        val[v] ^= 1;
    }

    public static void main(String[] args) {

        int N = 6;
        int M = 3;

        tree = new ArrayList[N];

        for (int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build tree
        tree[0].add(1);
        tree[0].add(2);
        tree[1].add(3);
        tree[1].add(4);
        tree[2].add(5);

        val = new int[]{1, 0, 1, 1, 0, 1};

        String[] queries = {"10", "011"};

        int totalCost = 0;

        for (String q: queries) {
            System.out.println("Processing Query=" + q);

            ArrayList<String> originalPaths = new ArrayList<>();
            System.out.println("Current Paths");

            for (String s: originalPaths) {
                System.out.println(s);
            }

            // Query already exists
            if (containsQuery(q, originalPaths)) {

                System.out.println("Already Found");
                System.out.println("Cost = 0");

                continue;
            }

            boolean foundAfterFlip = false;

            // Try flipping every edge once
            for (int parent = 0; parent<N; parent++) {

                for (int child: tree[parent]) {

                    // flip
                    flip(parent, child);

                    ArrayList<String> newPaths = getAllPaths(N);

                    if (containsQuery(q,newPaths)) {

                        foundAfterFlip = true;
                        System.out.println("Found after flipping edges: " + parent + " - " + child);

                        totalCost += M;

                        // restore
                        flip(parent, child);
                        break;
                    }

                    // restore
                    flip(parent, child);
                }

                if (foundAfterFlip) {
                    break;
                }
            }

            // If not found after 1 flip
            if (!foundAfterFlip) {
                System.out.println("Needs more flips");

                // simplified assumption
                totalCost += 2 * M;
            }
            System.out.println();
        }

        System.out.println("Final Total Cost = " + totalCost);
    }
}