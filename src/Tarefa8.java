import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tarefa8 {
    public static void main(String[] args) {
        String arquivoTexto = "C:\\Users\\ala_r\\Documents\\projetos\\testFribralink\\teste\\algoritmoTeste\\src\\doc.txt";

        List<String> cpfCnpj = extrairCpfCnpj(arquivoTexto);

        System.out.print("Lista de CPFs e CNPJs encontrados:\n");
        for (String str : cpfCnpj) {
            System.out.println(str);
        }
    }
    private static List<String> extrairCpfCnpj(String texto) {

        List<String> cpfCnpj = new ArrayList<>();
        Pattern patternCPFCNPJ = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");


        try (FileReader fileReader = new FileReader(texto);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {


            String line;
            while ((line = bufferedReader.readLine()) != null){
                Matcher str = patternCPFCNPJ.matcher(line);
                while (str.find()){
                    String cpf_cnpj_encon = str.group();
                    cpfCnpj.add(cpf_cnpj_encon);
                }
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }

        return cpfCnpj;
    }

}