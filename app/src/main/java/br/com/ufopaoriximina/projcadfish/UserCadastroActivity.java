package br.com.ufopaoriximina.projcadfish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class UserCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cadastro);
        setTitle("");
        getSupportActionBar().setElevation(0);
        
        /*FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Guia", FragmentHomeMenu.class)
                        .add("Pescador", FragmentMenuCadastrarPeixe.class)
                        .create()
        );
        ViewPager viewPager = findViewById(R.id.viewpagerCadastroUser);
        viewPager.setAdapter( adapter );
        SmartTabLayout viewPagerTab = findViewById(R.id.smartTabLayout);
        viewPagerTab.setViewPager( viewPager );*/
    }
}
