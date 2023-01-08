package com.expression;

public class Expression implements Evaluable {
    private Evaluable leftOperand;
    private Evaluable rightOperand;
    private Operator operator;

    public Expression(Evaluable leftOperand, Evaluable rightOperand, Operator operator) {
        /* TODO */

    }

    @Override
    public double evaluate() {
        /* TODO */
        return 0;
    }
}
