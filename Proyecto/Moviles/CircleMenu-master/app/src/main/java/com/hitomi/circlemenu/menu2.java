package com.hitomi.circlemenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.Menu;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class menu2 extends AppCompatActivity {


    private CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        circleMenu = (CircleMenu) findViewById(R.id.circleMenu1);


        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.ic_action_name, R.mipmap.icon_cancel)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.control_tecnicos)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.gestionar_productos)


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

}



