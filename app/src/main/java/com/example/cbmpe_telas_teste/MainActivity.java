package com.example.cbmpe_telas_teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    // 1. Declare as variáveis para os componentes do layout
    // (Declare apenas os que você precisa interagir)
    private SwitchMaterial switchPrevencao;
    private SwitchMaterial switchComunitaria;
    private TextInputEditText etCod;
    private TextInputEditText etData;
    private TextInputEditText etNumAviso;
    private TextInputEditText etCondutor;
    private TextInputEditText etNomeResponsavel;
    private TextInputEditText etCpfResponsavel;
    private MaterialButton btnSalvarAtendimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. Conecte esta classe Java ao seu arquivo layout XML
        setContentView(R.layout.activity_main);

        // 3. Chame o método para inicializar e conectar as views
        initViews();
    }

    /**
     * Método para conectar as variáveis Java aos componentes do XML
     * usando findViewById.
     */
    private void initViews() {
        // Exemplo de como conectar alguns componentes:
        switchPrevencao = findViewById(R.id.switchPrevencao);
        etCod = findViewById(R.id.etCod);
        etData = findViewById(R.id.etData);
        etNumAviso = findViewById(R.id.etNumAviso);
        etCondutor = findViewById(R.id.etCondutor);
        etNomeResponsavel = findViewById(R.id.etNome);
        etCpfResponsavel = findViewById(R.id.etCPF);
        btnSalvarAtendimento = findViewById(R.id.btnSalvarAtendimento);

        // 4. Adicione lógica a um componente (ex: o botão Salvar)
        btnSalvarAtendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quando o botão for clicado, chame o método salvar
                salvarFormulario();
            }
        });
    }

    /**
     * Método de exemplo para quando o botão Salvar for clicado.
     */
    private void salvarFormulario() {
        // 5. Exemplo de como pegar dados dos campos
        boolean isPrevencao = switchPrevencao.isChecked();
        String cod = etCod.getText().toString();
        String data = etData.getText().toString();
        String condutor = etCondutor.getText().toString();

        // Lógica de salvamento (enviar para o banco de dados, API, etc.)
        // ...

        // Apenas exibe uma mensagem "Toast" para confirmar que funcionou
        String mensagem = "Formulário salvo! Cód: " + cod;
        Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_LONG).show();
    }
}
