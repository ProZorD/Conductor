package br.com.cardtracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Compra extends AppCompatActivity implements View.OnClickListener {

    // Data of user
    private EditText nCVV;
    private EditText nID;
    private EditText nNome;
    private EditText nNumero;
    private EditText nSenha;
    private EditText nLimite;

    // Buttons
    private Button nConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        nCVV = (EditText) findViewById(R.id.nCVV);
        nID = (EditText) findViewById(R.id.nID);
        nNome = (EditText) findViewById(R.id.nName);
        nNumero = (EditText) findViewById(R.id.nNumero);
        nSenha = (EditText) findViewById(R.id.nSenha);
        nLimite = (EditText) findViewById(R.id.nLimite);

        nConfirmacao = (Button) findViewById(R.id.nConfirmacao);
        nConfirmacao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dig = new AlertDialog.Builder(Compra.this);
        Intent it = new Intent(this, Menu.class);
        dig.setMessage("Acesse a aba de confirmação para validar a compra");
        dig.show();
        startActivity(it);
    }
}
