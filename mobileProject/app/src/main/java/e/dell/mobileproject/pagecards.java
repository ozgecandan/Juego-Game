package e.dell.mobileproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

public class pagecards extends AppCompatActivity {

    int sonKart = 0; //son çevrrilen kartın idsini diğerleriyle karışmasın diye 0 yaptım.(kart idlerim 1 den başlıyordu)
    int skor;
    QuizDBHelper db;

    static boolean clickedtarih = false;
    static boolean clickedcografya = false;
    static boolean clickedsanat = false;
    static boolean clickedeglence = false;
    static boolean clickedspor = false;
    static boolean clickedbilim = false;
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";


    private TextView textViewHighscore;
    private int highscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        GridLayout gl= (GridLayout)findViewById(R.id.gridlayout);
        card cards[] = new card[6];
        for(int j = 1; j<=6; j++){
            cards[j-1] = new card(this, j); //butonu ekrana her koyuşta ona bir rakam yani ID veriyoruz (j değeri=id) (diziyi 1 den başlattığımız için ulaşmaya çalışırken j-1. elemandan başladık. 0. elemana 1 id sini verdik
            cards[j-1].setOnClickListener(new View.OnClickListener() { //kartların ön ve arkalarını çevirmem için onları dinlemem gerek. butonların herbiri için listener tanımladım
                @Override
                public void onClick(View v) { //herhangi bir butona tıklandığında
                    final card c = (card)v; //viewı karta çevirdim. çünkü kartlarım buton yani view ve viewı karta çevirebilirim
                    c.turn(); //turn methodumu çağırıyorum. böylece arkası dönükse önü, önü dönükse arkası geliyo

                    if (sonKart == 0 && c.foregroundID == R.drawable.bilimicon) { //son kartın id si 0 değilse yani 1. kartı çeviriyosam
                        //c.turn();
                        //sonKart = c.foregroundID;
                        c.cevrilebilir = false;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                        AlertDialog.Builder builder = new AlertDialog.Builder(pagecards.this);
                        builder.setMessage("Konu Başlığı: BİLİM")
                                .setPositiveButton("OYNA", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent intent = new Intent(pagecards.this, QuizActivity.class);
                                        startActivity(intent);
                                        clickedbilim = true;
                                        startQuiz();



                                    }
                                }).show();
                    }

                    if (sonKart == 0 && c.foregroundID == R.drawable.tarihicon) {
                        c.cevrilebilir = false;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                            }
                        }).start();

                        AlertDialog.Builder builder = new AlertDialog.Builder(pagecards.this);
                        builder.setMessage("Konu Başlığı: TARİH")
                                .setPositiveButton("OYNA", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent intent = new Intent(pagecards.this, QuizActivity.class);
                                        startActivity(intent);
                                        clickedtarih = true;
                                        startQuiz();


                                    }
                                }).show();
                    }


                    if (sonKart == 0 && c.foregroundID == R.drawable.eglenceicon) {
                        c.cevrilebilir = false;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                            }
                        }).start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(pagecards.this);
                        builder.setMessage("Konu Başlığı: EĞLENCE")
                                .setPositiveButton("OYNA", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent intent = new Intent(pagecards.this, QuizActivity.class);
                                        startActivity(intent);
                                        clickedeglence = true;
                                        startQuiz();
                                    }
                                }).show();
                    }

                    if (sonKart == 0 && c.foregroundID == R.drawable.sporicon) {
                        c.cevrilebilir = false;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                            }
                        }).start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(pagecards.this);
                        builder.setMessage("Konu Başlığı: SPOR")
                                .setPositiveButton("OYNA", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent intent = new Intent(pagecards.this, QuizActivity.class);
                                        startActivity(intent);
                                        clickedspor = true;
                                        startQuiz();
                                    }
                                }).show();
                    }

                    if (sonKart == 0 && c.foregroundID == R.drawable.cografyaicon) {
                        c.cevrilebilir = false;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                            }
                        }).start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(pagecards.this);
                        builder.setMessage("Konu Başlığı: COĞRAFYA")
                                .setPositiveButton("OYNA", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent intent = new Intent(pagecards.this, QuizActivity.class);
                                        startActivity(intent);
                                        clickedcografya = true;
                                        startQuiz();
                                    }
                                }).show();
                    }

                    if (sonKart == 0 && c.foregroundID == R.drawable.sanaticon) {
                        c.cevrilebilir = false;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                            }
                        }).start();
                        AlertDialog.Builder builder = new AlertDialog.Builder(pagecards.this);
                        builder.setMessage("Konu Başlığı: SANAT")
                                .setPositiveButton("OYNA", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        Intent intent = new Intent(pagecards.this, QuizActivity.class);
                                        startActivity(intent);

                                        clickedsanat = true;
                                        startQuiz();
                                    }
                                }).show();
                    }
                    //if(clickedbilim==true){card.setBackground(card.front);}
                   // else{card.setBackground(card.back);}
                }
            });
        }
        //Kartları karıştırmak için swape işlemi yapıyoruz
        for(int j = 0; j<6; j++){
            int r = (int)(Math.random() * 6); //math.random 0-1 arasında sayı döndürüyor. bunu 6 le çarparak 0-6 arasında sayı döndürüyorum
            card c = cards[r];
            cards[r] = cards[j];
            cards[j] = c;
        }

        for(int j = 0; j<6; j++)
            gl.addView(cards[j]); //kartları ekrana ekliyoruz

    }

    public void startQuiz() {
        Intent intent = new Intent(pagecards.this, QuizActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

   private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);

    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }

}
