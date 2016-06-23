package com.cursosdedesarrollo.listviewwithappcompatactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TestListAdapter adapter;
    //private static String[] listItems = {"exploring", "android","list", "activities"};
    private static List<Chorbi> listado;

    private ListView lv;
    private View empty;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargaDatos();
        setContentView(R.layout.activity_main);
        empty=(View) findViewById(R.id.empty);
        lv=(ListView)findViewById(R.id.listado);
        adapter=new TestListAdapter(getApplicationContext(), listado);
        if(listado.size()>0){
            empty.setVisibility(View.GONE);
            lv.setAdapter(adapter);
        }else{
            lv.setVisibility(View.GONE);
            empty.setVisibility(View.VISIBLE);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.add(new Chorbi(0,"Choni random","666666666"));
                adapter.forceReload();
            }
        });

    }

    private void removeLastElement() {
        try{
            adapter.remove(adapter.getCount()-1);
            adapter.forceReload();

            Log.d("app", new Integer(adapter.getCount()).toString());
        }
        catch(Exception e){
            Log.d("miapp", "fallo al actualizar");
        }
    }

    private void cargaDatos() {
        listado=new ArrayList<Chorbi>();
        listado.add(new Chorbi(1,"Pepe","91234567"));
        listado.add(new Chorbi(2,"María","912345654"));
        listado.add(new Chorbi(3,"Adolfo","9187654"));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_remove) {
            Log.d("Boton Remove Last", "Pulsado");
            removeLastElement();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
