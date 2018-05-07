package com.example.ezequielborenstein.pruebavisorecuaciones;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    private List<OperationAdapter> operations;

    public Operations(){
        this.operations = new ArrayList<>();
    }

    public void add(OperationAdapter currentOperator){
        this.operations.add(currentOperator);
    }

    public Integer size(){
        return this.operations.size();
    }

    public String getEquation(Boolean isPreview){
        String equation = "";
        for(OperationAdapter operatorAdapter : operations){
            equation += operatorAdapter.getOperation();
        }

        if(isPreview){
            equation = equation.replace("null", "?");

            // This is to set '?' at the beginning of the equation when first operand does not exist
            if(this.operations.size() == 1){
                equation = "?" + equation;
            }
        }

        return equation;
    }

    public String getEquationPrettyFormat(Boolean isPreview){
        String equation = "";
        for(OperationAdapter operatorAdapter : operations){
            equation += operatorAdapter.getOperationPrettyFormat();
        }

        if(isPreview){
            equation = equation.replace("null", "?");
        }

        return equation;
    }
}