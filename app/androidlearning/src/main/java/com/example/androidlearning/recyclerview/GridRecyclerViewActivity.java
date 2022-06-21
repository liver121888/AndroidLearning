package com.example.androidlearning.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidlearning.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView RvGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        RvGrid = findViewById(R.id.rv_grid);
        RvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));
        RvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));


    }
}