package dbnizar.com.dbnizar.dbnizarbase.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import dbnizar.com.dbnizar.R;
import dbnizar.com.dbnizar.dbnizarbase.common.IConstants;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.request.AddNewRequest;
import dbnizar.com.dbnizar.dbnizarbase.presenter.AddNewProjectPresenter;
import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IAddNewProjectPresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IAddNewProjectView;
import dbnizar.com.dbnizar.library.Log;

public class AddNewProject extends BaseActivity implements IAddNewProjectView {
    private Toolbar toolbarProfileEdit;
    private TextView vTvToolbarTitle;

    private Button mButtonAdd;

    IAddNewProjectPresenter iAddNewProjectPresenter;

    EditText mEditTextAddDate, mEditTextProjectName, mEditTextManagerName, mEditTextClientName, mEditTextClientEmail, mEditTextBudget, mEditTextTimeline, mEditTextPlatform, mEditTextInternalTimeline;
    Spinner mSpinnerType;

    String selectedSpinner = "Web";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_project);

        bindView();

        iAddNewProjectPresenter = new AddNewProjectPresenter(this);
        iAddNewProjectPresenter.onCreatePresenter(getIntent().getExtras());
    }

    private void bindView() {

        toolbarProfileEdit = (Toolbar) findViewById(R.id.toolbar_common);
        vTvToolbarTitle = (TextView) findViewById(R.id.toolbar_title_common);
        vTvToolbarTitle.setText("Add New Project");
        setSupportActionBar(toolbarProfileEdit);
        // Remove default title text
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Remove default title text
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mEditTextProjectName = (EditText) findViewById(R.id.add_project_name);
        mEditTextManagerName = (EditText) findViewById(R.id.add_project_manager_name);
        mEditTextClientName = (EditText) findViewById(R.id.add_client_name);
        mEditTextClientEmail = (EditText) findViewById(R.id.add_client_email);
        mEditTextBudget = (EditText) findViewById(R.id.add_budget);
        mEditTextTimeline = (EditText) findViewById(R.id.add_timeline);
        mEditTextAddDate = (EditText) findViewById(R.id.add_official_date);

        mSpinnerType = (Spinner) findViewById(R.id.add_spinner_type);

        mEditTextPlatform = (EditText) findViewById(R.id.add_platform);

        mEditTextInternalTimeline = (EditText) findViewById(R.id.add_internal_timeline);

        mButtonAdd = (Button) findViewById(R.id.submit_project);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewRequest addNewRequest = new AddNewRequest();

                addNewRequest.setProjectName(mEditTextProjectName.getText().toString());
                addNewRequest.setProjectManagerName(mEditTextManagerName.getText().toString());
                addNewRequest.setClientName(mEditTextClientName.getText().toString());
                addNewRequest.setClientEmail(mEditTextClientEmail.getText().toString());
                addNewRequest.setAdminBudget(mEditTextBudget.getText().toString());
                addNewRequest.setClientTimeline(mEditTextTimeline.getText().toString());
                addNewRequest.setInternalTimeline(mEditTextInternalTimeline.getText().toString());
                addNewRequest.setOfficialStartDate(mEditTextAddDate.getText().toString());
                addNewRequest.setType(selectedSpinner);
                addNewRequest.setPlatform(mEditTextPlatform.getText().toString());

                iAddNewProjectPresenter.onClickAdd(addNewRequest);
            }
        });

        mEditTextAddDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDate();
            }
        });
        mSpinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemName = parent.getSelectedItem().toString();
                selectedSpinner = itemName;
                Log.d(TAG, "itemName" + itemName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
    public void navigateToHomeActivity() {

        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(IConstants.BundleKey.LOGIN_TYPE, 0);

        startActivity(intent);
    }


    private void callDate() {
        final Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(new com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

                String originalDateFormat = String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1) + "-" + String.valueOf(year);
                mEditTextAddDate.setText(originalDateFormat);
            }
        }, year, month, day);

        datePickerDialog.setMinDate(c);
        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
    }
}
