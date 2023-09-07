import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONObject;

public class Tarefa7 {
    public static void main(String[] args) {
        String cep = "68415000"; //CEP a ser consultado

        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            //Aqui passamos os métodos necessários para fazer a busca
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            //Caso a consulta não seja diferente de 200 é retornado um erro
            if (con.getResponseCode() != 200){
                throw new RuntimeException("Erro na consulta: "+ con.getResponseCode());
            }

            //Função para
            BufferedReader str = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder respo = new StringBuilder();
            String output;

            while ((output = str.readLine()) != null){
                respo.append(output);
            }
            con.disconnect();
            //Utiliza-se a biblioteca JSONObject para obter a resposta da consulta
            JSONObject jsonObject = new JSONObject(respo.toString());

            //Os dados são lidos aqui do arquivo json
            String ibge = jsonObject.getString("ibge");
            String ddd = jsonObject.getString("ddd");

            System.out.println("Código IBGE: " + ibge);
            System.out.println("DDD: " + ddd);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}