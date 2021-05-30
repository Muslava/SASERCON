package com.hitomi.circlemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Bitacora extends Activity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    //Declaramos los elementos de la interfaz
    private Button btnCrear;
    //private Button btnVer;
    private Button btnEliminar;
    //private EditText editNombre;
    private EditText editComentario;
    //private EditText txtNombre;
    //private EditText txtComentario;

    //Declaración del spinner y su Adapter
    private Spinner spinComentarios;
    private ArrayAdapter spinnerAdapter;

    //Lista de comentarios y Comentario actual
    private ArrayList<com.hitomi.circlemenu.Comentario> lista;
    private com.hitomi.circlemenu.Comentario c;

    //Controlador de bases de datos
    private MyOpenHelper db;

    //Datos obtenidos de la clase invocadora
    private String servicio;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitacora);

        //Inicializamos los elementos de la interfaz
        //editNombre=(EditText) findViewById(R.id.editNombre);
        editComentario=(EditText)findViewById(R.id.editComentario);
        //txtNombre=(EditText) findViewById(R.id.txtNombre);
        //txtComentario=(EditText)findViewById(R.id.txtComentario);

        //Los elementos del panel inferior no seran editables
        //txtNombre.setEnabled(false);
        //txtComentario.setEnabled(false);

        btnCrear=(Button)findViewById(R.id.btnGuardar);
        //btnVer=(Button)findViewById(R.id.btnVer);
        btnEliminar=(Button)findViewById(R.id.btnLimpiar);

        btnCrear.setOnClickListener(this);
        //btnVer.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

        //Iniciamos el controlador de la base de datos
        db=new MyOpenHelper(this);

        //Iniciamos el spinner y la lista de comentarios
        //spinComentarios=(Spinner) findViewById(R.id.spinComentarios);
        lista=db.getComments();

        //Creamos el adapter y lo asociamos al spinner
        //spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
        //spinComentarios.setAdapter(spinnerAdapter);
        //spinComentarios.setOnItemSelectedListener(this);

        servicio = getIntent().getStringExtra("servicio");
        //posicion = getIntent().getIntExtra("posicion");

//        c = lista.get(posicion);

//        editComentario.setText(c.getComentario());

    }

    @Override
    public void onClick(View v) {
        //Acciones de cada boton
        switch(v.getId())   {
            case R.id.btnGuardar:

                //Insertamos un nuevo elemento en base de datos
                db.insertar(posicion,servicio,editComentario.getText().toString());
                //Actualizamos la lista de comentarios
                lista=db.getComments();
                //Actualizamos el adapter y lo asociamos de nuevo al spinner
                //spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
                //spinComentarios.setAdapter(spinnerAdapter);
                //Limpiamos el formulario
                //editNombre.setText("");
                //editComentario.setText("");
                break;

            /*case R.id.btnVer:

                //Si hay algun Comentario seleccionado mostramos sus valores en la parte inferior
                if(c!=null) {
                    txtNombre.setText(c.getNombre());
                    txtComentario.setText(c.getComentario());
                }
                break;*/

            case R.id.btnLimpiar:
                //Si hay algun Comentario seleccionado lo borramos de la base de datos y actualizamos el spinner

                editComentario.setText("");
                /*if(c!=null) {
                    //db.borrar(c.getId());
                    //lista = db.getComments();
                    //spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
                    //spinComentarios.setAdapter(spinnerAdapter);

                    //Limpiamos los datos del panel inferior
                    //txtNombre.setText("");
                    editComentario.setText("");

                    //Eliminamos el Comentario actual puesto que ya no existe en base de datos
                    //c=null;
                }*/
                break;
        }
    }

    //Controlador de elemento seleccionado en el spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*if (parent.getId() == R.id.spinComentarios) {
            //Si hay elementos en la base de datos, establecemos el Comentario actual a partir del
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
