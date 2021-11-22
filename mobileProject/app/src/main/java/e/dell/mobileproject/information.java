package e.dell.mobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class information extends AppCompatActivity {

    Button back;
    ImageView img;
    int[] icon = new int[]{R.drawable.infobir, R.drawable.infoiki, R.drawable.infouc};
    int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        img = findViewById(R.id.imageView);

        back = findViewById(R.id.buttonback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(information.this, login.class);
                startActivity(intent);
            }
        });
    }
    public void next(View view){
        img.setImageResource(icon[n]);
        if (n < 3)
            n++;
    }

    public void previous(View view){
        img.setImageResource(icon[n]);
        if (n > 0)
            n--;
    }
}
