package Ej2_1P1C2014;

/**
 * Created by Pedro on 26/4/2016.
 */
public class Test {

    public static void main(String[] args) {

        CustomMapImpl<String, String> m = new CustomMapImpl<String, String>();

        System.out.println(m.get("k1")); // Imprime null
        m.put("k1", "v1"); // Agrega k1=v1
        m.put("k2", "v2"); // Agrega k2=v2
        m.put("k3", "v3"); // Agrega k3=v3
        System.out.println(m.get("k2")); // Imprime v2
        System.out.println(m.getMostAccessed()); // Imprime k2
        System.out.println(m.get("k1")); // Imprime v1
        System.out.println(m.get("k2")); // Imprime v2
        m.removeLeastAccessed(); // Elimina k3
        m.removeLeastAccessed(); // Elimina k1
        m.put("k4", "v4"); // Agrega k4=v4
        m.put("k4", "v5"); // Actualiza k4=v5
        m.put("k4", "v6"); // Actualiza k4=v6
        System.out.println(m.get("k4")); // Imprime v6
        System.out.println(m.getMostAccessed()); // Imprime k4
        m.removeLeastAccessed(); // Elimina k2
        m.removeLeastAccessed(); // Elimina k4

    }
}
