package com.hitomi.circlemenu;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, user TEXT, comment TEXT)";
    private static final String DB_NAME = "comments.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;
    public MyOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMENTS_TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    //Insertar un nuevo Comentario
    public void insertar(String nombre,String COMENTARIO){
        ContentValues cv = new ContentValues();
        cv.put("user", nombre);
        cv.put("comment", COMENTARIO);
        db.insert("comments", null, cv);
    }
    //Borrar un Comentario a partir de su id
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("comments", "_id=?", args);
    }
    //Obtener la activity_lista de COMENTARIOs en la base de datos
    public ArrayList<Comentario> getComments(){
//Creamos el cursor
        ArrayList<Comentario> lista=new ArrayList<Comentario>();
        Cursor c = db.rawQuery("select _id, user,comment from comments",
                null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
//Asignamos el valor en nuestras variables para crear un nuevo objeto Comentario
                String user = c.getString(c.getColumnIndex("user"));
                String comment = c.getString(c.getColumnIndex("comment"));
                int id=c.getInt(c.getColumnIndex("_id"));
                Comentario com =new Comentario(id,user,comment);
//Añadimos el Comentario a la activity_lista􀀁
                lista.add(com);
            } while (c.moveToNext());
        }
//Cerramos el cursor
        c.close();
        return lista;
    }
}