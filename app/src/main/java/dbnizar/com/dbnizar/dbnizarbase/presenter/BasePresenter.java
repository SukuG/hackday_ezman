package dbnizar.com.dbnizar.dbnizarbase.presenter;

import android.content.Intent;
import android.os.Bundle;

import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IBasePresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IBaseView;


public class BasePresenter implements IBasePresenter {
    protected String TAG = getClass().getSimpleName();
    private IBaseView iView;

    BasePresenter(IBaseView iView) {
        this.iView = iView;
        iView.bindPresenter(this);
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }

    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {
    }

    @Override
    public void onResumePresenter() {
    }

    @Override
    public void onDestroyPresenter() {

    }

    @Override
    public void onActivityResultPresenter(int requestCode, int resultCode, Intent data) {

    }
}
