package com.ems.bdsqlitefull.crud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.ems.bdsqlitefull.R;
import com.ems.bdsqlitefull.pojo.Cliente;

import java.util.ArrayList;

public class ListAll extends AppCompatActivity {
    ListView listViewClientes;
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayAdapter<Cliente> adaptador;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Listagem Geral");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        // Abre o banco de dados existente
        db = openOrCreateDatabase("db_cliente", Context.MODE_PRIVATE, null);

        listViewClientes = findViewById(R.id.listagem);

        // Carrega os registros em ordem alfabética no ArrayList para anexar ao adaptador
        clientes.clear();
        Cursor c = db.rawQuery("SELECT * FROM cliente ORDER BY nome ASC", null);
        while (c.moveToNext()) {
            clientes.add(new Cliente(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5)));
        }
        // Configura o adaptador
        adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                clientes);


        // Anexa o adaptador à ListView
        listViewClientes.setAdapter(adaptador);

        listViewClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente cliente = (Cliente) listViewClientes.getItemAtPosition(position);
                Intent itCliente = new Intent(getApplicationContext(), Details.class);
                itCliente.putExtra("objCliente", cliente);
                startActivity(itCliente);
            }
        });
    }

    // Configura o botão (seta) na ActionBar (Barra Superior)
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