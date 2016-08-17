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
    private Button mLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        initLoginScreen();
        initListeners();
    }

    private void initListeners() {
        mLogin.setOnClickListener(this);
    }

    private void initLoginScreen() {
        mLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                gotoLoginScreen();
                break;
        }
    }

    private void gotoLoginScreen() {
        Intent loginIntent = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }
}
