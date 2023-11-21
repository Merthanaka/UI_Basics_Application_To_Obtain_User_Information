package com.example.uibasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText editTextName , editTextEmail,editTextPass,editTextPassword2;
    private Button btnPickimg,btnReg;
    private TextView txtWarName,txtWarEmail,txtWarPass,txtWarPassRep;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnPickimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }
    private void initRegister(){
        Log.d(TAG,"initRegister : Started");
        if (validateData()){
            if(agreementCheck.isChecked()){
            showSnackBar();
            }else {
                Toast.makeText(this,"You need to agree to licence agreement",Toast.LENGTH_SHORT).show();
            }

        }
    }
    private void showSnackBar(){
        Log.d(TAG,"showSnackBar : started");
        txtWarName.setVisibility(View.GONE);
        txtWarEmail.setVisibility(View.GONE);
        txtWarPass.setVisibility(View.GONE);
        txtWarPassRep.setVisibility(View.GONE);

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        //String gender = "";
        //switch (rgGender.getCheckedRadioButtonId()){
         //   case R.id.rbMale:
          //     gender = "Male";

        //}

        String snackText = "Name : " + name + "\n" +
                "Email : " +email+ "\n" +
                "Country : "+ country;
        Log.d(TAG,"showSnackBar : Snack Bar Text : "+snackText);





        Snackbar.make(parent,"User Registered",Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        editTextName.setText("");
                        editTextEmail.setText("");
                        editTextPass.setText("");
                        editTextPassword2.setText("");

                    }
                }).show();
    }
    private boolean validateData(){
        Log.d(TAG,"validateData : Started");
        if (editTextName.getText().toString().equals("")){
            txtWarName.setVisibility(View.VISIBLE);
            txtWarName.setText("Enter your Name!");
            return false;
        }
        if (editTextEmail.getText().toString().equals("")){
            txtWarEmail.setVisibility(View.VISIBLE);
            txtWarEmail.setText("Enter your Email!");
            return false;
        }
        if (editTextPass.getText().toString().equals("")){
            txtWarPass.setVisibility(View.VISIBLE);
            txtWarPass.setText("Enter your Password!");
            return false;
        }
        if (editTextPassword2.getText().toString().equals("")){
            txtWarPassRep.setVisibility(View.VISIBLE);
            txtWarPassRep.setText("Enter your Password!");
            return false;
        }
        if (!editTextPass.getText().toString().equals(editTextPassword2.getText().toString())){
            txtWarPassRep.setVisibility(View.VISIBLE);
            txtWarPassRep.setText("Passwords are not matching ");
            return false;
        }
        return true;
    }
    private void initViews(){
        Log.d(TAG,"initViews : Started");
        editTextName = findViewById(R.id.editTextName);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);
        editTextPassword2 = findViewById(R.id.editTextPassword2);

        btnPickimg = findViewById(R.id.btnPickimg);
        btnReg = findViewById(R.id.btnReg);

        txtWarName = findViewById(R.id.txtWarName);
        txtWarEmail = findViewById(R.id.txtWarEmail);
        txtWarPass = findViewById(R.id.txtWarPass);
        txtWarPassRep = findViewById(R.id.txtWarPassRep);

        countriesSpinner = findViewById(R.id.spinnerCountry);
        rgGender= findViewById(R.id.rgGender);
        agreementCheck= findViewById(R.id.agreementCheck);
        parent=findViewById(R.id.parent);




    }
}