package com.moviles.explorador_de_farmacias;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.moviles.explorador_de_farmacias.databinding.ActivityMainBinding;
import com.moviles.explorador_de_farmacias.ui.slideshow.SlideshowFragment;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pedirPermiso();

        setSupportActionBar(binding.appBarMain.toolbar);



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.map, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_salir)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

       drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
           @Override
           public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

           }

           @Override
           public void onDrawerOpened(@NonNull View drawerView) {
               Log.d("evento","entro al drawer");
               Menu menu = navigationView.getMenu();
               menu.findItem(R.id.map).setTitle(SlideshowFragment.navMapa);
               menu.findItem(R.id.nav_gallery).setTitle(SlideshowFragment.navListaFarmacias);
               menu.findItem(R.id.nav_slideshow).setTitle(SlideshowFragment.navConfiguracion);
               menu.findItem(R.id.nav_salir).setTitle(SlideshowFragment.navSalir);
           }

           @Override
           public void onDrawerClosed(@NonNull View drawerView) {

           }

           @Override
           public void onDrawerStateChanged(int newState) {

           }
       });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void pedirPermiso(){
        Log.d("entro", "entro a metodo");
        //CHEQUEA VERSION Q SEA MAS DE 6 Y SI LOS PERMISOS NO ESTAN OTORGADOS S ELOS PIDE AL USUARIO
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && (checkSelfPermission(ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) ||
                (checkSelfPermission(ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)){
            Log.d("entro", "pidio permisos");
            requestPermissions(new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION},1000);
        }
    }




}