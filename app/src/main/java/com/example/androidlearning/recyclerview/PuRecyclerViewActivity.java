package com.example.androidlearning.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidlearning.R;

public class PuRecyclerViewActivity extends AppCompatActivity {


    private RecyclerView RvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);

        RvPu = findViewById(R.id.rv_pu);
        RvPu.addItemDecoration(new PuRecyclerViewActivity.decoration());
        RvPu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        RvPu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this, "click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class decoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelSize(R.dimen.dividerHeight2);
            outRect.set(gap,gap,gap,gap);
        }
    }

}