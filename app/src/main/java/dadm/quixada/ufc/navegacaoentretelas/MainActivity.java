package dadm.quixada.ufc.navegacaoentretelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import dadm.quixada.ufc.navegacaoentretelas.adapter.DisciplinaAdapter;
import dadm.quixada.ufc.navegacaoentretelas.model.Disciplina;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_ADD = 11;
    public static int REQUEST_EDIT = 12;
    public static int RESULT_ADD = 21;
    public static int RESULT_CANCEL = 22;

    int disciplinaIdCount = 0;

    EditText edtNome;
    EditText edtCodigoDisciplina;
    EditText edtLocalDisciplina;
    EditText edtHorarioDisciplina;
    EditText edtIdEdicao;

    LinearLayout editLine;

    Button btnAdd;
    Button btnEdit;
    FloatingActionButton add;

    ArrayList<Disciplina> listaDisciplina;



    RecyclerView disciplinaRecyclerView;
    DisciplinaAdapter disciplinaAdapter;

    InputMethodManager imm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editLine = (LinearLayout) findViewById(R.id.linearLayoutEdit);

        listaDisciplina = new ArrayList<Disciplina>();

        edtIdEdicao = findViewById(R.id.edtIdEdit);

        disciplinaRecyclerView = findViewById(R.id.recyclerViewDisciplina);

        disciplinaAdapter = new DisciplinaAdapter(listaDisciplina);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        disciplinaRecyclerView.setLayoutManager(layoutManager);
        disciplinaRecyclerView.setAdapter(disciplinaAdapter);
        disciplinaRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        add = findViewById(R.id.float_btn_main);
        btnEdit = findViewById(R.id.btnEdit);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarDisciplina();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarParaEdicao();

            }
        });
    }

    public void adicionarDisciplina(){

        Intent intent = new Intent(this, Activity1.class);
        intent.putExtra("id",disciplinaIdCount);
        intent.putExtra("editar","false");
        startActivityForResult( intent, REQUEST_ADD );
    }

    public void enviarParaEdicao()
    {
        if(Integer.valueOf(edtIdEdicao.getText().toString()) > (listaDisciplina.size()-1)
                || Integer.valueOf(edtIdEdicao.getText().toString()) == null
                || edtIdEdicao.getText().toString() == "")
        {
            Toast.makeText( this,"Id invalido, tente novamente com outro valor",
                    Toast.LENGTH_SHORT).show();

            imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            if(imm.isActive())
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
        else
        {
            Intent intent = new Intent( this, Activity1.class );
            int selected = Integer.valueOf(edtIdEdicao.getText().toString());
            //Intent intent2 = new Intent( this, "br.ufc.quixada.dadm.variastelas.ContactActivity" );

            Disciplina disciplina = listaDisciplina.get( selected );

            intent.putExtra( "id", Integer.valueOf(edtIdEdicao.getText().toString()));
            intent.putExtra( "nome", disciplina.getNome() );
            intent.putExtra( "codigo", disciplina.getCodigo() );
            intent.putExtra( "horario", disciplina.getHorario());
            intent.putExtra( "local", disciplina.getLocal());
            intent.putExtra("editar","true");

            startActivityForResult( intent, REQUEST_EDIT );
            imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            if(imm.isActive())
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }


    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode,  Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == Activity1.REQUEST_EDIT && resultCode == Activity1.RESULT_ADD ){

            String nome = (String) data.getExtras().get("nome");
            String codigo = (String) data.getExtras().get("codigo");
            String local = (String) data.getExtras().get("local");
            String horario = (String) data.getExtras().get("horario");
            int idEditar =  (int)data.getExtras().get("id");

            for( Disciplina d: listaDisciplina ){

                if( d.getId() == idEditar ){
                    d.setNome( nome );
                    d.setLocal( local );
                    d.setCodigo( codigo );
                    d.setHorario( horario );
                }
            }

            disciplinaAdapter.notifyDataSetChanged();

        }
        else if( requestCode == REQUEST_ADD && resultCode == RESULT_ADD ) {

            String nome = (String) data.getExtras().get("nome");
            String codigo = (String) data.getExtras().get("codigo");
            String local = (String) data.getExtras().get("local");
            String horario = (String) data.getExtras().get("horario");

            Disciplina d = new Disciplina(nome, codigo, local, horario);
            d.setId(disciplinaIdCount);
            disciplinaIdCount += 1;

            System.out.println(d.getNome());

            listaDisciplina.add(d);
            System.out.println(listaDisciplina);
            disciplinaAdapter.notifyDataSetChanged();

            editLine.setVisibility(View.VISIBLE);

        }
        else if( resultCode == RESULT_CANCEL ){
            Toast.makeText( this,"Cancelado",
                    Toast.LENGTH_SHORT).show();
        }

    }



}