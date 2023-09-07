import java.util.*;

public class Tarefa6 {
    public static void main(String[] args) {
        int[] A = {0,0,2,2,3,4,5,5,7,7,7,80,100,100};
        int[] resultado = verificaDuplicado(A);

        System.out.print("Nova matriz: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
    private static int[] verificaDuplicado(int[] A) {
        Map<Integer, Integer> repeticao = new HashMap<>();
        List<Integer> elemDupli = new ArrayList<>();

        for (int num : A){
            repeticao.put(num, repeticao.getOrDefault(num, 0) + 1);
        }

        for (int num : A){
            if (repeticao.get(num) > 1 && !elemDupli.contains(num)){
                elemDupli.add(num);
            }
        }

        int[] result = new int[elemDupli.size()];
        for (int i = 0; i < elemDupli.size(); i++){
            result[i] = elemDupli.get(i);
        }
        return result;
    }
}