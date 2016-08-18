package pg.guest.findpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ADMIN on 08-08-2016.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    //UI Variables
    private Button mLogin,mGuestBtn;
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
    }

    private void initLoginScreen() {
        mLogin = (Button) findViewById(R.id.btn_login);
        mGuestBtn = (Button) findViewById(R.id.btn_guest);

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
        }
    }

    private void gotoGuestPGSearch() {
        commonIntent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(commonIntent);
    }

    private void gotoLoginScreen() {
        commonIntent = new Intent(HomeActivity.this, ContainerActivity.class);
        startActivity(commonIntent);
    }
}
