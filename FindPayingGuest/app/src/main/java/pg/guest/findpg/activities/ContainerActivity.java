package pg.guest.findpg.activities;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import pg.guest.findpg.Utils.StaticUtils;
import pg.guest.findpg.activities.dummy.DummyContent;
import pg.guest.findpg.fragments.FoodFragment;
import pg.guest.findpg.fragments.HomeFragment;
import pg.guest.findpg.R;
import pg.guest.findpg.fragments.GuestSignUpFormFragment;
import pg.guest.findpg.fragments.PgFragment;

/**
 * Created by Rojesh on 17-08-2016.
 */
public class ContainerActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PgFragment.OnListFragmentInteractionListener {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Fragment mGeneralFragment;
    private LinearLayout mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mProgressBar = (LinearLayout) findViewById(R.id.progressbar);
        showProgressBar();
        hideProgressBar();
        setFirstFragment();

    }

    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void setFragmentTitle(String title) {
        if (!TextUtils.isEmpty(title))
            setTitle(title);
    }

    private void setFirstFragment() {
        if (StaticUtils.IS_GUEST_LOGIN)
            mGeneralFragment = new PgFragment();
        else
            mGeneralFragment = new HomeFragment();
        addFragment(false);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_food) {
          /*  invalidateOptionsMenu();
            menu.findItem(R.id.action_search).setVisible(false);*/
            mGeneralFragment = new FoodFragment();
            addFragment(true);
        } else if (id == R.id.nav_services) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

            mGeneralFragment = new HomeFragment();
            addFragment(false);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addFragment(boolean saveFrag) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content_frame, mGeneralFragment);
        if (saveFrag)
            mFragmentTransaction.addToBackStack(mFragmentManager.
                    getClass().getName()).commit();
        else
            mFragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

        mGeneralFragment = new GuestSignUpFormFragment();
        // Clear Stack
        searchView.setVisibility(View.GONE);
        invalidateOptionsMenu();
        StaticUtils.IS_GUEST_LOGIN = false;
        addFragment(false);
    }


    Menu menu;
    SearchView searchView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        if (StaticUtils.IS_GUEST_LOGIN) {
            getMenuInflater().inflate(R.menu.main, menu);
            // Retrieve the SearchView and plug it into SearchManager

            searchView = (SearchView) MenuItemCompat.getActionView(
                    menu.findItem(R.id.action_search));
            SearchManager searchManager = (SearchManager) getSystemService(
                    SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(
                    getComponentName()));

            return true;
        } else {
            return super.onCreateOptionsMenu(menu);
        }

    }
}
