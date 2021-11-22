package e.dell.mobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText email,password;
    Button login,signup, buttoninfo;
    DB_sqlite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DB_sqlite(this);
        email = (EditText)findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);
        signup= (Button)findViewById(R.id.button2);
        buttoninfo = (Button)findViewById(R.id.buttoninfo);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

        buttoninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, information.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eMail = email.getText().toString();
                String passWord = password.getText().toString();
                Boolean checkemailpass = db.emailPassword(eMail, passWord);
                if(checkemailpass ==true){
                    Toast.makeText(getApplicationContext(),"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, pagecards.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Yanlış Email / Sifre",Toast.LENGTH_SHORT).show();
            }
        });
    }
}


