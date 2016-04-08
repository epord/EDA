import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[] s = sc.nextLine().toCharArray();
        int[] cantCGAT = new int[4];

        for (int i = 0; i < N; i++) {
            cantCGAT[letterToIndex(s[i])]++;
        }

        if (isOk(cantCGAT, N)){
            System.out.println(0);
            return;
        }

        int minChanges = N;

        int j = 0;
        for (int i = 0; i < N; i++) {
            while(j < N && !isOk(cantCGAT, N)) {
                cantCGAT[letterToIndex(s[j++])]--;
            }
            if (isOk(cantCGAT, N)) {
                minChanges = j - i < minChanges? j - i : minChanges;
            }
            cantCGAT[letterToIndex(s[i])]++;
        }

        System.out.println(minChanges);


    }

    static int letterToIndex(char c) {
        switch(c) {
            case 'C':
                return 0;
            case 'G':
                return 1;
            case 'A':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

    static boolean isOk(int[] intArr, int N) {
        for (int i = 0; i < 4; i++) {
            if (intArr[i] > N/4)
                return false;
        }
        return true;
    }
}