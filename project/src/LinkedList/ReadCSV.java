package LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    public static void main(String[] args) {
        try {
            String line = "";
            String splitBy = ";";
            BufferedReader br = new BufferedReader(new FileReader("/Users/mayankranjan/Downloads/username.csv"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        }
    }
}
