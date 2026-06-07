import java.util.*;
class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        char d = sc.next().charAt(0);
        
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n.length(); i++) {
            if(n.charAt(i) == d) {
                String temp = n.substring(0,i) + n.substring(i+1);
                int val = Integer.parseInt(temp);

                if (val > max) {
                    max = val;
                }
            }
        }
        System.out.println(max);
    }
}