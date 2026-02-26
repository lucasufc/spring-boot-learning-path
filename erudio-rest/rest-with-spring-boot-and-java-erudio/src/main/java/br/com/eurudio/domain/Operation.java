package br.com.eurudio.domain;

public enum Operation {

    SUM("Sum"),
    SUB("Subtraction"),
    MUL("Multiplication"),
    DIV("Division"),
    AVG("Average"),
    SQRT("Square Root");
    private final String label;

    Operation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}