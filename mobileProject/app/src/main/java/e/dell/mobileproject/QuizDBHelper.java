package e.dell.mobileproject;

        import android.app.FragmentManager;
        import android.content.ContentValues;
        import android.content.Context;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.nio.charset.MalformedInputException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

        import e.dell.mobileproject.QuizContract.*;



public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mobileProje.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER," +
                QuestionsTable.COLUMN_CATEGORY + " TEXT "+
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    public void fillQuestionsTable() {
        ///Tarih
        Question q1 = new Question("MUSTAFA KEMAL'İN İLK GÖREV YAPTIĞI,VATAN VE HÜRRİYET CEMİYETİNİ KURDUĞU YER NERESİDİR?", "ŞAM", "SELANİK", "İSTANBUL", 1, "Tarih");
        addQuestion(q1);
        Question q2 = new Question("OSMANLI DEVLETİNDE KAÇ TANE MURAT İSİMLİ PADİŞAH VARDIR?", "17", "5", "9", 2, "Tarih");
        addQuestion(q2);
        Question q3 = new Question("AŞAĞIDAKİ İLERDEN HANGİSİ OSMANLI'YA BAŞKENTLİK YAPMIŞTIR?", "TEKİRDAĞ", "KOCAELİ", "EDİRNE", 3, "Tarih");
        addQuestion(q3);
        Question q4 = new Question("ÇANAKKALE DENİZ ZAFERİNİN TARİHİ NEDİR?", "18 MART 1915", "6 MAYIS 1908", "23 NİSAN 1920", 1, "Tarih");
        addQuestion(q4);
        Question q5 = new Question("EFSANEYE GÖRE KRAL MİDAS'IN DOKUNDUĞU ŞEYLERE NE OLUR?", "ŞANSLI OLUR", "ALTINA DÖNÜŞÜR", "BUHARLAŞIR", 2, "Tarih");
        addQuestion(q5);
        //Coğrafya
        Question q6 = new Question("HANGİSİ ÜLKEMİZİ ÇEVRELEYEN DENİZLERDEN BİRİ DEĞİLDİR?", "AKDENİZ", "HAZAR DENİZİ", "KARADENİZ", 2,"Coğrafya");
        addQuestion(q6);
        Question q7 = new Question("ÇİN'İN EKONOMİK BAŞKENTİ HANGİSİDİR?", "ŞANGAY", "PEKİN", "HONG KONG", 1,"Coğrafya");
        addQuestion(q7);
        Question q8 = new Question("HANGİ ÜLKE EN YÜKSEK İNSAN NÜFUSUNA SAHİPTİR?", "BREZİLYA", "ÇİN", "BİRLEŞİK DEVLETLER", 2,"Coğrafya");
        addQuestion(q8);
        Question q9 = new Question("DÜNYANIN EN UZUN İKİNCİ SAHİLİ NEREDEDİR?", "DUBAİ", "MİAMİ", "HATAY/SAMANDAĞ", 3,"Coğrafya");
        addQuestion(q9);
        Question q10 = new Question("ÇANAKKALE'NİN PEYNİRİ İLE ÜNLÜ İLÇESİ NERESİDİR?", "AYVACIK", "EZİNE", "BİGA", 2,"Coğrafya");
        addQuestion(q10);
        ///Bilim
        Question q11 = new Question("ASİTİN PH DEĞERİ NEDİR?", "0-7", "0-14", "7-14", 1, "Bilim");
        addQuestion(q11);
        Question q12 = new Question("CEP TELEFONUNDAN NE TÜR SİNYALLER YAYILIR?", "GAMMA IŞINLARI", "X-RAY IŞINLARI", "RADYO DALGALARI", 3, "Bilim");
        addQuestion(q12);
        Question q13 = new Question("MATEMATİKTE İNTEGRAL ALMANIN TERSİ OLAN İŞLEM AŞAĞIDAKİLERDEN HANGİSİDİR?", "ÇIKARMA", "TÜREV", "LOGARİTMA", 2, "Bilim");
        addQuestion(q13);
        Question q14 = new Question("YERÇEKİMİNİ KİM BULDU?", "ISAAC NEWTON", "ALEXANDER FLEMİNG", "ALBERT EİNSTEİN", 1, "Bilim");
        addQuestion(q14);
        Question q15 = new Question("HANGİ TÜR BULUT FORMU YER SEVİYESİNDEDİR?", "STRATUS", "STRATUS", "SİS", 3, "Bilim");
        addQuestion(q15);
        //Sanat
        Question q16 = new Question("SUÇ VE CEZA ADLI ROMANIN YAZARI KİMDİR?", "TOLSTOY", "DOSTOYEVSKİ", "FRANZ KAFKA", 2,"Sanat");
        addQuestion(q16);
        Question q17 = new Question("HANGİSİ BİR ŞİİR ÖLÇÜSÜ DEĞİLDİR?", "SERBEST ÖLÇÜSÜ", "ARUZ ÖLÇÜSÜ", "HARF ÖLÇÜSÜ", 3,"Sanat");
        addQuestion(q17);
        Question q18 = new Question("GORA FİLMİNİN BAŞROL OYUNCUSU KİMDİR?", "CAN YILMAZ", "CEM YILMAZ", "ŞAHAN GÖKBAKAR", 2,"Sanat");
        addQuestion(q18);
        Question q19 = new Question("HANGİSİ EDEBİYATIMIZDA GARİP AKIMI ÖNCÜLERİNDEN DEĞİLDİR?", "ORHAN VELİ KANIK", "OKTAY RIFAT", "CEMAL SÜREYA", 1,"Sanat");
        addQuestion(q19);
        Question q20 = new Question("HANSEL VE GRETEL'İN BABALARININ MESLEĞİ NEDİR?", "ODUNCU", "DEĞİRMENCİ", "ÇÖMLEKÇİ", 1,"Sanat");
        addQuestion(q20);
        //Eğlence
        Question q21 = new Question("DÜNYACA ÜNLÜ ARABA MARKASI LAMBORGHİNİN SİMGESİ HANGİ HAYVANDIR?", "JAGUAR", "BOĞA", "AT", 2,"Eğlence");
        addQuestion(q21);
        Question q22 = new Question("YOUTUBE'IN EN ÇOK TIKLANAN ŞARKISI HANGİSİDİR?", "GANGNAM STYLE", "UMBRELLA", "DESPACITO", 3,"Eğlence");
        addQuestion(q22);
        Question q23 = new Question("BÜYÜK ANNESİ KÖTÜ KURT TARAFINDAN YENİLEN MASAL KAHRAMANI KİMDİR?", "PAMUK PRENSES", "RAPUNZEL", "KIRMIZI BAŞLIKLI KIZ", 3,"Eğlence");
        addQuestion(q23);
        Question q24 = new Question("BİR KÜÇÜK EYLÜL MESELESİ ADLI SİNEMA FİLMİNDE BAŞROLDE OYNAYAN EYLÜL KARAKTERİNİ KİM CANLANDIRMIŞTIR?", "FARAH ZEYNEP ABDULLAH", "FAHRİYE EVCEN", "BEREN SAAT", 1,"Eğlence");
        addQuestion(q24);
        Question q25 = new Question("HANGİ ŞARKICI 'THRILLER' ŞARKISINI SÖYLER?", "THE BEATLES", "MICHEAL JACKSON", "HARRY STYLES", 2,"Eğlence");
        addQuestion(q25);
        //Spor
        Question q26 = new Question("TÜRKİYE LİGİNDE YENİLGİSİZ ŞAMPİYON OLAN TAKIM HANGİSİDİR?", "GALATASARAY", "BEŞİKTAŞ", "FENERBAHÇE", 2,"Spor");
        addQuestion(q26);
        Question q27 = new Question("HANGİ FUTBOLCU GALATASARAYDA FORMA GİYMEMİŞTİR?", "SERGEN YALÇIN", "FRANK RİBERY", "RIDVAN DİLMEN", 3,"Spor");
        addQuestion(q27);
        Question q28 = new Question("BÜTÜN DÜNYA KUPALARINA KATILMIŞ OLAN ÜLKE HANGİSİDİR?", "ARJANTİN", "BREZİLYA", "JAPONYA", 2,"Spor");
        addQuestion(q28);
        Question q29 = new Question("BADMİNTON EN AZ KAÇ KİŞİ İLE OYNANIR?", "2", "1", "4", 1,"Spor");
        addQuestion(q29);
        Question q30 = new Question("JOKEYLERİN BİNDİĞİ HAYVAN HANGİSİDİR?", "EŞEK", "AT", "ZEBRA", 2,"Spor");
        addQuestion(q30);

    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_CATEGORY,question.getCategory());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    public List<Question> getAllQuestion(String category) {
        final List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[] {category};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " =? "  ,selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();

        return questionList;
    }

}
