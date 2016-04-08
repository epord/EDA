/**
 * Created by Pedro on 19/3/2016.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] vec = {1067, 919, 1196, 785, 1126, 936, 918, 1156, 920, 948};

        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = 0; j < vec.length - i - 1; j++) {
                if (vec[j] > vec[j+1]) {
                    int aux = vec[j];
                    vec[j] = vec[j+1];
                    vec[j+1] = aux;
                }
            }
        }

        int acum = 0;
        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
            acum += vec[i];
        }
        int avg = acum / vec.length;
        System.out.println("media = " + avg);

        acum = 0;
        for (int i = 0; i < vec.length; i++) {
            acum += (vec[i] - avg) * (vec[i] - avg);
        }
        int s2 = acum / (vec.length - 1);
        System.out.println("Varianca Muestral = " + s2);
        System.out.println("Desvio Estandar = " + Math.sqrt(s2));
    }
}
