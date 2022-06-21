package com.example.androidlearning.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.androidlearning.R;
import androidx.annotation.Nullable;

public class AFragment extends Fragment {

    private TextView TvTitle;
    private Button btnchange,btnreset, btnMessage;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;

        }catch(ClassCastException e){
            throw new ClassCastException("Activity must implement the interface");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_a, container, false);
        Log.i("AFragment","Oncreateview");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TvTitle = view.findViewById(R.id.tv_title);

        btnchange = view.findViewById(R.id.btn_change);
        btnreset = view.findViewById(R.id.btn_reset);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bFragment==null)
                    bFragment = new BFragment();
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null)
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                else
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    TvTitle.setText("I am new text");
            }
        });

        if (getArguments() != null) {

            TvTitle.setText(getArguments().getString("title"));

        }


        btnMessage = view.findViewById(R.id.btn_message);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((ContainerActivity)getActivity()).setData("Yo");
                listener.onClick("Hey Hey Boy");
            }
        });
    }


}
