package com.example.test_mku_app.Views;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.test_mku_app.R;
import com.google.android.material.button.MaterialButton;

public class MainFragment extends Fragment {

    private ImageView buttonQuizModule1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        buttonQuizModule1 = view.findViewById(R.id.buttonQuizModule1);

        buttonQuizModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.mainfragment, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}