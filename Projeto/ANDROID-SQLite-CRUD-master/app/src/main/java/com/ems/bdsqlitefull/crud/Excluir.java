package com.ems.bdsqlitefull.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ems.bdsqlitefull.MainActivity;
import com.ems.bdsqlitefull.R;
import com.ems.bdsqlitefull.pojo.Cliente;

public class Excluir extends AppCompatActivity {

    TextView id, cpf, telefone,  nome, email, descricao;
    Button Excluir;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Exclusão");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        cpf = findViewById(R.id.cpf);
        telefone = findViewById(R.id.telefone);
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        descricao = findViewById(R.id.descricao);
        Excluir = findViewById(R.id.btnExcluir);

        //Recupera os dados do aluno
        final Intent itCliente = getIntent();
        final Cliente cliente = (Cliente) itCliente.getExtras().getSerializable("objCliente");

        // atribui os dados aos campos
        id.setText(String.valueOf(cliente.getId()));
        cpf.setText(cliente.getCpf());
        telefone.setText(cliente.getTelefone());
        nome.setText(cliente.getNome());
        email.setText(cliente.getEmail());
        descricao.setText(cliente.getDescricao());

        //Excluindo registro
        Excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = openOrCreateDatabase("db_cliente", Context.MODE_PRIVATE, null);

                // Exclui o registro da tabela
                db.execSQL("DELETE FROM cliente WHERE id= " + cliente.getId());

                Toast.makeText(
                        Excluir.this,
                        "Registro excluído com sucesso!",
                        Toast.LENGTH_LONG).show();

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                finish();

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