package com.Marcha;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Specify Grammar file:");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String filepath = reader.readLine();

            File GrammarFile = new File("./" + filepath);
            System.out.println("Loading file:");
            System.out.println(GrammarFile.getAbsoluteFile());

            Scanner myReader = new Scanner(GrammarFile);

            Grammar grammar = new Grammar(myReader);

            CYKParser parser = new CYKParser(grammar);
            myReader.close();

            while(true) {
                System.out.println("Loaded grammar, type a string to test it:");
                String input = reader.readLine();
                if("exit".equals(input)) {
                    System.out.println("Exiting.");
                    System.exit(0);
                    return;
                };
                parser.TestString(input);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e ) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


}
