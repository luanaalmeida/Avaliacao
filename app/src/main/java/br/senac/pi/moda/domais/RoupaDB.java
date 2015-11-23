package br.senac.pi.moda.domais;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class RoupaDB extends SQLiteOpenHelper {

    private static final String TAG = "sql";


    private static final String NOME_BANCO = "moda.sqlite";
    private static final int VERSAO_BANCO = 1;



    public RoupaDB(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    public void onCreate(SQLiteDatabase db) {

        Log.d(TAG, "Criação da tabela Roupa");
        db.execSQL("CREATE TABLE IF NOT EXISTS roupa (_id integer primary key autoincrement," + "peca text, Cor text, Tamanho Text);");
        Log.d(TAG, "Tabela de Roupa criada com sucesso");
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Roupa> FindAli(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor cursor = db.query("roupa", null, null, null, null, null, null, null);
        }finally {
            db.close();

    }
    }

        private List<Roupa> toList (Cursor cursor){
            List<Roupa> roupas = new ArrayList<Roupa>();
            if (cursor.moveToFirst()) {
                do {
                    Roupa roupa = new Roupa();
                    roupas.add(roupa);
                    roupa.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                    roupa.setPeca(cursor.getString(cursor.getColumnIndex("Peca")));
                    roupa.setCor(cursor.getString(cursor.getColumnIndex("Cor")));
                    roupa.setTamanho(cursor.getString(cursor.getColumnIndex("Tamanho")));

                } while (cursor.moveToNext());
            }
            
            return roupas;
        }
    }


