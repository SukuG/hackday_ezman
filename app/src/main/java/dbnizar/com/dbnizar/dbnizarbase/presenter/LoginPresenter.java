package dbnizar.com.dbnizar.dbnizarbase.presenter;

import android.os.Bundle;

import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.ILoginPresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.ILoginView;

/**
 * Created by sukumar on 3/25/2017
 */

public class LoginPresenter extends BasePresenter implements ILoginPresenter {

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        super(iLoginView);
        this.iLoginView = iLoginView;
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {
        super.onCreatePresenter(bundle);
    }

    @Override
    public void onClickAdmin() {
        iLoginView.navigateToHomeActivity(0);
    }

    @Override
    public void onClickProjectManager() {
        iLoginView.navigateToHomeActivity(1);
    }
}
