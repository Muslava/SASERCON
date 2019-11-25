package com.hitomi.circlemenu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

    private CircleMenu circleMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            private Object Intent;

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), menu2.class);
                startActivity(i);
            }
        });

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.ic_action_name, R.mipmap.icon_cancel)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.bitacora_tecnico)
                .addSubMenu(Color.parseColor("#03A9F4"), R.mipmap.consulta_manuales)
                .addSubMenu(Color.parseColor("#FFEB3B"), R.mipmap.control_e_s)
                .addSubMenu(Color.parseColor("#FFC107"), R.mipmap.gestionar_productos)
                .addSubMenu(Color.parseColor("#76FF03"), R.mipmap.herramienta)
                .addSubMenu(Color.parseColor( "#FF5722"), R.mipmap.buscar_producto)


                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
            }

            @Override
            public void onMenuClosed() {
            }

        });

    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        circleMenu.openMenu();

        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onBackPressed() {
        circleMenu.closeMenu();






    }
    public void menu2(View view) {
        setContentView(R.layout.menu2);


    }}
