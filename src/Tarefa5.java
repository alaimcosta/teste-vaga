import java.util.ArrayList;
import java.util.HashSet;

public class Tarefa5 {
    public static void main(String[] args) {
        int[] A = {0,0,2,2,3,4,5,5,7,7,7,80};
        int[] resultado = verificaDuplicadoRemove(A);

        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

    private static int[] verificaDuplicadoRemove(int[] A) {
        HashSet<Integer> elemUnico = new HashSet<>();
        ArrayList<Integer> listElementoUnico = new ArrayList<>();
        for (int num : A){
            if (elemUnico.add(num)) {
                listElementoUnico.add(num);
            }
        }
        int[] result = new int[listElementoUnico.size()];
        for (int i = 0; i < listElementoUnico.size(); i++){
            result[i] = listElementoUnico.get(i);
        }

        return result;
    }
}