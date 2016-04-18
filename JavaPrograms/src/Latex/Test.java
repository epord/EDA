package Latex;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Pedro on 15/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String s = "\\begin{asd} \\end{asd}";
        char[] arr = s.toCharArray();

        int beginPos = s.indexOf("begin");
        int endPos = s.indexOf("end");

        boolean closed = false;

        if (endPos == -1 && beginPos == -1) {
            System.out.println("VALIDO");
            return;
        }

        while (endPos != -1) {
            if (beginPos < endPos && beginPos != -1) {
                stack.push(getStringFromPosition(beginPos + 6, arr));
                beginPos = s.indexOf("begin", beginPos + 1);
            } else {
                String str = getStringFromPosition(endPos + 4, arr);
                if (!stack.peek().equals(str)) {
                    System.out.println("INVALIDO");
                    return;
                }
                stack.pop();
                endPos = s.indexOf("end", endPos + 1);
                closed = true;
            }
        }

        if (stack.empty() && closed) {
            System.out.println("VALIDO");
        } else {
            System.out.println("INVALIDO");
        }

    }

    public static String getStringFromPosition(int index, char[] arr) {
        String aux = "";
        for (int i = index; arr[i] != '}'; i++) {
            aux += arr[i];
        }
        return aux;
    }

}
