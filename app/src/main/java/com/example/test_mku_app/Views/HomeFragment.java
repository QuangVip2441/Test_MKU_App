package com.example.test_mku_app.Views;

import static com.example.test_mku_app.R.id.fragment_container;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.test_mku_app.Models.ModuleModel;
import com.example.test_mku_app.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private MaterialButton buttonQuizModule;
    private ImageView buttonQuizModule1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<ModuleModel> models = new ArrayList<>();
        models.add(new ModuleModel("Kusy65zYEQRHwBD4xK5w","IU01","Hiểu biết về CNTT cơ bản",50));
        models.add(new ModuleModel("RcNqOW5J0USOZIhOzMbR","IU02","Sử dụng máy tính cơ bản",50));
        models.add(new ModuleModel("vmuX6BOAwIpFyjAeOdiQ","IU03","Xử lý văn bản cơ bản",50));
        models.add(new ModuleModel("ehP8B1XstrJw3ypJ3dSH","IU04","Sử dụng bảng tính cơ bản",50));
        models.add(new ModuleModel("Sc1vj2JOhi4uxHeHeTpR","IU05","Sử dụng trình chiếu cơ bản",50));
        models.add(new ModuleModel("oqiGmECxloO32EoYG4PF","IU06","Sử dụng Internet cơ bản",50));

        //buttonQuizModule1 = view.findViewById(R.id.buttonQuizModule1);

        buttonQuizModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
            }
        });


//        List<Integer> buttonIds = Arrays.asList(
//                R.id.buttonQuizModule1,
//                R.id.buttonQuizModule2,
//                R.id.buttonQuizModule3,
//                R.id.buttonQuizModule4,
//                R.id.buttonQuizModule5,
//                R.id.buttonQuizModule6
//        );


//        for (Integer buttonId : buttonIds) {
//            imgModule = view.findViewById(buttonId);
//            imgModule.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // Duyệt qua từng buttonId trong danh sách
//                    for (int i = 0; i < buttonIds.size(); i++) {
//                        // So sánh id của view với id của button hiện tại
//                        if (view.getId() == buttonIds.get(i)) {
//                            // Nếu khớp, lấy chỉ số của button trong danh sách để lấy moduleID tương ứng
//                            if (i >= 0 && i < models.size()) {
//                                String moduleID = models.get(i).getId();
//                                StartFragment startFragment = new StartFragment();
//                                Bundle bundle = new Bundle();
//                                bundle.putString("Key", moduleID);
//
//                                startFragment.setArguments(bundle);
//
//                                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//                                transaction.replace(R.id.fragment_container, startFragment);
//                                transaction.addToBackStack(null);
//                                transaction.commit();
//                                break; // Thoát khỏi vòng lặp sau khi xử lý
//                            }
//                        }
//                    }
//                }
//            });
//        }

        return view;
    }

}