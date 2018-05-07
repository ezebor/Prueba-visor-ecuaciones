package com.example.ezequielborenstein.pruebavisorecuaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.github.kexanie.library.MathView;

public class FormulaViewer {

    public static void displayFormula(MathView formulaViewer, Operations operations, Boolean isPreview){
        formulaViewer.setText("\\(" + operations.getEquationPrettyFormat(isPreview) + "\\)");
    }
}