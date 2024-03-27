package com.example.test_mku_app.Views;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test_mku_app.Models.UserModel;
import com.example.test_mku_app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtChangePassword, txtMSSV, txtEmail, txtUsername,
            txtPhoneNumber;
    private Button btnEditProfile;
    private ImageButton imgbtnChangeAvtImage;
    private ImageView imageAvt;
    SharedPreferences sharedPreferences;
    private ContentLoadingProgressBar progressBar;
    private DatabaseReference databaseReference;
    private static final String SHARED_PREF_NAME = "user";
    private static final String Kname = "username";
    private static final String Kemai = "email";
    private static final String Kphone = "phone";
    private static final String Kmssv = "mssv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtChangePassword = findViewById(R.id.txtChangePassword);
        txtMSSV = findViewById(R.id.txtMSSV);
        txtEmail = findViewById(R.id.txtEmail);
        txtUsername = findViewById(R.id.txtUsername);
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        btnEditProfile = findViewById(R.id.btnEditProfile);
        imgbtnChangeAvtImage = findViewById(R.id.imgbtnChangeAvtImage);
        imageAvt = findViewById(R.id.imageAvt);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");


        //txtChangePassword dùng để thay đổi mật khẩu

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference("images").child(userID);
        txtChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change password
            }
        });
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
        progressBar.show();
        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            String name, phone, email, mssv;
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.getValue(UserModel.class);
               if (userModel != null) {
                   name = userModel.getUsername();
                   email = userModel.getEmail();
                   phone = userModel.getPhone();
                   mssv = userModel.getMssv();

                   txtEmail.setText(email);
                   txtUsername.setText(name);
                   txtPhoneNumber.setText(phone);
                   txtMSSV.setText(mssv);

                   progressBar.hide();
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG,"Failed to read value", error.toException());
            }
        });

        imgbtnChangeAvtImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, UpLoadImageProfileActivity.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get()
                        .load(uri)
                        .into(imageAvt);
            }
        });

    }
}