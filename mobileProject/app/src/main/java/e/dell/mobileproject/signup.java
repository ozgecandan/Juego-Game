package e.dell.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class signup extends AppCompatActivity{
    DB_sqlite db;
    EditText susername,spassword,semail,spassword2;
    Button create,signup_login;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DB_sqlite(this);
        susername = findViewById((R.id.suserName));
        spassword = findViewById(R.id.sPassword);
        spassword2=findViewById(R.id.sPassword2);
        semail = findViewById(R.id.seMail);
        create =findViewById(R.id.create);
        signup_login = findViewById(R.id.signup_login);

        signup_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });


        final EditText et = (EditText)findViewById(R.id.suserName);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = semail.getText().toString();
                String s2 = spassword.getText().toString();
                String s3 = spassword2.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Alanlar Boş!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean checkemail = db.checkEmail(s1);
                        if(checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplication(),"Kayıt Başarılı!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(signup.this, login.class);
                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email zaten kayıtlı!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Sifre  uyumsuz!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
