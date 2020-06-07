package com.ems.bdsqlitefull.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ems.bdsqlitefull.R;
import com.ems.bdsqlitefull.pojo.Cliente;

public class Details extends AppCompatActivity {
    Button btEditar, btExcluir;
    TextView id, cpf, telefone,  nome, email, descricao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Detalhes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        cpf = findViewById(R.id.cpf);
        telefone = findViewById(R.id.telefone);
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        descricao = findViewById(R.id.descricao);
        btEditar = findViewById(R.id.btnEditar);
        btExcluir = findViewById(R.id.btnExcluir);

        Intent itCliente = getIntent();
        final Cliente cliente = (Cliente) itCliente.getExtras().getSerializable("objCliente");
        id.setText(String.valueOf(cliente.getId()));
        cpf.setText(cliente.getCpf());
        telefone.setText(cliente.getTelefone());
        nome.setText(cliente.getNome());
        email.setText(cliente.getEmail());
        descricao.setText(cliente.getDescricao());

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(getApplicationContext(), EditRecord.class);
                editar.putExtra("objCliente", cliente);
                startActivity(editar);
            }
        });

        id = findViewById(R.id.id);
        cpf = findViewById(R.id.cpf);
        telefone = findViewById(R.id.telefone);
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        descricao = findViewById(R.id.descricao);
        btEditar = findViewById(R.id.btnEditar);
        btExcluir = findViewById(R.id.btnExcluir);


        id.setText(String.valueOf(cliente.getId()));
        cpf.setText(cliente.getCpf());
        telefone.setText(cliente.getTelefone());
        nome.setText(cliente.getNome());
        email.setText(cliente.getEmail());
        descricao.setText(cliente.getDescricao());

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent excluir = new Intent(getApplicationContext(), Excluir.class);
                excluir.putExtra("objCliente", cliente);
                startActivity(excluir);
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