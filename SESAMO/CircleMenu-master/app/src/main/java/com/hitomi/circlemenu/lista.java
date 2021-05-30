package com.hitomi.circlemenu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class lista extends AppCompatActivity {


    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        listView=(ListView)findViewById(R.id.list);

        final ArrayList<String> arrayList=new ArrayList<>();


        arrayList.add("Reparacion de banda Delta");
        arrayList.add("Cambio de botonera 222");
        arrayList.add("Mantenimiento preventivo general");
        arrayList.add("Revision general Madero");
        arrayList.add("Testeo de asensor Oasis");
        arrayList.add("Reparacion de botonera digital");
        arrayList.add("Cierre de servicio");


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Click ListItem Number: " + arrayList.get(position), Toast.LENGTH_LONG).show();
                Intent a = new Intent(getApplicationContext(), Bitacora.class);
                a.putExtra("servicio",arrayList.get(position));
                //a.putExtra("posicion",position);
                startActivity(a);
            }
        });
    }
}