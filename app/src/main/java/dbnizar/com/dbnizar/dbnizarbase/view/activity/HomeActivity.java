package dbnizar.com.dbnizar.dbnizarbase.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dbnizar.com.dbnizar.R;
import dbnizar.com.dbnizar.dbnizarbase.adapter.ProjectListAdapter;
import dbnizar.com.dbnizar.dbnizarbase.presenter.HomeActivityPresenter;
import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IHomeActivityPresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IHomeActivityView;

import static dbnizar.com.dbnizar.R.id.button_add_new_project;

public class HomeActivity extends BaseActivity implements IHomeActivityView {

    IHomeActivityPresenter iHomeActivityPresenter;
    private Toolbar toolbarProfileEdit;
    private TextView vTvToolbarTitle;

    private int loginType;
    private String loginTitle;

    private Button mButtonAddNewProject;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bindView();

        iHomeActivityPresenter = new HomeActivityPresenter(this);
        iHomeActivityPresenter.onCreatePresenter(getIntent().getExtras());


    }

    private void bindView() {

        toolbarProfileEdit = (Toolbar) findViewById(R.id.toolbar_common);
        vTvToolbarTitle = (TextView) findViewById(R.id.toolbar_title_common);
        vTvToolbarTitle.setText("");
        setSupportActionBar(toolbarProfileEdit);
        // Remove default title text
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Remove default title text
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mButtonAddNewProject = (Button) findViewById(button_add_new_project);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_project_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mButtonAddNewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iHomeActivityPresenter.onClickAddNew();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.left_in, R.anim.left_out);
        finish();

    }

    @Override
    public void loginType(int flag, String title) {
        this.loginTitle = title;
        this.loginType = flag;
        vTvToolbarTitle.setText(title);
        if (flag == 0) {
            mButtonAddNewProject.setVisibility(View.VISIBLE);
        } else {
            mButtonAddNewProject.setVisibility(View.GONE);
        }
    }

    @Override
    public void navigateToAddProjectDetailsActivity() {
        Intent intent = new Intent(this, AddNewProject.class);
        startActivity(intent);
    }

    @Override
    public void setAdapter(ProjectListAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
