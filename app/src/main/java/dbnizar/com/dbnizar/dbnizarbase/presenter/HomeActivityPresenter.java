package dbnizar.com.dbnizar.dbnizarbase.presenter;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import dbnizar.com.dbnizar.dbnizarbase.adapter.ProjectListAdapter;
import dbnizar.com.dbnizar.dbnizarbase.adapter.listener.IProjectListener;
import dbnizar.com.dbnizar.dbnizarbase.common.IConstants;
import dbnizar.com.dbnizar.dbnizarbase.common.retrofit.ResponseListener;
import dbnizar.com.dbnizar.dbnizarbase.model.common.ProjectListModel;
import dbnizar.com.dbnizar.dbnizarbase.model.common.ProjectListModelData;
import dbnizar.com.dbnizar.dbnizarbase.model.webservice.HomeActivityFunction;
import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IHomeActivityPresenter;
import dbnizar.com.dbnizar.dbnizarbase.view.activity.ProjectDetailsActivity;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IHomeActivityView;
import dbnizar.com.dbnizar.library.Log;

/**
 * Created by sukumar on 3/25/2017
 */

public class HomeActivityPresenter extends BasePresenter implements IHomeActivityPresenter {

    private IHomeActivityView iHomeActivityView;

    public HomeActivityPresenter(IHomeActivityView iHomeActivityView) {
        super(iHomeActivityView);
        this.iHomeActivityView = iHomeActivityView;
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {
        super.onCreatePresenter(bundle);

        if (bundle != null) {
            if (bundle.getInt(IConstants.BundleKey.LOGIN_TYPE) == 0) {
                iHomeActivityView.loginType(0, "Welcome Admin");
            } else {
                iHomeActivityView.loginType(1, "Welcome PM");
            }
        }
        if (!iHomeActivityView.getCodeSnippet().hasNetworkConnection()) {
            iHomeActivityView.showNetworkMessage();
        } else {
            iHomeActivityView.showProgressbar();
            HomeActivityFunction homeActivityFunction = new HomeActivityFunction(projectListModelResponseListener);
            homeActivityFunction.callProjectListApi();
        }
    }

    @Override
    public void onClickAddNew() {
        iHomeActivityView.navigateToAddProjectDetailsActivity();
    }


    private ResponseListener<ProjectListModel> projectListModelResponseListener = new ResponseListener<ProjectListModel>() {
        @Override
        public void onSuccess(ProjectListModel mResponse, int status, String message) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage(message);

            List<ProjectListModelData> list = mResponse.getProjectdetails();
            //set adapter
            ProjectListAdapter projectListAdapter = new ProjectListAdapter(list, iProjectListener);
            iHomeActivityView.setAdapter(projectListAdapter);

            Log.d(TAG, "Size:" + list.size());
        }

        @Override
        public void onFailure(Throwable mThrowable) {
            iHomeActivityView.dismissProgressbar();
        }

        @Override
        public void showLogoutDialog(String message) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage(message);
        }

        @Override
        public void showRequestErrorMessage(String message) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage(message);
        }

        @Override
        public void showInternalErrorMessage(String message) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage(message);
        }
    };

    private IProjectListener iProjectListener = new IProjectListener() {
        @Override
        public void onClickItem() {

            Intent intent = new Intent(iHomeActivityView.getActivity(), ProjectDetailsActivity.class);
            iHomeActivityView.getActivity().startActivity(intent);
        }
    };

}
