package com.m77834.pdm;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import model.matriculaModel;

public class MainActivityRevisao extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button tiraFoto;
    EditText matriculaView;
    EditText nomeView;
    EditText emailView;
    Spinner cidadeSelector_;
    Spinner estadoSelector_;
    ImageView foto_;
    ListView lista;

    List<matriculaModel> listaMatricula = new ArrayList<>();


    String[] cidades2 = {"Florianopolis","Garopaba","Praia do Rosa"};
    String[] cidades1 = {"SP","SANTOS","OSASCO"};
    String[] cidades = {"SCS", "POA", "Gramado"};
    String[] estados = {"RS", "SC", "SP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_revisao);

        matriculaView = findViewById(R.id.matriculaText);
        nomeView = findViewById(R.id.nomeText);
        emailView = findViewById(R.id.emailText);
        cidadeSelector_ = findViewById(R.id.cidadeSelector_);
        estadoSelector_ = findViewById(R.id.estadoSelector_);
        foto_ = findViewById(R.id.imagem);
        tiraFoto = findViewById(R.id.tiraFoto);
        cidadeSelector_ =  findViewById(R.id.cidadeSelector_);
        lista = findViewById(R.id.minhaLista);

        estadoSelector_ = findViewById(R.id.estadoSelector_);
        ArrayAdapter<String> arraySpinner = new ArrayAdapter<String>(this, R.layout.advanced_spinner_item, estados);
        estadoSelector_.setAdapter(arraySpinner);

        estadoSelector_.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object selected = adapterView.getSelectedItem();
                switch (selected.toString()){
                    case "RS":
                        ArrayAdapter<String> arrayList = new ArrayAdapter<String>(MainActivityRevisao.this, android.R.layout.simple_list_item_1, cidades);
                        cidadeSelector_.setAdapter(arrayList);
                        break;
                    case "SP":
                        ArrayAdapter<String> arrayList1 = new ArrayAdapter<String>(MainActivityRevisao.this, android.R.layout.simple_list_item_1, cidades1);
                        cidadeSelector_.setAdapter(arrayList1);
                        break;
                    case "SC":
                        ArrayAdapter<String> arrayList2 = new ArrayAdapter<String>(MainActivityRevisao.this, android.R.layout.simple_list_item_1, cidades2);
                        cidadeSelector_.setAdapter(arrayList2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    public void tiraFoto(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        onActivityResult(1, 1, takePictureIntent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto_.setImageBitmap(imageBitmap);
        }
    }

    public void addMatricula(View view){
        String matriculaString = matriculaView.getText().toString();

        String nomeString = nomeView.getText().toString();

        String emailString = emailView.getText().toString();

        Object estadoSelecionado = estadoSelector_.getSelectedItem();

        String estadoString = estadoSelecionado.toString();

        Object cidadeSelecionado = cidadeSelector_.getSelectedItem();

        String cidadeString = estadoSelecionado.toString();


        matriculaModel model = new matriculaModel(matriculaString, nomeString, emailString, estadoString, cidadeString);

        listaMatricula.add(model);

        MatriculaListActivity newl = new MatriculaListActivity();



    }

    public class MatriculaListActivity extends ListActivity implements AdapterView.OnItemClickListener{
        String[] de = {"imagem", "matricula", "nome"};
        int[] para = {R.id.imagemMatricula, R.id.matriculaMatricula, R.id.nomeMatricula};

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            SimpleAdapter adapter = new SimpleAdapter(this, dadosMatricula(listaMatricula), R.layout.layoutrevisao, de, para);
            setListAdapter(adapter);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    }

    private List<HashMap<String, Object>> dadosMatricula(List<matriculaModel> lista){


        List<HashMap<String, Object>> dados = new ArrayList<>();
        HashMap<String, Object> itens;
        for(int i = 0; i < lista.size(); i++){
            itens = new HashMap<String, Object>();
            itens.put("imagem", null);
            matriculaModel m = lista.get(i);
            itens.put("matricula", m.matricula);
            itens.put("nome", m.nome);
dados.add(itens);
        }
        return  dados;
    }



}



