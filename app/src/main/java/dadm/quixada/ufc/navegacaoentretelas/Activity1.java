package dadm.quixada.ufc.navegacaoentretelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import dadm.quixada.ufc.navegacaoentretelas.adapter.DisciplinaAdapter;
import dadm.quixada.ufc.navegacaoentretelas.model.Disciplina;

public class Activity1 extends AppCompatActivity {

    EditText edtNome;
    EditText edtCodigoDisciplina;
    EditText edtLocalDisciplina;
    EditText edtHorarioDisciplina;
    EditText edtEditPorId;


    Button btnAdd;
    Button btnEdit;

    ArrayList<Disciplina> listaDisciplina;



    RecyclerView disciplinaRecyclerView;
    DisciplinaAdapter disciplinaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        listaDisciplina = new ArrayList<Disciplina>();

        edtNome= findViewById(R.id.edtNomeDisciplina);
        edtCodigoDisciplina = findViewById(R.id.edtCodDisciplina);
        edtLocalDisciplina = findViewById(R.id.edtLocalDisciplina);
        edtHorarioDisciplina = findViewById(R.id.edtHorarioDisciplina);

        disciplinaRecyclerView = findViewById(R.id.recyclerViewDisciplina);

        disciplinaAdapter = new DisciplinaAdapter(listaDisciplina);
    }
}