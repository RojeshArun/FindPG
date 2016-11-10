package pg.guest.findpg.activities;

import android.app.SearchManager;
import android.content.Intent;
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
import pg.guest.findpg.fragments.AccommodationFragment;
import pg.guest.findpg.fragments.FeedbackFragment;
import pg.guest.findpg.fragments.FoodFragment;
import pg.guest.findpg.fragments.HomeFragment;
import pg.guest.findpg.R;
import pg.guest.findpg.fragments.GuestSignUpFormFragment;
import pg.guest.findpg.fragments.PgFragment;
import pg.guest.findpg.fragments.ServicesFragment;

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
        navigationView.setItemBackgroundResource(R.drawable.abc_dialog_material_background_dark);

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
        addFragment(mGeneralFragment, false);
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
        clearStack();
        if (id == R.id.nav_food) {
            mGeneralFragment = new FoodFragment();
        } else if (id == R.id.nav_services) {
            mGeneralFragment = new ServicesFragment();
        } else if (id == R.id.nav_accommodation) {
            mGeneralFragment = new AccommodationFragment();
        } else if (id == R.id.nav_feedback) {
            mGeneralFragment = new FeedbackFragment();
        } else if (id == R.id.nav_share) {
            mGeneralFragment = new HomeFragment();
        }
        addFragment(mGeneralFragment, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearStack() {
        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++)
            getSupportFragmentManager().popBackStack();
    }

    public void addFragment(Fragment mGeneralFragment, boolean saveFrag) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content_frame, mGeneralFragment);
        mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.enter_from_left,0,0);
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
        addFragment(mGeneralFragment, false);
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
