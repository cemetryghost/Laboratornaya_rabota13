package com.company;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("test.txt"); FileWriter fw = new FileWriter("output.txt")){
            int z;
            String text = "";
            while((z = fr.read()) != -1){
                text += (char)z;
            }

            String a = text.replaceAll("\\//.+", "");
            String b = a.replaceAll("/\\*(\r\n.+)*\\*/", "");
            String c = b.replaceAll("\\/\\*([\\S\\s]+)\\*\\/", "");

            fw.write(c);
            fw.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
