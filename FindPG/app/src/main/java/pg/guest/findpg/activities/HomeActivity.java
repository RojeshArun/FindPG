package pg.guest.findpg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pg.guest.findpg.R;
import pg.guest.findpg.Utils.StaticUtils;

/**
 * Created by ADMIN on 08-08-2016.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    //UI Variables
    private Button mLogin,mGuestBtn,mNewUserBtn;
    private Intent commonIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        initLoginScreen();
        initListeners();
    }

    private void initListeners() {
        mLogin.setOnClickListener(this);
        mGuestBtn.setOnClickListener(this);
        mNewUserBtn.setOnClickListener(this);
    }

    private void initLoginScreen() {
        mLogin = (Button) findViewById(R.id.btn_login);
        mGuestBtn = (Button) findViewById(R.id.btn_guest);
        mNewUserBtn = (Button) findViewById(R.id.btn_new_user);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                gotoLoginScreen();
                break;
            case R.id.btn_guest:
                gotoGuestPGSearch();
                break;
            case R.id.btn_new_user:
                gotoNewUserRegisteration();
                break;
            default:
                break;
        }
    }

    private void gotoNewUserRegisteration() {
        StaticUtils.IS_GUEST_LOGIN = false;
        commonIntent = new Intent(HomeActivity.this, ContainerActivity.class);
        startActivity(commonIntent);
    }

    private void gotoGuestPGSearch() {
        StaticUtils.IS_GUEST_LOGIN = true;
        commonIntent = new Intent(HomeActivity.this, ContainerActivity.class);
        startActivity(commonIntent);
    }

    private void gotoLoginScreen() {

        commonIntent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(commonIntent);
    }
}
