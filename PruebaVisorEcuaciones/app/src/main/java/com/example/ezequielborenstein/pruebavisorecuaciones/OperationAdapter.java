package com.example.ezequielborenstein.pruebavisorecuaciones;

import android.graphics.Color;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.github.kexanie.library.MathView;

public class OperationAdapter {
    private Double operand1;
    private Double operand2;

    public Double getOperand1() {
        return operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperands(Double operand1, Double operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOperation(){
        String operation = this.getOperator() + this.operand2;
        if(this.operand1 != null){
            operation = this.operand1 + operation;
        }

        return operation;
    }

    public String getOperationPrettyFormat(){
        return this.operand1 + this.getOperator() + this.operand2;
    }

    public void enableEditTextForNextOperand(Operations operations, InputMethodManager imm, EditText num1, EditText num2){
        EditText editTextToEdit;
        if(operations.size() == 1){
            editTextToEdit = num1;
            num2.setBackgroundColor(Color.GRAY);
        }else{
            editTextToEdit = num2;
            this.operand1 = null;
        }

        editTextToEdit.setEnabled(true);
        editTextToEdit.requestFocus();
        editTextToEdit.setBackgroundColor(Color.CYAN);
        imm.showSoftInput(editTextToEdit, InputMethodManager.SHOW_IMPLICIT);
    }

    public String getOperator(){
        return "";
    }

    public Boolean isSum(){
        return false;
    }
}