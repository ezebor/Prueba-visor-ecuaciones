package com.example.ezequielborenstein.pruebavisorecuaciones;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.kexanie.library.MathView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private OperationAdapter currentOperator;
    private Button sum;
    private Button div;
    private MathView formulaViewer;
    private Operations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operations = new Operations();

        CustomKeyboard keyboard = new CustomKeyboard();
        num1 = (EditText) findViewById(R.id.num1_id);
        num1.setOnEditorActionListener(keyboard);
        num1.setEnabled(false);

        num2 = (EditText) findViewById(R.id.num2_id);
        num2.setOnEditorActionListener(keyboard);
        num2.setEnabled(false);

        sum = (Button) findViewById(R.id.sum_id);
        div = (Button) findViewById(R.id.div_id);

        formulaViewer = (MathView) findViewById(R.id.formula_pretty_id);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View sumButton) {
                sum.setEnabled(false);
                div.setEnabled(false);

                currentOperator = new SumOperationAdapter();
                operations.add(currentOperator);

                ((TextView) findViewById(R.id.operator_label_id)).setText(currentOperator.getOperator());

                InputMethodManager imm = (InputMethodManager) getSystemService(num2.getContext().INPUT_METHOD_SERVICE);
                currentOperator.enableEditTextForNextOperand(operations, imm, num1, num2);
                FormulaViewer.displayFormula(formulaViewer, operations, true);
            }
        });
    }

    // Keyboard manager
    class CustomKeyboard implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView num, int actionId, KeyEvent event){
            if(actionId == EditorInfo.IME_ACTION_DONE && !num.getText().toString().equals("")){
                enterNextValueOrFinishOperation(num);
                return true;
            }else{
                num.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(num.getContext().INPUT_METHOD_SERVICE);
                return imm.showSoftInput(num, InputMethodManager.SHOW_IMPLICIT);
            }
        }
    }

    public void enterNextValueOrFinishOperation(View num){
        // Enter num 2
        if(num.getId() != num2.getId()){
            num1.setBackgroundColor(Color.TRANSPARENT);
            num2.setBackgroundColor(Color.CYAN);

            num2.setEnabled(true);
            num2.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(num2.getContext().INPUT_METHOD_SERVICE);
            imm.showSoftInput(num2, InputMethodManager.SHOW_IMPLICIT);
        }else{ // End operation
            currentOperator.setOperands(OperandManager.getOperandFrom(num1), OperandManager.getOperandFrom(num2));
            FormulaViewer.displayFormula(formulaViewer, operations, false);

            num1.setText("");
            num2.setText("");

            num1.setEnabled(false);
            num2.setEnabled(false);

            num1.setBackgroundColor(Color.TRANSPARENT);
            num2.setBackgroundColor(Color.TRANSPARENT);

            sum.setEnabled(true);
            div.setEnabled(true);

            ((TextView) findViewById(R.id.operator_label_id)).setText("");

            InputMethodManager keyboard = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            keyboard.hideSoftInputFromWindow(num.getWindowToken(), 0);
        }
    }
}
