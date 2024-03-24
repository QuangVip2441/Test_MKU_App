package com.example.test_mku_app.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test_mku_app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtChangePassword, txtMSSV, txtEmail, txtUsername,
            txtPhoneNumber;
    private Button btnEditProfile;
    private ImageButton imgbtnChangeAvtImage;
    private ImageView imageAvt;
    private FirebaseUser user;
    private String userID;
    SharedPreferences sharedPreferences;

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

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();
        userID = user.getUid();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference("images").child(userID);

        //txtChangePassword dùng để thay đổi mật khẩu
        txtChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change Password
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