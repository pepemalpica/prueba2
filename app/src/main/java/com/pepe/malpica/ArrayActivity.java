package com.pepe.malpica;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ArrayActivity extends AppCompatActivity {

    private Toolbar tbArray;
    private EditText et1, et2,et3;
    private TextView tvRes;
    private Button btnCalculate;
    private String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        tbArray = (Toolbar) findViewById(R.id.tb_array);
        setSupportActionBar(tbArray);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //find views
        et1 = findViewById(R.id.et_1);
        et2 = findViewById(R.id.et_2);
        et3 = findViewById(R.id.et_3);
        tvRes = findViewById(R.id.tvRes);
        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void calculate() {
        hideKeyboard(ArrayActivity.this);
        String one, two, three;
        int sum1, sum2, sum3;

        one = et1.getText().toString().trim();
        two = et2.getText().toString().trim();
        three = et3.getText().toString().trim();

        //get arrays
        List<String> array1 = Arrays.asList(one.split("\\s*,\\s*"));
        List<String> array2 = Arrays.asList(two.split("\\s*,\\s*"));
        List<String> array3 = Arrays.asList(three.split("\\s*,\\s*"));

        sum1 = Integer.parseInt(array1.get(0)) + Integer.parseInt(array1.get(1)) + Integer.parseInt(array1.get(2));
        sum2 = Integer.parseInt(array2.get(0)) + Integer.parseInt(array2.get(1)) + Integer.parseInt(array2.get(2));
        sum3 = Integer.parseInt(array3.get(0)) + Integer.parseInt(array3.get(1)) + Integer.parseInt(array3.get(2));

        msg = "Array 1 = [ "+ array1.get(0) +", "+ array1.get(1) +", "+ array1.get(2) +" ], Total: " + sum1 +" \n";
        msg = msg + "Array 2 = [ "+ array2.get(0) +", "+ array2.get(1) +", "+ array2.get(2) +" ], Total: " + sum2 +" \n";
        msg = msg + "Array 3 = [ "+ array3.get(0) +", "+ array3.get(1) +", "+ array3.get(2) +" ], Total: " + sum3 +" \n";
        msg = msg + " SUMA TOTAL: " + (sum1 + sum2 +sum3) ;

        tvRes.setText(msg);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
