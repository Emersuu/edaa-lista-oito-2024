import java.io.*;
import java.util.*;

public class Aula8 {
    public static void main(String[] args) {
        String arquivoEntrada = "estudantes_una_2024.csv";
        String arquivoSaida = "nomes_estudantes_ordenados.csv";

        List<String> nomesEstudantes = new ArrayList<>();

        try (Scanner leitor = new Scanner(new File(arquivoEntrada))) {
            if (leitor.hasNextLine()) {
                leitor.nextLine(); 
            }

            while (leitor.hasNextLine()) {
                nomesEstudantes.add(leitor.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(nomesEstudantes);

        try (PrintWriter escritor = new PrintWriter(new FileWriter(arquivoSaida))) {
            for (String nome : nomesEstudantes) {
                escritor.println(nome);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Nomes dos estudantes foram ordenados e salvos em " + arquivoSaida);
    }
}