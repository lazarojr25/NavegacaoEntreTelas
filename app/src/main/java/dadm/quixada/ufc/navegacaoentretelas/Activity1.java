package dadm.quixada.ufc.navegacaoentretelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;

import dadm.quixada.ufc.navegacaoentretelas.adapter.DisciplinaAdapter;
import dadm.quixada.ufc.navegacaoentretelas.model.Disciplina;

public class Activity1 extends AppCompatActivity {

    public static int REQUEST_ADD = 11;
    public static int REQUEST_EDIT = 12;
    public static int RESULT_ADD = 21;
    public static int RESULT_CANCEL = 22;

    private EditText nomeDisciplina,codigoDisciplina, localDisciplina,horarioDisciplina;

    private TextView textViewId;

    private Button editBtn, cancelBtn;

    InputMethodManager imm;

    int disciplinaId;
    boolean edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        nomeDisciplina = findViewById(R.id.edtNomeDisciplinaEdit);
        codigoDisciplina = findViewById(R.id.edtCodDisciplinaEdit);
        localDisciplina = findViewById(R.id.edtLocalDisciplinaEdit);
        horarioDisciplina = findViewById(R.id.edtHorarioDisciplinaEdit);

        editBtn = findViewById(R.id.btnEditar);
        cancelBtn = findViewById(R.id.btnCanelarEdicao);

        textViewId = findViewById(R.id.txtvIdDisciplinaValue);

        edit = Boolean.valueOf(getIntent().getExtras().get("editar").toString());

        textViewId.setText(getIntent().getExtras().get("id").toString());
        if(getIntent().getExtras() != null && edit)
        {
            String nome = (String) getIntent().getExtras().get("nome");
            String codigo = (String) getIntent().getExtras().get("codigo");
            String local = (String) getIntent().getExtras().get("local");
            String horario = (String) getIntent().getExtras().get("horario");
            disciplinaId = (int)getIntent().getExtras().get("id");

            nomeDisciplina.setText(nome);
            codigoDisciplina.setText(codigo);
            localDisciplina.setText(local);
            horarioDisciplina.setText(horario);

            edit = true;
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarDisciplina();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelar();
            }
        });
    }

    public void adicionarDisciplina(){
        String nome = nomeDisciplina.getText().toString();
        String codigo = codigoDisciplina.getText().toString();
        String local = localDisciplina.getText().toString();
        String horario = horarioDisciplina.getText().toString();

        Intent intent = new Intent();

        intent.putExtra("nome",nome);
        intent.putExtra("codigo",codigo);
        intent.putExtra("local",local);
        intent.putExtra("horario",horario);
        intent.putExtra("id",disciplinaId);


        setResult( RESULT_ADD, intent );
        finish();


        imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        if(imm.isActive())
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public void cancelar( ){
        setResult(RESULT_CANCEL );
        imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        if(imm.isActive())
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        finish();
    }


    private void editarDisciplina() {

        Intent intent = new Intent();

        String nome = nomeDisciplina.getText().toString();
        String codigo = codigoDisciplina.getText().toString();
        String local = localDisciplina.getText().toString();
        String horario = horarioDisciplina.getText().toString();

        intent.putExtra("nome",nome);
        intent.putExtra("codigo",codigo);
        intent.putExtra("local",local);
        intent.putExtra("horario",horario);
        intent.putExtra("id",disciplinaId);

        setResult(RESULT_ADD,intent);
        imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        if(imm.isActive())
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        finish();


    }


}