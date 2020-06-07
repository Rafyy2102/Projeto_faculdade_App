package com.ems.bdsqlitefull;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            //Exibindo a tela de splash
            @Override
            public void run() {
                //Esse metodo será executado para a tela de splash e inicializando a tela de MainActivity
                //chamar indica a tela que esta e qual vai ser chamada.
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                //encerrando a tela splash
                finish();
            }
            //os minutos da tela de splash
        }, 2000);

    }
}
