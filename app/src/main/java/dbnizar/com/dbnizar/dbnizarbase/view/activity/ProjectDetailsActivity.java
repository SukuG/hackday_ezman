package dbnizar.com.dbnizar.dbnizarbase.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import dbnizar.com.dbnizar.R;

public class ProjectDetailsActivity extends AppCompatActivity {

    private Toolbar toolbarProfileEdit;
    private TextView vTvToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        bindView();
    }

    private void bindView() {

        toolbarProfileEdit = (Toolbar) findViewById(R.id.toolbar_common);
        vTvToolbarTitle = (TextView) findViewById(R.id.toolbar_title_common);
        vTvToolbarTitle.setText("Project Details");
        setSupportActionBar(toolbarProfileEdit);
        // Remove default title text
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Remove default title text
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
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
}
