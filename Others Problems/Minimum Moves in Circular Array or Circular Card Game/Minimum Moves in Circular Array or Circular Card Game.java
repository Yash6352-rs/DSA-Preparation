import java.util.*;
class Main {
    public static int shiftCards(List<String> cards, int s, String target) {
        int e = cards.indexOf(target);
        int n = cards.size();
        
        if (s == e) {
            return 0;
        }
        if (Math.abs(e - s) == 1) {
            return 1;
        }
        
        int forward, backward;
        if (s < e) {
            forward = e - s;
            backward = s + (n - 1 - e) + 1;
        }
        else {
            forward = e + (n - 1 - s) + 1;
            backward = s - e;
        }
        return Math.min(forward, backward);
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<String> cards = Arrays.asList(sc.nextLine().split(" "));
        int s = Integer.parseInt(sc.nextLine());
        String target = sc.nextLine();
        
        System.out.println(shiftCards(cards, s, target));   
    }
}