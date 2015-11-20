package br.senac.pi.moda.domais;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class RoupaDB extends SQLiteOpenHelper{

private static final String NOME_BANCO = "cursoRoupa.sqlite";
    private static final int VERSAO_BANCO = 1;
    private static final String TAG = "sql";


    public RoupaDB (Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);

    }
    //tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create teble moda (_id interage primary key" + "peça TEXT, cor TEXT, Tamanho TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int delete (Roupa roupa){
        SQLiteDatabase  db = getWritableDatabase();
        try {
            int count = db.delete("roupa ", "_id=?", new String[]{String.valueOf(roupa.getId())});
            Log.i(TAG,"delet[" + count +"]registro");
                    return count;
        }finally {
            db.close();
        }
    }
   /* public List<Roupa>findAli(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.query("roupa", null, null, null, null, null, null);
            return toList(cursor);
        }finally {
            db.close();
        }
    }

   private List <Roupa> toList (Cursor cursor){
        List<Roupa> roupa = new ArrayList<Roupa>();
        if (cursor.moveToFirst()){
            do {
                Roupa roupa = new Roupa();
                roupa.add (roupa);

                roupa.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                roupa.setPeca (cursor.getLong(cursor.getColumnIndex("peca")));
                roupa.setCor(cursor.getLong(cursor.getColumnIndex("cor")));
                roupa.getTamanho(cursor.getLong(cursor.getColumnIndex("tamanho")));

            }while (cursor.moveToFirst());
        }return roupa;
    }*/
}
