package com.example.cbmpe_telas_teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

// 1. O nome da classe deve ser FormPrevencaoActivity
public class FormPrevencaoActivity extends AppCompatActivity {

    // 2. Variável para controlar a etapa atual
    private int currentStep = 1;

    // 3. Referências para os Layouts das etapas
    private LinearLayout layoutStep1, layoutStep2, layoutStep3;
    private ScrollView scrollView;

    // 4. Referências para os botões de navegação
    private MaterialButton btnVoltar, btnProximo, btnSalvar;

    // 5. Referências para TODOS os campos do formulário
    private SwitchMaterial switchPrevencao, switchComunitaria, switchRegularizado;
    private TextInputEditText etCod, etData, etNumAviso, etHoraChegadaHH, etHoraChegadaMM,
            etChegada, etSaida, etSecao, etTipoVtr, etNumVtr, etCondutor,
            etNome, etCPF, etOS, etArAvcb, etPublicoEstimado, etAreaEstimada, etCodClassificacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 6. DEVE carregar o layout correto (o que está no Canvas)
        setContentView(R.layout.activity_form_prevencao);

        // 7. Chame o método para inicializar e conectar as views
        initViews();
        // 8. Chame o método para definir o estado inicial da UI (Etapa 1)
        updateStepVisibility();
    }

    /**
     * Método para conectar as variáveis Java aos componentes do XML
     */
    private void initViews() {
        // Conecta os layouts das Etapas
        layoutStep1 = findViewById(R.id.layoutStep1);
        layoutStep2 = findViewById(R.id.layoutStep2);
        layoutStep3 = findViewById(R.id.layoutStep3);
        scrollView = findViewById(R.id.scroll);

        // Conecta os botões de navegação
        btnVoltar = findViewById(R.id.btnVoltar);
        btnProximo = findViewById(R.id.btnProximo);
        btnSalvar = findViewById(R.id.btnSalvar);

        // Conecta TODOS os seus campos de formulário
        switchPrevencao = findViewById(R.id.switchPrevencao);
        switchComunitaria = findViewById(R.id.switchComunitaria);
        switchRegularizado = findViewById(R.id.switchRegularizado);
        etCod = findViewById(R.id.etCod);
        etData = findViewById(R.id.etData);
        etNumAviso = findViewById(R.id.etNumAviso);
        etHoraChegadaHH = findViewById(R.id.etHoraChegadaHH);
        etHoraChegadaMM = findViewById(R.id.etHoraChegadaMM);
        etChegada = findViewById(R.id.etChegada);
        etSaida = findViewById(R.id.etSaida);
        etSecao = findViewById(R.id.etSecao);
        etTipoVtr = findViewById(R.id.etTipoVtr);
        etNumVtr = findViewById(R.id.etNumVtr);
        etCondutor = findViewById(R.id.etCondutor);
        etNome = findViewById(R.id.etNome);
        etCPF = findViewById(R.id.etCPF);
        etOS = findViewById(R.id.etOS);
        etArAvcb = findViewById(R.id.etArAvcb);
        etPublicoEstimado = findViewById(R.id.etPublicoEstimado);
        etAreaEstimada = findViewById(R.id.etAreaEstimada);
        etCodClassificacao = findViewById(R.id.etCodClassificacao);


        // --- LÓGICA DOS BOTÕES DE NAVEGAÇÃO ---

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // (Aqui você pode adicionar validação antes de avançar)
                // ex: if (validarEtapa1()) { ... }

                if (currentStep < 3) {
                    currentStep++;
                    updateStepVisibility();
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentStep > 1) {
                    currentStep--;
                    updateStepVisibility();
                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // (Aqui você pode adicionar validação da etapa 3)
                salvarFormulario();
            }
        });
    }

    /**
     * Controla a visibilidade das etapas e botões
     */
    private void updateStepVisibility() {
        // Foca o ScrollView no topo
        scrollView.fullScroll(ScrollView.FOCUS_UP);

        // Mostra/Oculta os botões
        btnVoltar.setVisibility(currentStep == 1 ? View.GONE : View.VISIBLE);
        btnProximo.setVisibility(currentStep == 3 ? View.GONE : View.VISIBLE);
        btnSalvar.setVisibility(currentStep == 3 ? View.VISIBLE : View.GONE);

        // Mostra/Oculta os layouts das etapas
        layoutStep1.setVisibility(currentStep == 1 ? View.VISIBLE : View.GONE);
        layoutStep2.setVisibility(currentStep == 2 ? View.VISIBLE : View.GONE);
        layoutStep3.setVisibility(currentStep == 3 ? View.VISIBLE : View.GONE);
    }


    /**
     * Método para quando o botão Salvar for clicado (na Etapa 3).
     */
    private void salvarFormulario() {
        // 5. Exemplo de como pegar dados de TODOS os campos
        boolean isPrevencao = switchPrevencao.isChecked();
        String cod = etCod.getText().toString();
        String data = etData.getText().toString();
        String condutor = etCondutor.getText().toString();
        String nomeResponsavel = etNome.getText().toString();
        // ... pegue todos os outros campos

        // Lógica de salvamento (enviar para o banco de dados, API, etc.)
        // (Aqui é onde você chamaria o ViewModel do Room)
        // mAtendimentoViewModel.insert(novoAtendimento);

        // Apenas exibe uma mensagem "Toast" para confirmar que funcionou
        String mensagem = "Formulário salvo! Responsável: " + nomeResponsavel;
        Toast.makeText(FormPrevencaoActivity.this, mensagem, Toast.LENGTH_LONG).show();

        // Opcional: fechar a tela após salvar
        // finish();
    }
}

