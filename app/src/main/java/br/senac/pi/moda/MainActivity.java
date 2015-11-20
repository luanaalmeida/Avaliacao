package br.senac.pi.moda;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.pi.moda.domais.ListRoupaActivity;
import br.senac.pi.moda.domais.RoupaDB;

public class MainActivity extends AppCompatActivity {
RoupaDB roupasDB;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roupasDB = new RoupaDB(this);

        findViewById(R.id.bntListarRoupa).setOnClickListener(abrirListarRoupa());
        findViewById(R.id.bntCadastrarRoupa).setOnClickListener(cadastrarRoupa());
    }

    private View.OnClickListener abrirListarRoupa() {
    }

    private View.OnClickListener cadastrarRoupa() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                database = roupasDB.getWritableDatabase();


                EditText edtPeca = (EditText) findViewById(R.id.edtPeca);
                EditText edtCor = (EditText) findViewById(R.id.edtCor);
                EditText edtTamanho = (EditText) findViewById(R.id.edtTamanho);

                String Peça = edtPeca.getText().toString();
                String Cor = edtCor.getText().toString();
                String Tamanho = edtTamanho.getText().toString();
                ContentValues values = new ContentValues();
                values.put("peca", Peça);
                values.put("cor", Cor);
                values.put("tamanho", Tamanho);
//banco SQLite
                long id = database.insert("roupa", null, values);
                if (id != 0){
                    Toast.makeText(getApplicationContext(), getString(R.string.sucesso), Toast.LENGTH_LONG).show();
                    edtPeca.setText("");
                    edtCor.setText("");
                    edtTamanho.setText("");

                    edtPeca.requestFocus();
                }else {
                    Toast.makeText(getApplicationContext(),getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        };
    }




    private View.OnClickListener abrirListarCarros() {
        return new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ListRoupaActivity.class);
                startActivity(intent);

            }
        };

    }
    }

