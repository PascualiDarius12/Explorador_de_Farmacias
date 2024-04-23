package com.moviles.explorador_de_farmacias.ui.salir;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SalirDialogo {

    public static void mostrarDialogo(Context context){
        new AlertDialog.Builder(context)
                .setTitle("Salir")
                .setMessage("Esta seguro que desea salir?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}
