package com.example.textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUserName;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        textInputEmail = findViewById(R.id.text_input_email);
        textInputUserName = findViewById(R.id.text_input_user_name);
        textInputPassword = findViewById(R.id.text_input_epassword);
    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if(emailInput.isEmpty()){
            textInputEmail.setError("Field can not be empty");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validateUserName(){
        String userName = textInputUserName.getEditText().getText().toString().trim();
        if(userName.isEmpty()){
            textInputUserName.setError("Field can not be empty");
            return false;
        }else if(userName.length()>15){
            textInputUserName.setError("Username is too long");
            return false;
        }else{
            textInputUserName.setError(null);
            return true;
        }
    }


    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if(passwordInput.isEmpty()){
            textInputPassword.setError("Field can not be empty");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v){
        if(!validateEmail() | !validateUserName() | !validatePassword()){
            return;
        }
        String input = "Email: "+textInputEmail.getEditText().getText().toString();
        input += "\nUser name: "+textInputUserName.getEditText().getText().toString();
        input += "\nPassword: "+textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }


}