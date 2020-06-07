package com.ems.bdsqlitefull.utils;

import android.app.AlertDialog;
import android.content.Context;

public class Message {
    private Context _context;

    // Construtor
    public Message(Context context) {
        this._context = context;
    }

    // Mostra a mensagem
    public void show(String titulo, final String texto, int icone) {
        AlertDialog.Builder msg = new AlertDialog.Builder(_context);
        msg.setIcon(icone);
        msg.setTitle(titulo);
        msg.setMessage(texto);
        msg.setPositiveButton("OK", null);

        msg.show();

    }
}
