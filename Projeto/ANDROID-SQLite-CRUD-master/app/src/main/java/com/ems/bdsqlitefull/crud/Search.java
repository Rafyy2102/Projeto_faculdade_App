package com.ems.bdsqlitefull.crud;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.ems.bdsqlitefull.R;
import com.ems.bdsqlitefull.pojo.Cliente;
import android.view.MenuItem;
import android.widget.EditText;
import java.util.ArrayList;

public class Search extends AppCompatActivity {
    ArrayList<Cliente> clientes = new ArrayList<>();
    SQLiteDatabase db;
    Button btnPesquisar;
    EditText cpf;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Pesquisa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        cpf = findViewById(R.id.pesquisaCPF);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openOrCreateDatabase("db_cliente", Context.MODE_PRIVATE, null);


                Cursor c = db.rawQuery("SELECT * FROM cliente WHERE cpf=?", new String[]{cpf.getText().toString()});
                while (c.moveToNext()) {
                    cliente = new Cliente(
                            c.getInt(0),
                            c.getString(1),
                            c.getString(2),
                            c.getString(3),
                            c.getString(4),
                            c.getString(5));
                }

                Intent search = new Intent(getApplicationContext(), Details.class);
                search.putExtra("objCliente", cliente);
                startActivity(search);
            }
        });
    }

    //Configura o botão (seta) na ActionBar (Barra Superior)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}