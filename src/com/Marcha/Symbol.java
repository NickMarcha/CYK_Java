package com.Marcha;

import java.util.Objects;

public class Symbol {
    String symbol;
    public Symbol(String s) {
        this. symbol = s;
    }

    @Override
    public String toString() {
        return "S{" +
                 symbol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol.equals(symbol1.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
