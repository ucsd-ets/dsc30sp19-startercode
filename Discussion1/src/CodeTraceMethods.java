import java.util.Random;
public class CodeTraceMethods {
    public static void main(String[] args){
        int[] a = new int[10];
        int[] b = new int[10];
        for(int i=0;i<10;i++){
            method(a,b,i);
        }
    }
    public static void method(int[] a, int[] b, int i){
        if(i>9){
            return;
        }
        Random rand = new Random();

// Obtain a number between [0 - 49].
        int n = rand.nextInt(50);
        a[i] = n;
        b[i] = n*n;
        method(a,b,i+1);
    }
}
