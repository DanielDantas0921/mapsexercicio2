package mineconstruc.com.exercicio2googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Local> lista;
    ArrayAdapter<Local> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        lista = new ArrayList<>();
        lista.add(new Local(
                "Mercado Lima", "Rua Coronel Barato" , -7.113246,-34.865489));
        lista.add(new Local(
                "Casa", "Rua Vicente Lucas Borges" , -7.109970,-34.866029));
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("latitude",lista.get(i).latitude);
                intent.putExtra("longitude",lista.get(i).longitude);
                intent.putExtra("titulo",lista.get(i).titulo);
                startActivity(intent);

            }
        });
    }
}