package com.ems.bdsqlitefull.crud;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.bdsqlitefull.MainActivity;
import com.ems.bdsqlitefull.R;
import com.ems.bdsqlitefull.pojo.Cliente;
import com.ems.bdsqlitefull.utils.Message;

public class EditRecord extends AppCompatActivity {

    TextView id;
    EditText cpf, telefone, nome, email, descricao;
    Button btSalvar;

    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Edição");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        cpf = findViewById(R.id.cpf);
        telefone = findViewById(R.id.telefone);
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        descricao = findViewById(R.id.descricao);
        btSalvar = findViewById(R.id.btSalvar);

        final Intent itCliente = getIntent();
        final Cliente cliente = (Cliente) itCliente.getExtras().getSerializable("objCliente");
        id.setText(String.valueOf(cliente.getId()));
        cpf.setText(cliente.getCpf());
        telefone.setText(cliente.getTelefone());
        nome.setText(cliente.getNome());
        email.setText(cliente.getEmail());
        descricao.setText(cliente.getDescricao());

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Coleta os dados digitados nos campos
                ContentValues values = new ContentValues();
                values.put("cpf", cpf.getText().toString());
                values.put("telefone", telefone.getText().toString());
                values.put("nome", nome.getText().toString());
                values.put("email", email.getText().toString());
                values.put("descricao", descricao.getText().toString());

                Cliente novosDados = new Cliente();
                novosDados.setCpf(cpf.getText().toString());
                novosDados.setTelefone(telefone.getText().toString());
                novosDados.setNome(nome.getText().toString());
                novosDados.setEmail(email.getText().toString());
                novosDados.setDescricao(descricao.getText().toString());

                // Atualiza os dados na tabela
                db = openOrCreateDatabase("db_cliente", Context.MODE_PRIVATE, null);
                db.execSQL("UPDATE cliente SET " +
                        "cpf='" + novosDados.getCpf() + "'," +
                        "telefone='" + novosDados.getTelefone() + "'," +
                        "nome='" + novosDados.getNome() + "'," +
                        "email='" + novosDados.getEmail() + "'," +
                        "descricao='" + novosDados.getDescricao() + "' " +
                        "WHERE id=" + cliente.getId()
                );

                // Cria uma caixa de mensagem e mostra os dados incluídos
                Message message = new Message(EditRecord.this);
                message.show(
                        "Dados Atualizados com Sucesso!",
                        novosDados.getDados(),
                        R.drawable.ic_add);
                ;
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
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