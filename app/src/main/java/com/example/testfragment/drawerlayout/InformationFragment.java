package com.example.testfragment.drawerlayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.testfragment.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InformationFragment extends Fragment {
    private  String  MainArgument_argument;
    private TextView Show_Argument_TextView;
    private Button Get_Argument_Button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.information_fragment_layout,container,false);

        Bundle bundle=getArguments();
        if(bundle!=null){
             MainArgument_argument=bundle.getString("TestArgument");
        }
        Show_Argument_TextView=view.findViewById(R.id.show_argument_textview);
        Get_Argument_Button=view.findViewById(R.id.get_argument_button);



        Get_Argument_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show_Argument_TextView.setText(MainArgument_argument);
            }
        });

        return  view;
    }


    public  InformationFragment getInstance(String MainActivity_Argument){
        Bundle bundle=new Bundle();
        bundle.putString("TestArgument",MainActivity_Argument);
        this.setArguments(bundle);
        return this;
    }


}
