import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String q_input = sc.nextLine();

        String[] q = q_input.split("\\s+");        
        int ans = 0;
        
        for (String i : q) {
            
            int k = a.indexOf(i);
            
            if (k == -1) {
                ans += 0;
            }
            else {
                int s = a.length() - k;
                ans += s;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}

// mzadpoghyykht     yk      4
// ktmrgjswhwxu      z  w    5
// tvtrpudosnlydgi   do      9