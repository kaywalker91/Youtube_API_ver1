package com.kaywalker.youtube_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kaywalker.youtube_api.fragment.HomeFragment;
import com.kaywalker.youtube_api.fragment.PlaylistFragment;
import com.kaywalker.youtube_api.fragment.ProfileFragment;
import com.kaywalker.youtube_api.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment = new HomeFragment();
    private PlaylistFragment playlistFragment = new PlaylistFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private ProfileFragment profileFragment = new ProfileFragment();

    private BottomNavigationView bottom_navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navi = findViewById(R.id.menu_bottom);
        
        setFragment(homeFragment);

        bottom_navi.setSelectedItemId(R.id.menu_home);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked()) {
                    return true;
                }else{
                    switch (item.getItemId()){
                        case R.id.menu_home:
                            setFragment(homeFragment);
                            getSupportActionBar().setTitle("Home");
                            return true;
                        case R.id.menu_playlist:
                            setFragment(playlistFragment);
                            getSupportActionBar().setTitle("Playlist");
                            return true;
                        case R.id.menu_search:
                            setFragment(searchFragment);
                            getSupportActionBar().setTitle("Search");
                            return true;
                        case R.id.menu_profile:
                            setFragment(profileFragment);
                            getSupportActionBar().setTitle("Profile");
                            return true;
                        default:
                            setFragment(homeFragment);
                            getSupportActionBar().setTitle("Home");
                            return true;
                    }
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.commit();
    }
}