package com.Marcha;

import java.util.*;

public class Grammar {
    public Set< Pair<Symbol, String>> terminalRules = new HashSet<>();

    public Set <Pair<Symbol,Pair<Symbol,Symbol>>> nonTerminalRules = new HashSet<>();

    public Grammar (Scanner scanner){
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            switch (tokens.length){
                case 3: //terminal rule: A -> a
                    terminalRules.add(
                            new Pair(new Symbol(
                            tokens[0]), tokens[2]));
                    break;
                case 4: //non terminal rule:  A -> B C
                    nonTerminalRules.add(
                            new Pair(new Symbol(
                                    tokens[0]),
                                    new Pair(
                                            new Symbol(tokens[2]), new Symbol(tokens[3]))));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Grammar{" +
                "terminalRules=" + terminalRules +
                ", nonTerminalRules=" + nonTerminalRules +
                '}';
    }
}
