package e.dell.mobileproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by Dell on 14.04.2018.
 */

public class card extends Button { //card classından oluşan her obje buton özelliği taşısın
    boolean isItOpen = false; //ilk olarak kartın arka yüzü dönük
    boolean cevrilebilir = true;
    int backgroundID; //arkaplan resminin IDsi
    int foregroundID = 0;
    Drawable back;
    Drawable front;

    public card(Context context, int id) {
        super(context);
        //setId(id);
        backgroundID = R.drawable.buttonback;     //resources(R)'ın altındaki drawabledan butonarkanın ID sini al

        if (id == 1)
        {
            foregroundID = R.drawable.eglenceicon;  //id=1 ise önplan resmi eğlence olcak
        }
        if (id == 2){
            foregroundID = R.drawable.bilimicon;
        }

        if (id == 3){
            foregroundID = R.drawable.cografyaicon;
        }

        if (id == 4){
            foregroundID = R.drawable.sanaticon;
        }

        if (id == 5){
            foregroundID = R.drawable.sporicon;
        }

        if (id == 6){
            foregroundID = R.drawable.tarihicon;
        }


        back = AppCompatDrawableManager.get().getDrawable(context, backgroundID);//Id'sini aldığım resmi ekrana çizdirmeliyim. ID integerdı bunu çizdirmem için drawable yapmam gerek
        front = AppCompatDrawableManager.get().getDrawable(context, foregroundID);
        setBackground(back);
    }
    public void turn(){
        if (cevrilebilir){ //kart çevrilebilirse
            if(!isItOpen){ // ve arkası çevrili ise
                setBackground(front); //önünü çevir
                isItOpen = true;
            }
            else{
                setBackground(back);
                isItOpen = false;
            }
        }

    }
}
