package dbnizar.com.dbnizar.dbnizarbase.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dbnizar.com.dbnizar.R;
import dbnizar.com.dbnizar.dbnizarbase.common.IConstants;
import dbnizar.com.dbnizar.dbnizarbase.presenter.LoginPresenter;
import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.ILoginPresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.ILoginView;

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {

    ILoginPresenter iLoginPresenter;
    Button mButtonAdmin, mButtonProjectManager, mButtonClient, mButtonResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        bindView();
        iLoginPresenter = new LoginPresenter(this);
        iLoginPresenter.onCreatePresenter(getIntent().getExtras());
    }

    void bindView() {

        mButtonAdmin = (Button) findViewById(R.id.button_admin);
        mButtonProjectManager = (Button) findViewById(R.id.button_projectmanager);
        mButtonClient = (Button) findViewById(R.id.button_client);
        mButtonResource = (Button) findViewById(R.id.button_resource);

        mButtonProjectManager.setOnClickListener(this);
        mButtonAdmin.setOnClickListener(this);

        mButtonResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Have to implement");
            }
        });
        mButtonClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Have to implement");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_admin:
                iLoginPresenter.onClickAdmin();
                break;

            case R.id.button_projectmanager:
                iLoginPresenter.onClickProjectManager();
                break;
        }
    }

    @Override
    public void navigateToHomeActivity(int flag) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(IConstants.BundleKey.LOGIN_TYPE, flag);
        startActivity(intent);
    }
}
