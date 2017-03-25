package dbnizar.com.dbnizar.dbnizarbase.view.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IBasePresenter;
import dbnizar.com.dbnizar.dbnizarbase.util.CodeSnippet;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IBaseView;
import dbnizar.com.dbnizar.dbnizarbase.view.widget.CustomProgressbar;
import dbnizar.com.dbnizar.library.CustomException;


public class BaseActivity extends AppCompatActivity implements IBaseView {

    protected View parentView;
    private IBasePresenter iPresenter;
    private CustomProgressbar mCustomProgressbar;
    public String TAG = getClass().getSimpleName();
    protected CodeSnippet mCodeSnippet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        parentView = getWindow().getDecorView().findViewById(android.R.id.content);
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (iPresenter != null)
            iPresenter.onStartPresenter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (iPresenter != null)
            iPresenter.onStopPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (iPresenter != null)
            iPresenter.onResumePresenter();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (iPresenter != null)
            iPresenter.onPausePresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (iPresenter != null)
            iPresenter.onDestroyPresenter();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (iPresenter != null) iPresenter.onActivityResultPresenter(requestCode, resultCode, data);
    }


    private CustomProgressbar getProgressBar() {
        if (mCustomProgressbar == null) {
            mCustomProgressbar = new CustomProgressbar(this);
        }
        return mCustomProgressbar;
    }

    @Override
    public void bindPresenter(IBasePresenter iPresenter) {
        this.iPresenter = iPresenter;

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(CustomException e) {

        Toast.makeText(this, e.getException(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressbar() {
        // TODO have to menu_view_question_preference the custom progressbar
        getProgressBar().show();
    }

    @Override
    public void dismissProgressbar() {
// TODO dismiss the progressbar
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    getProgressBar().dismissProgress();
                } catch (Exception e) {
                    // ExceptionTracker.track(e);
                }
            }
        });
    }

    @Override
    public FragmentActivity getActivity() {
        return BaseActivity.this;
    }


    @Override
    public void showSnackBar(String message) {
        if (parentView != null) {
            Snackbar snackbar = Snackbar.make(parentView, message, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        }

    }

    @Override
    public void showSnackBar(@NonNull View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    @Override
    public void showNetworkMessage() {
        if (parentView != null) {
            Snackbar snackbar = Snackbar.make(parentView, "No Network found!", Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.RED);
            snackbar.setAction("Setting", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCodeSnippet.showNetworkSettings();
                }
            });
            snackbar.show();
        }
    }

    @Override
    public CodeSnippet getCodeSnippet() {
        if (mCodeSnippet == null) {
            mCodeSnippet = new CodeSnippet(getActivity());
            return mCodeSnippet;
        }
        return mCodeSnippet;
    }


}
