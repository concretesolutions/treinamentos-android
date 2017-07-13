package br.com.concrete.androidanimationspart1.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;
import br.com.concrete.androidanimationspart1.fragment.drawable.DrawableLikeFragment;
import br.com.concrete.androidanimationspart1.fragment.drawable.DrawableLoadingFragment;
import br.com.concrete.androidanimationspart1.fragment.property.ObjectCornerFragment;
import br.com.concrete.androidanimationspart1.fragment.property.ObjectFloatFragment;
import br.com.concrete.androidanimationspart1.fragment.property.SetFragment;
import br.com.concrete.androidanimationspart1.fragment.property.ValueColorFragment;
import br.com.concrete.androidanimationspart1.fragment.property.ValueTextFragment;
import br.com.concrete.androidanimationspart1.fragment.viewanimation.ViewAlphaFragment;
import br.com.concrete.androidanimationspart1.fragment.viewanimation.ViewRotationFragment;
import br.com.concrete.androidanimationspart1.fragment.viewanimation.ViewScaleFragment;
import br.com.concrete.androidanimationspart1.fragment.viewanimation.ViewTranslationFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = fm.findFragmentById(R.id.content);
                if (fragment != null && fragment instanceof AnimationFragment) {
                    ((AnimationFragment) fragment).runAnimation();
                } else {
                    Toast.makeText(MainActivity.this, "fragment não encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.view_scale);
        setFragment(ViewScaleFragment.newInstance());
        setTitle("Scale ViewAnimation");
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.view_alpha) {
            setFragment(ViewAlphaFragment.newInstance());
            setTitle("Alpha ViewAnimation");
        } else if (id == R.id.view_rotation) {
            setFragment(ViewRotationFragment.newInstance());
            setTitle("Rotation ViewAnimation");
        } else if (id == R.id.view_scale) {
            setFragment(ViewScaleFragment.newInstance());
            setTitle("Scale ViewAnimation");
        } else if (id == R.id.view_translation) {
            setFragment(ViewTranslationFragment.newInstance());
            setTitle("Translation ViewAnimation");
        } else if (id == R.id.property_object_corner) {
            setFragment(ObjectCornerFragment.newInstance());
            setTitle("ObjectAnimator Corner");
        } else if (id == R.id.property_object_float) {
            setFragment(ObjectFloatFragment.newInstance());
            setTitle("ObjectAnimator Float");
        } else if (id == R.id.property_value_color) {
            setFragment(ValueColorFragment.newInstance());
            setTitle("ValueAnimator Color");
        } else if (id == R.id.property_value_text) {
            setFragment(ValueTextFragment.newInstance());
            setTitle("ValueAnimator Text");
        } else if (id == R.id.property_set) {
            setFragment(SetFragment.newInstance());
            setTitle("AnimationSet");
        } else if (id == R.id.drawable_loading) {
            setFragment(DrawableLoadingFragment.newInstance());
            setTitle("Drawable Loading");
        } else if (id == R.id.drawable_like) {
            setFragment(DrawableLikeFragment.newInstance());
            setTitle("Drawable Like");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.commit();
    }
}
