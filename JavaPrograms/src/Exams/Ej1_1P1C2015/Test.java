package Exams.Ej1_1P1C2015;

/**
 * Created by Pedro on 23/4/2016.
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree<String> bM = new BinaryTree<>("M", null, null);
        BinaryTree<String> bL = new BinaryTree<>("L", null, bM);
        BinaryTree<String> bK = new BinaryTree<>("K", null, bL);
        BinaryTree<String> bJ = new BinaryTree<>("J", null, null);
        BinaryTree<String> bN = new BinaryTree<>("N", null, null);
        BinaryTree<String> bG = new BinaryTree<>("G", bN, null);
        BinaryTree<String> bE = new BinaryTree<>("E", null, null);
        BinaryTree<String> bB = new BinaryTree<>("B", null, bK);
        BinaryTree<String> bI = new BinaryTree<>("I", bJ, null);
        BinaryTree<String> bH = new BinaryTree<>("H", bI, null);
        BinaryTree<String> bF = new BinaryTree<>("F", null, bG);
        BinaryTree<String> bD = new BinaryTree<>("D", bF, bE);
        BinaryTree<String> bC = new BinaryTree<>("C", bH, bD);
        BinaryTree<String> bA = new BinaryTree<>("A", bC, bB);

        System.out.println(longestPathLength(bA));

    }

    public static <T> int longestPathLength(BinaryTree<T> tree) {
        Box aux = longestPathLengthRec(tree);
                                                                                                    // le tengo que restar
        return aux.maxHeigth-1 > aux.maxInternalPath-2 ? aux.maxHeigth-1 : aux.maxInternalPath-2;   // porque la raiz le devuelve
                                                                                                    // a otro nodo que no existe
                                                                                                    // (nodo por sobre la raiz)
    }

    private static <T> Box longestPathLengthRec(BinaryTree<T> t) {
        if (t == null) {
            return new Box(0,0);
        }

        Box bl = longestPathLengthRec(t.left);
        Box br = longestPathLengthRec(t.right);

        int maxHeight = bl.maxHeigth > br.maxHeigth ? bl.maxHeigth + 1 : br.maxHeigth + 1;
        int maxInternalPath = bl.maxHeigth + br.maxHeigth;
        if (bl.maxInternalPath != 0) {
            maxInternalPath++;
        }
        if (br.maxInternalPath != 0) {
            maxInternalPath++;
        }

        return new Box(maxHeight, maxInternalPath);
    }

}
