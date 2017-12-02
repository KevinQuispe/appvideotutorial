package com.alquiler.appalquiler;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener,Home.OnFragmentInteractionListener,
        RegistrarUsuario.OnFragmentInteractionListener,
        RegistrarHabitacion.OnFragmentInteractionListener,
        ListaInquilinos.OnFragmentInteractionListener,
        ListaUsuarios.OnFragmentInteractionListener,
        HabitacionesDisponibles.OnFragmentInteractionListener,
        Fragment_registrar_inquilino.OnFragmentInteractionListener{
    //declaracion de variablae para my view page
    private  static final String TAG="MainActivity";
    private  SectionPageAdapter mseconpageadapter;
    private ViewPager mviewpager;

    private TextView mTextMessage;
    Button registrar,nuevo,volver;

    //accion para el home
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Home home=new Home();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container,home);
                    transaction.commit();
                    return true;

                case R.id.navigation_dashboard:
                    FragmentTransaction transaction1= getSupportFragmentManager().beginTransaction();
                    transaction1.replace(R.id.contenedorfragment,home);
                    transaction1.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llamaar a los eventos
        mTextMessage = (TextView) findViewById(R.id.tvbienvenido);
        Bundle bundle = getIntent().getExtras();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //init para mis eventos en view pager
        mseconpageadapter=new SectionPageAdapter(getSupportFragmentManager());
        mviewpager=(ViewPager) findViewById(R.id.container);
        //setupViewPager(mviewpager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_usuario) {
            RegistrarUsuario usuario=new RegistrarUsuario();
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedorfragment,usuario);
            transaction.commit();

        } else if (id == R.id.nav_habitacion) {
            RegistrarHabitacion habitacion=new RegistrarHabitacion();
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedorfragment,habitacion);
            transaction.commit();

        } else if (id == R.id.nav_inquilino) {

            Fragment_registrar_inquilino inquilino=new  Fragment_registrar_inquilino();
            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedorfragment,inquilino);
            transaction.commit();

        }
        //consultas
        else if (id == R.id.nav_listausuarios) {

        }
        else if (id == R.id.nav_listinquilinos) {

        }
        else if (id == R.id.nav_habdisponible) {

        }

        else if (id == R.id.nav_salir) {
            Intent intent=new Intent(getApplicationContext(),SplashScreen.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {

    }
    //metodos para mis view pager
    private  void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter=new SectionPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    public void setViewPager(int FragemetNumber){
        mviewpager.setCurrentItem(FragemetNumber);

    }

}
