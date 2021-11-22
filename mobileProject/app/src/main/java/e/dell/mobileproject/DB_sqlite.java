package e.dell.mobileproject;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DB_sqlite extends SQLiteOpenHelper {

    private static final String table_name = "contacts";
    private static final String column_id = "id";
    private static final String column_name = "name";
    private static final String column_password = "pass";
    private static final String column_email = "email";
    SQLiteDatabase db;

    public DB_sqlite(Context context) {
        super(context, "Login.db", null, 1);
    }

    private static final String table_create = "create table user(email text primary key, password text)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_create);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exist user";
        db.execSQL(query);
    }

    //insert in db
    public boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }

    //check if email exist
    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    //checking the email and password
    public boolean emailPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email, password});
        if (cursor.getCount() > 0) return true;
        else return false;


    }



}
