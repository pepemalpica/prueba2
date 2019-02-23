package com.pepe.malpica;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pepe.malpica.models.ResponseErrorModel;
import com.pepe.malpica.models.ResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText etName, etPsw;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find views
        etName   = findViewById(R.id.et_name);
        etPsw    = findViewById(R.id.et_psw);
        btnLogin = findViewById(R.id.btn_login);

        //set btn listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin() {
        hideKeyboard(LoginActivity.this);
        boolean flag = true;
        String name, password, pswHash;
        name     = etName.getText().toString().trim();
        password = etPsw.getText().toString().trim();
        pswHash  = md5(password);

        //validate fields
        if( name.isEmpty() ){
            etName.setError("Nombre es requerido!");
            flag = false;
        }
        if( password.isEmpty() ){
            etPsw.setError("La contraseña es requerida!");
            flag = false;
        }

        if( flag ){
            sendRequest(name, pswHash);
        }

    }

    private void sendRequest(String name, String password)  {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        final String URL = "http://blumonpay.biz/BancaMifel/Pruebas/login_test";
        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("usuario", name);
        params.put("contrasena", password);


        JsonObjectRequest request_json = new JsonObjectRequest(Request.Method.POST , URL, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @SuppressLint("ShowToast")
                    @Override
                    public void onResponse(JSONObject response) {
                        //Process os success response
                        Log.d("res", String.valueOf(response));
                        Gson mGson = new Gson();
                        try {
                            boolean status = (boolean) response.get("estatus");
                            if( status ){

                                ResponseModel mResponse = mGson.fromJson(String.valueOf(response), ResponseModel.class);
                                goHome(mResponse);
                            }else{
                                //Error on login
                                ResponseErrorModel mError = mGson.fromJson(String.valueOf(response), ResponseErrorModel.class);
                                Toast.makeText(LoginActivity.this, mError.getMensaje(), Toast.LENGTH_LONG).show();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        // add the request object to the queue to be executed
        requestQueue.add(request_json);
    }

    private void goHome( ResponseModel mResponse ){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ResponseModel", mResponse);
        startActivity(intent);
    }

    public static String md5(String s) {
        String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
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

}
