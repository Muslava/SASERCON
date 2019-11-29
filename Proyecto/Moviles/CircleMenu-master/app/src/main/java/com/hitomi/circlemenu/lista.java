package com.hitomi.circlemenu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class lista extends AppCompatActivity {


    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        listView=(ListView)findViewById(R.id.list);

        final ArrayList<String> arrayList=new ArrayList<>();


        arrayList.add("servicio 1");
        arrayList.add("servicio 2");
        arrayList.add("servicio 3");
        arrayList.add("servicio 4");
        arrayList.add("servicio 5");
        arrayList.add("servicio 6");
        arrayList.add("servicio canísimo");
        arrayList.add("servicio 8");
        arrayList.add("servicio 9");
        arrayList.add("servicio 10");
        arrayList.add("servicio 11");
        arrayList.add("servicio 12");
        arrayList.add("servicio 13");
        arrayList.add("servicio 14");
        arrayList.add("servicio 15");
        arrayList.add("servicio 16");
        arrayList.add("servicio 17");
        arrayList.add("servicio 18");
        arrayList.add("servicio 19");
        arrayList.add("servicio 20");


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);
        {

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Click ListItem Number: " + arrayList.get(position), Toast.LENGTH_LONG).show();
                Intent a = new Intent(getApplicationContext(), MainActivity.class);
                a.putExtra("servicio",arrayList.get(position));
                startActivity(a);
            }
        });
    }
}