package br.senac.pi.moda.domais;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.security.acl.AclNotFoundException;

import br.senac.pi.moda.R;



public class ListRoupaActivity extends AppCompatActivity {
    private CursorAdapter dataSource;
    private SQLiteDatabase database;
    private static final String campos[] = {"peca", "cor", "tamanho", "_id"};
    ListView listView;
    RoupaDB roupaDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_roupa);
        listView = (ListView) findViewById(R.id.listView);
        roupaDB = new RoupaDB(this);
        database = roupaDB.getWritableDatabase();
        findViewById(R.id.bntListarRoupa).setOnClickListener(AbrirListarRoupas());
    }


    private View.OnClickListener AbrirListarRoupas() {
        return new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Cursor roupas = database.query("roupa", campos , null, null, null, null, null);
                if (roupas.getCount()>0){
                    dataSource = new SimpleCursorAdapter(ListRoupaActivity.this, R.layout.row , roupas, campos, new int[]{R.id.txtPeca, R.id.txtCor, R.id.txtTamanho}, 0);
                    listView.setAdapter(dataSource);
                }else {
                    Toast.makeText(ListRoupaActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }
}
