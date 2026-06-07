import java.util.*;
class Main {
    static int count = 0;

    static void generate(int[] arr, int index, int N, int K) {
        
        // Array completed
        if (index == K) {
            boolean valid = true;
            
            for (int i=0; i<K-1; i++) {
                if (arr[i+1] % arr[i] != 0) {
                    valid = false;
                    return;
                }
            }
            if (valid) {
                count++;
            }
            
            return;
        }
        
        //  Try every value from 1 to N
        for (int num=1; num<=N; num++) {
            arr[index] = num;
            generate(arr, index+1, N, K);
        }
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in); 
	    
	    int N = sc.nextInt();
	    int K= sc.nextInt();
	    
	    int[] arr = new int[K];
	    
	    generate(arr, 0, N, K);
	    
	    System.out.println(count);
	}
}