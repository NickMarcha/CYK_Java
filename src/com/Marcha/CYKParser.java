package com.Marcha;

import java.util.ArrayList;
import java.util.List;

public class CYKParser {
    Grammar grammar;
    public CYKParser(Grammar grammar){
        this.grammar = grammar;
    }

    public void TestString(String inputString){
        String[] a = inputString.split("");

        int n = a.length;
        List<Symbol>[][] T = new List[n+1][n+1];

        for (int i1 = 0; i1< T.length; i1++){
            for (int i2 = 0; i2 < T[i1].length; i2++){
                T[i1][i2] = new ArrayList<Symbol>();
            }
        }

        for (int j = 1; j <= n; j++) {
            for (Pair<Symbol,String> rule: grammar.terminalRules
            ) {
                if(a[j-1].equals(rule.right)){
                    System.out.println(j);
                    T[j-1][j].add(rule.left);
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

                for (Pair<Symbol,Pair<Symbol,Symbol>> rule: grammar.nonTerminalRules
                ) {
                    if(P.contains(rule.right)){
                        T[i][j].add(rule.left);
                        printTable(T);
                    }

                }
            }
        }

        if (T[0][n].contains(new Symbol("S"))){
            System.out.println("{"+inputString + "} is included in Grammar");
        } else {
            System.out.println("{"+inputString + "} is not included in Grammar");
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
