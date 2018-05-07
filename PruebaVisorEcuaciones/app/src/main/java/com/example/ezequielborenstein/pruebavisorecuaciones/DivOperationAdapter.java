package com.example.ezequielborenstein.pruebavisorecuaciones;

public class DivOperationAdapter extends OperationAdapter {

    public String getOperator(){
        return "/";
    }

    public String getOperationPrettyFormat(){
        return "\\frac{" + this.getOperand1() + "}{" + this.getOperand2() + "}";
    }
}