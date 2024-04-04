package com.example.test_mku_app.Views;

import static android.content.ContentValues.TAG;

import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_mku_app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class MainFragment extends Fragment {

    private ShapeableImageView QuizModule1;
//    private ShapeableImageView imageAvtMainFragment;
//    private TextView txtAppname;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private String userID = "";
    private static final String TAG = "MainFragment";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        QuizModule1 = view.findViewById(R.id.QuizModule1);
       // imageAvtMainFragment = view.findViewById(R.id.imageAvtMainFragment);


//        user = FirebaseAuth.getInstance().getCurrentUser();
//        userID = user.getUid();
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageReference = storage.getReference("images").child(userID);
        QuizModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Log.d(TAG, "Fragment created");
//                HomeFragment homeFragment = new HomeFragment();
//                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//                transaction.replace(R.id.mainfragment, homeFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });

//        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get()
//                        .load(uri)
//                        .into(imageAvtMainFragment);
//            }
//        });
//
//        txtAppname.setText("Quang");
        return view;
    }
}