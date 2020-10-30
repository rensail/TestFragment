package com.example.testfragment.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testfragment.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RegisterFragment extends Fragment {

    private Button Complete_Button;
    private EditText Register_User_EditText;
    private EditText Register_PassWord_EditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.register_fragment_layout,container,false);

        Complete_Button=view.findViewById(R.id.complete_button);
        Register_User_EditText=view.findViewById(R.id.register_user_edittext);
        Register_PassWord_EditText=view.findViewById(R.id.register_password_edittext);

        Complete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=Register_User_EditText.getText().toString();
                String password=Register_PassWord_EditText.getText().toString();
                LoginFragment loginFragment=new LoginFragment();

                //带着Register的参数打开LoginFragment
                replaceFragment(loginFragment.getInstance(user,password));

            }
        });

        return  view;
    }


    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_fragment,fragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }
}
