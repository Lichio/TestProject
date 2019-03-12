package org.io;

import java.io.*;
import java.util.Scanner;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class WriteToProcess {
    public static void main(String[] args)throws IOException{
        Process process = Runtime.getRuntime().exec("java ReadStandard");

        System.out.println(new File(".").getAbsoluteFile());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        PrintStream printStream = new PrintStream(process.getOutputStream());
        printStream.print("This is my first Line input!");
        printStream.print("This is My second Line input!");
    }
}

class ReadStandard{
    public static void main(String[] args)throws IOException{
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(new FileOutputStream("E:\\Java\\Code\\out.txt"));
        scanner.useDelimiter("\n");
        while(scanner.hasNext()){
            printStream.print("The input is:" + scanner.next());
        }

    }
}
