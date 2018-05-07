package com.example.ezequielborenstein.pruebavisorecuaciones;

import android.widget.EditText;

import io.github.kexanie.library.MathView;

public class OperandManager {

    public static Double getOperandFrom(EditText editText){
        String operand = editText.getText().toString();
        if(operand.equals("")){
            return null;
        }
        return Double.parseDouble(operand);
    }
}