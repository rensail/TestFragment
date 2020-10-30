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

public class LoginFragment extends Fragment {
    private Button Login_Button;
    private Button To_Register_Button;
    private EditText Login_User_EditText;
    private EditText Login_PassWord_EditText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login_fragment_layout,container,false);
        To_Register_Button=view.findViewById(R.id.to_register_button);
        Login_User_EditText=view.findViewById(R.id.login_user_edittext);
        Login_PassWord_EditText=view.findViewById(R.id.login_password_edittext);


        Bundle bundle=getArguments();
        if(bundle!=null){
            String user=bundle.getString("USER");
            String password=bundle.getString("PASSWORD");
            Login_User_EditText.setText(user);
            Login_PassWord_EditText.setText(password);
        }

        To_Register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RegisterFragment());
            }
        });
        return  view;
    }

    public LoginFragment getInstance(String user,String password){
        Bundle bundle=new Bundle();
        bundle.putString("USER",user);
        bundle.putString("PASSWORD",password);
        this.setArguments(bundle);
        return  this;
    }

    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_fragment,fragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }
}
