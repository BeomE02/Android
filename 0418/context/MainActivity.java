package com.example.context;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.backgroundLayout);

        registerForContextMenu(layout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_red) {
            layout.setBackgroundColor(Color.RED);
            return true;
        } else if (id == R.id.menu_green) {
            layout.setBackgroundColor(Color.GREEN);
            return true;
        } else if (id == R.id.menu_blue) {
            layout.setBackgroundColor(Color.BLUE);
            return true;
        }

        return super.onContextItemSelected(item);
    }
}
