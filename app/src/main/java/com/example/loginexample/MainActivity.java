package com.example.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.loginexample.User;

public class MainActivity extends AppCompatActivity {
    private EditText edtname;
    private EditText edtpassword;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        User user = new User("leen odeh", "leen1802");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname = findViewById(R.id.edtname);
        edtpassword = findViewById(R.id.edtpassword);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = edtname.getText().toString();
                String passwordtxt = edtpassword.getText().toString();
                if(nametxt.equals(user.getUsername()) && passwordtxt.equals(user.getPassword())){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name",nametxt);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
                edtname.setText("");
                edtpassword.setText("");
            }
        });
    }
}