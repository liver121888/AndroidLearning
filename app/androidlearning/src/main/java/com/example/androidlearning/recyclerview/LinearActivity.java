package com.example.androidlearning.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidlearning.R;

public class LinearActivity extends AppCompatActivity {


    private RecyclerView RvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        RvMain = findViewById(R.id.rv_main);
        RvMain.setLayoutManager(new LinearLayoutManager(LinearActivity.this));
        RvMain.addItemDecoration(new MyDecoration());
        RvMain.setAdapter(new LinearAdapter(LinearActivity.this, new LinearAdapter.OnItemClickListener() {

            @Override
            public void OnClick(int pos) {
                Toast.makeText(LinearActivity.this, "click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }


    class MyDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}