package com.hitomi.circlemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

public class Bitacora extends Activity implements
        View.OnClickListener, AdapterView.OnItemSelectedListener {
    //Declaramos los elementos de la interfaz
    private Button btnCrear;
    private Button btnVer;
    private Button btnEliminar;
    private EditText editComentario;
    private EditText txtComentario;

    //Declaración del spinner y su Adapter
    //private Spinner spinComentarios;
    //private ArrayAdapter spinnerAdapter;

    //Lista de comentarios y comentario actual
    //private ArrayList<Comentario> lista;
    private Comentario c;

    //Controlador de bases de datos
    private MyOpenHelper db;

    private String nombreServicio = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitacora);

        nombreServicio = getIntent().getStringExtra("servicio");

        //Inicializamos los elementos de la interfaz
        //editNombre=(EditText) findViewById(R.id.editNombre);
        editComentario=(EditText)findViewById(R.id.editComentario);
        //txtNombre=(EditText) findViewById(R.id.txtNombre);
        //txtComentario=(EditText)findViewById(R.id.txtComentario);

        //Los elementos del panel inferior no seran editables
        //txtNombre.setEnabled(false);
        //txtComentario.setEnabled(false);
        btnCrear=(Button)findViewById(R.id.btnCrear);
        //btnVer=(Button)findViewById(R.id.btnVer);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnCrear.setOnClickListener(this);
//        btnVer.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

        //Iniciamos el controlador de la base de datos
        db=new MyOpenHelper(this);

        //Iniciamos el spinner y la lista de comentarios
        //spinComentarios=(Spinner) findViewById(R.id.spinComentarios);
        //lista=db.getComments();

        //Creamos el adapter y lo asociamos al spinner
        //spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
        //spinComentarios.setAdapter(spinnerAdapter);
        //spinComentarios.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        //Acciones de cada boton
        switch(v.getId()){
            case R.id.btnCrear:
                //Insertamos un nuevo elemento en base de datos
                db.insertar(nombreServicio,editComentario.getText().toString(
                ));

                //Actualizamos la lista de comentarios
                //lista=db.getComments();

                //Actualizamos el adapter y lo asociamos de nuevo al spinner
                //spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
                //spinComentarios.setAdapter(spinnerAdapter);

                //Limpiamos el formulario
                //editNombre.setText("");
                editComentario.setText("");
                break;

            // case R.id.btnVer:
            //Si hay algun comentario seleccionado mostramos sus valores en la parte inferior
            //   if(c!=null) {
            //txtNombre.setText(c.getNombre());

            //     txtComentario.setText(c.getComentario());
            //}
            //break;

            case R.id.btnEliminar:
                //Si hay algun comentario seleccionado lo borramos de la base de datos y actualizamos el spinner
                if(c!=null) {
                    db.borrar(c.getId());
                    //lista = db.getComments();
                    //spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, lista);
                    //spinComentarios.setAdapter(spinnerAdapter);

                    //Limpiamos los datos del panel inferior
                    //txtNombre.setText("");
                    txtComentario.setText("");

                    //Eliminamos el Comentario actual puesto que ya no existe en base de datos
                    c=null;
                }
                break;
        }
    }

    //Controlador de elemento seleccionado en el spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*if (parent.getId() == R.id.spinComentarios) {
            //Si hay elementos en la base de datos, establecemos el comentario actual a partir del
            //indice del elemento seleccionado en el spinner
            if(lista.size()>0) {
                c = lista.get(position);
            }
        }*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}