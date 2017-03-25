package dbnizar.com.dbnizar.dbnizarbase.presenter;

import android.os.Bundle;

import dbnizar.com.dbnizar.dbnizarbase.common.retrofit.ResponseListener;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.request.AddNewRequest;
import dbnizar.com.dbnizar.dbnizarbase.model.webservice.AddNewFunction;
import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IAddNewProjectPresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IAddNewProjectView;

/**
 * Created by sukumar on 3/25/2017
 */

public class AddNewProjectPresenter extends BasePresenter implements IAddNewProjectPresenter {
    IAddNewProjectView iAddNewProjectView;

    public AddNewProjectPresenter(IAddNewProjectView iAddNewProjectView) {
        super(iAddNewProjectView);
        this.iAddNewProjectView = iAddNewProjectView;
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {
        super.onCreatePresenter(bundle);
    }

    @Override
    public void onClickAdd(AddNewRequest addNewRequest) {
        if (!iAddNewProjectView.getCodeSnippet().hasNetworkConnection()) {
            iAddNewProjectView.showNetworkMessage();
        } else {
            iAddNewProjectView.showProgressbar();
            AddNewFunction addNewFunction = new AddNewFunction(stringResponseListener);
            addNewFunction.callAddNewRequest(addNewRequest);
        }
    }

    private ResponseListener<String> stringResponseListener = new ResponseListener<String>() {
        @Override
        public void onSuccess(String mResponse, int status, String message) {
            iAddNewProjectView.dismissProgressbar();
            iAddNewProjectView.showMessage(message);
            iAddNewProjectView.navigateToHomeActivity();
        }

        @Override
        public void onFailure(Throwable mThrowable) {
            iAddNewProjectView.dismissProgressbar();

        }

        @Override
        public void showLogoutDialog(String message) {
            iAddNewProjectView.dismissProgressbar();
            iAddNewProjectView.showMessage(message);

        }

        @Override
        public void showRequestErrorMessage(String message) {
            iAddNewProjectView.dismissProgressbar();
            iAddNewProjectView.showMessage(message);

        }

        @Override
        public void showInternalErrorMessage(String message) {
            iAddNewProjectView.showMessage(message);

        }
    };
}
