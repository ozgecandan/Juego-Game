package e.dell.mobileproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterPage extends AppCompatActivity {

    Button buttonfacebook, buttoninsta, buttontwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_page);

        buttonfacebook = findViewById(R.id.buttonfacebook);
        buttonfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse("https://tr-tr.facebook.com/");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });

        buttoninsta = findViewById(R.id.buttoninsta);
        buttoninsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse("https://www.instagram.com/?hl=tr");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });

        buttontwitter = findViewById(R.id.buttontwitter);
        buttontwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse("https://twitter.com/?lang=tr");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });


    new Thread(new Runnable()
    {
        public void run()
        {
            try {
                Thread.sleep(3000);
                Intent intent = new Intent(EnterPage.this, signup.class);
                startActivity(intent);
            }
            catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }).start();
}
}