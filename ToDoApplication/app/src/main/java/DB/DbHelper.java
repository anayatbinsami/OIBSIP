package DB;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.SigningInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Display;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Models.Model;
import Models.UserModel;

public class DbHelper extends SQLiteOpenHelper {
final static  String DBNAME ="database.db";
private static final String tododata = "create table"+" tododata"+"(id integer primary key autoincrement,"+"title text,"+"discription text)";
    private static final String SignUp = "create table "+"SignUp"+"(id integer primary key autoincrement, "+" name text,"+"email text , "+"password text)";

    public DbHelper(@Nullable Context context) {
        super(context,DBNAME,null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tododata);
        db.execSQL(SignUp);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tododata");
        db.execSQL("drop table if exists SignUp");
        onCreate(db);

    }

    public boolean insirtdata(String title,String discription){
        SQLiteDatabase database= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("discription",discription);
        long id = database.insert("tododata",null,values);
        if (id<+0){
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList<Model> getdata(){
        ArrayList<Model> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select id,title,discription from tododata ",null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Model model = new Model();
                model.setId(cursor.getInt(0));
                model.setTitle(cursor.getString(1));
                model.setDiscription(cursor.getString(2));
                list.add(model);
            }
        }
        cursor.close();
        database.close();
        return list;
    }
    public boolean updatedata(String title,String discription,int id){
        SQLiteDatabase database= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("discription",discription);
        long row = database.update("tododata",values,"id="+id,null);
        if (row<+0){
            return false;
        }
        else {
            return true;
        }
    }

    public int deleteData(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("tododata","id="+id,null);
    }

    public boolean SignUp(String name,String email,String password){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("email",email);
        values.put("password",password);
        long signup = database.insert("SignUp",null,values);
        if (signup<+0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkeduser(String email){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from SignUp where email =?",new String[]{email},null);
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean loginUser (String email,String password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from SignUp where email = ? and password = ?",new String[]{email,password},null);
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
