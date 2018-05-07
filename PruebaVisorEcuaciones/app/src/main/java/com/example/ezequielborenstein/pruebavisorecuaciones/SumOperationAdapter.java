package com.example.ezequielborenstein.pruebavisorecuaciones;

import android.graphics.Color;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SumOperationAdapter extends OperationAdapter {

    public String getOperator(){
        return "+";
    }

    public Boolean isSum(){
        return true;
    }
}