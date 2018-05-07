package com.example.ezequielborenstein.pruebavisorecuaciones;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.github.kexanie.library.MathView;

public abstract class OperationAdapter {

    public abstract String getOperator();
    public abstract void setOperands(Double operand1, Double operand2);
    public abstract String getOperation();
    public abstract void enableEditTextForNextOperand(Operations operations, InputMethodManager imm, EditText num1, EditText num2);
}