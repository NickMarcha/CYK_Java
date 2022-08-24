package com.Marcha;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //String sentence = "she eats a fish with a fork";
        //String[] a = sentence.split(" ");

        String sentence = "baaba";
        String[] a = sentence.split("");

        int n = a.length;
        List<Symbol>[][] T = new List[n+1][n+1];

        for (int i1 = 0; i1< T.length; i1++){
            for (int i2 = 0; i2 < T[i1].length; i2++){
                T[i1][i2] = new ArrayList<Symbol>();
            }
        }

        Pair<Symbol, String>[] terminalRules = new Pair[]{
                new Pair(new Symbol("A"), "a"),
                new Pair(new Symbol("B"), "b"),
                new Pair(new Symbol("C"), "a"),
        };

        Pair<Symbol,Pair<Symbol,Symbol>>[] nonTRules = new Pair[]{
                new Pair<>(new Symbol("S"),
                        new Pair<>(new Symbol("A"), new Symbol("B"))),
                new Pair<>(new Symbol("S"),
                        new Pair<>(new Symbol("B"), new Symbol("C"))),

                new Pair<>(new Symbol("A"),
                        new Pair<>(new Symbol("B"), new Symbol("A"))),

                new Pair<>(new Symbol("B"),
                        new Pair<>(new Symbol("C"), new Symbol("C"))),
                new Pair<>(new Symbol("C"),
                        new Pair<>(new Symbol("A"), new Symbol("B"))),
        };
        /*
        Pair<Symbol, String>[] terminalRules = new Pair[]{
                new Pair(new Symbol("VP"), "eats"),
                new Pair(new Symbol("NP"), "she"),
                new Pair(new Symbol("V"), "eats"),
                new Pair(new Symbol("P"), "with"),
                new Pair(new Symbol("N"), "fish"),
                new Pair(new Symbol("N"), "fork"),
                new Pair(new Symbol("Det"), "a"),
        };

        Pair<Symbol,Pair<Symbol,Symbol>>[] nonTRules = new Pair[]{
                new Pair<>(new Symbol("S"),
                        new Pair<>(new Symbol("NP"), new Symbol("VP"))),
                new Pair<>(new Symbol("VP"),
                        new Pair<>(new Symbol("VP"), new Symbol("PP"))),
                new Pair<>(new Symbol("VP"),
                        new Pair<>(new Symbol("V"), new Symbol("NP"))),
                new Pair<>(new Symbol("PP"),
                        new Pair<>(new Symbol("P"), new Symbol("NP"))),
                new Pair<>(new Symbol("NP"),
                        new Pair<>(new Symbol("Det"), new Symbol("N"))),
        };
         */

        for (int j = 1; j <= n; j++) {
            for (Pair<Symbol,String> rule: terminalRules
                 ) {
                if(a[j-1].equals(rule.y)){
                    System.out.println(j);
                    T[j-1][j].add(rule.x);
                    printTable(T);
                }
            }


            for (int i = j-2;  i >= 0; i--){
                List<Pair<Symbol, Symbol>> P = new ArrayList<>();

                for (int k = i+1; k <= j-1; k++ ){
                    List<Symbol> One = T[i][k];
                    List<Symbol> Two  =T[k][j];
                    P.addAll(findCart(One, Two));
                }

                for (Pair<Symbol,Pair<Symbol,Symbol>> rule:nonTRules
                     ) {
                    if(P.contains(rule.y)){
                        T[i][j].add(rule.x);
                        printTable(T);
                    }

                }
            }
        }



        if (T[0][n].contains(new Symbol("S"))){
            System.out.println("{"+sentence + "} is included in Grammar");
        } else {
            System.out.println("{"+sentence + "} is not included in Grammar");
        }
    }

    static void printTable (List<Symbol>[][] T) {
        for (int i = 0; i < T.length-1; i++) {
            for (int j = 1; j < T[i].length; j++) {
                String items = T[i][j].toString();

                for (int ip = items.length(); ip < 15 ; ip ++){
                    items += " ";
                }
                System.out.print(items + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static List<Pair<Symbol,Symbol>> findCart(List<Symbol> arr1, List<Symbol> arr2)
    {

        List<Pair<Symbol,Symbol>> result = new ArrayList<>();
        for (int i = 0; i <arr1.size(); i++)
            for (int j = 0; j < arr2.size(); j++)
                result.add(new Pair<>(arr1.get(i),arr2.get(j)));
        return result;
    }
}
