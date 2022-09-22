import java.io.*;
import java.util.*;
public class Elinimacionpalabras {

    static String delimitadores = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
            + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*|\\d+";

    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("divina_comedia.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] palabrasDeLaLinea = linea.toLowerCase().split(delimitadores);
                for (int i = 0; i  < palabrasDeLaLinea.length; i++) {
                    palabras.add(palabrasDeLaLinea[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> stopWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("stopwords-es.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                stopWords.add(linea.toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < palabras.size(); i++) {
            set.add(palabras.get(i));
        }

        for (int i = 0; i < stopWords.size(); i++) {
            set.remove(stopWords.get(i));
        }

        Iterator<String> iterador = set.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        System.out.println("\nHay " + set.size() + " sin duplicar");

    }


}
    
