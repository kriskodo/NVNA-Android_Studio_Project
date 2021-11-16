package com.example.kristianapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class McDonaldsMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcdonalds);

        registerForContextMenu(findViewById(R.id.mcdonalds_image_bigmac));
        registerForContextMenu(findViewById(R.id.mcdonalds_image_chicken));
        registerForContextMenu(findViewById(R.id.mcdonalds_image_fish));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mcdonalds_context_menu_add_to_favorites:
                Toast.makeText(getApplicationContext(), "Добавено в любими", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mcdonalds_context_menu_add_to_purchase:
                Toast.makeText(getApplicationContext(), "Добавено в количката", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_like:
                Toast.makeText(getApplicationContext(), "Liked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_information:
                Toast.makeText(getApplicationContext(), "Information", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_purchase_history:
                Toast.makeText(getApplicationContext(), "Purchase History", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
