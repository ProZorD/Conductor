package br.com.cardtracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.conductor.sdc.api.v1.model.Conta;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText password;
    private Button btnEntrar;
    private EditText nConta;
    private EditText nID;
    public int senha = 40028922;

    // Atributos API
    public runAPI runAPI = new runAPI();
    public Conta conta1 = runAPI.getConta1Infos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        } //Thread não dar conflito

        password = (EditText) findViewById(R.id.password);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        nConta = (EditText) findViewById(R.id.nConta);
        nID = (EditText) findViewById(R.id.nID);

        btnEntrar.setOnClickListener(this);

        nConta.setText(conta1.getNome());
        nID.setText(conta1.getId().toString());
    }

    @Override
    public void onClick(View v){

        AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
        System.out.println("SENHA: " + senha);
        System.out.println("PASSWORD: " + password.getText());
        System.out.println("Conta 1: "+conta1);
        try {
            final int nIntFromText = new Integer(password.getText().toString()).intValue();
            if (senha == nIntFromText) {
                Intent it = new Intent(this, Menu.class);
                dig.setMessage("Entrando...");
                dig.show();
                startActivity(it);
            } else {
                dig.setMessage("Por favor, preencha os campos corretamente");
                dig.setNegativeButton("Voltar", null);
                dig.show();
                password.setText(null);
            }
        }catch (NumberFormatException ene){
            dig.setMessage("Digite a senha");
            dig.setNegativeButton("Ok",null);
            dig.show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}

