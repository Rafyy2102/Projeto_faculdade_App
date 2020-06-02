package com.ems.bdsqlitefull.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.bdsqlitefull.pojo.Cliente;
import com.ems.bdsqlitefull.R;
import com.ems.bdsqlitefull.utils.Message;

public class Insert extends AppCompatActivity {
    EditText cpf, telefone, nome, email, descricao;
    Button btInserir;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // Abertura ou criação do Banco de Dados
        db = openOrCreateDatabase("db_cliente", Context.MODE_PRIVATE, null);

        // Cria a tabela se não existir, senão carrega a tabela para uso
        db.execSQL("CREATE TABLE IF NOT EXISTS cliente(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cpf VARCHAR NOT NULL," +
                "telefone VARCHAR NOT NULL, " +
                "nome VARCHAR NOT NULL, " +
                "email VARCHAR NOT NULL, " +
                "descricao VARCHAR NOT NULL);");

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Inserir");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        cpf = findViewById(R.id.editCPF);
        telefone = findViewById(R.id.editTelefone);
        nome = findViewById(R.id.editNome);
        email = findViewById(R.id.editEmail);
        descricao = findViewById(R.id.editDescricao);
        btInserir = findViewById(R.id.btInserir);

        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria um objeto Cliente para receber os dados
                Cliente cliente = new Cliente();
                cliente.setCpf(cpf.getText().toString());
                cliente.setTelefone(telefone.getText().toString());
                cliente.setNome(nome.getText().toString());
                cliente.setEmail(email.getText().toString());
                cliente.setDescricao(descricao.getText().toString());

                // Coleta os dados digitados nos campos
                ContentValues values = new ContentValues();
                values.put("cpf", cliente.getCpf());
                values.put("telefone", cliente.getTelefone());
                values.put("nome", cliente.getNome());
                values.put("email", cliente.getEmail());
                values.put("descricao", cliente.getDescricao());

                // Insere os dados na tabela
                db.insert("cliente", null, values);

                // Cria uma caixa de mensagem e mostra os dados incluídos
                Message message = new Message(Insert.this);
                message.show(
                        "Dados incluídos com sucesso!",
                        cliente.getDados(),
                        R.drawable.ic_add);

                // Limpa os campos de entrada
                clearText();
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

    /**
     * Limpa os campos de entrada e fecha o teclado
     */
    public void clearText() {
        cpf.setText("");
        telefone.setText("");
        nome.setText("");
        email.setText("");
        descricao.setText("");
        telefone.requestFocus();

        // fecha o teclado virtual
        ((InputMethodManager) Insert.this.getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                getCurrentFocus().getWindowToken(), 0);
    }
}
