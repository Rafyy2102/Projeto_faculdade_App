package com.ems.bdsqlitefull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.ems.bdsqlitefull.crud.Insert;
import com.ems.bdsqlitefull.crud.ListAll;
import com.ems.bdsqlitefull.crud.Search;
public class MainActivity extends AppCompatActivity {

    // Declaração dos botões
    Button btInsert, btList, btSearch, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associa o botão de inserção e configura o evento do clique para abrir a tela de inclusão
        btInsert = findViewById(R.id.btMainInsert);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert = new Intent(getApplicationContext(), Insert.class);
                startActivity(insert);
            }
        });

        // Associa o botão e configura a ação para abre a tela de buscas
        btList = findViewById(R.id.btMainList);
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert = new Intent(getApplicationContext(), ListAll.class);
                startActivity(insert);
            }
        });

        // Associa o botão pesquisa a ação para abre a tela de pesquisa
        btSearch = findViewById(R.id.btMainSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert = new Intent(getApplicationContext(), Search.class);
                startActivity(insert);
            }
        });

        // Associa e configura o botão para sair da aplicação
        btExit = findViewById(R.id.btMainExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza a aplicação e remove da pilha
                finishAffinity();
            }
        });
    }
}
