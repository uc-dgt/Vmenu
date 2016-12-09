package com.voidream.upnormalvmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.kategori);
        ListView daftar_kategori = (ListView)findViewById(R.id.daftar_kategori);
        KategoriCustomAdapter kategori = new KategoriCustomAdapter(MainActivity.this);
        daftar_kategori.setAdapter(kategori);

        daftar_kategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent intent_pencarian= new Intent(MainActivity.this, Pencarian.class);
                startActivity(intent_pencarian);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.right_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.pencarian) {
            Intent intent_pencarian= new Intent(MainActivity.this, Pencarian.class);
            startActivity(intent_pencarian);
            return true;
        }
        if (id == R.id.pesanan) {
            Intent intent_pesanan= new Intent(MainActivity.this, DaftarPesanan.class);
            startActivity(intent_pesanan);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
