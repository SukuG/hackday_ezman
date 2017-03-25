package dbnizar.com.dbnizar.dbnizarbase.model.webservice;

import dbnizar.com.dbnizar.dbnizarbase.common.retrofit.ResponseListener;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.response.ProjectListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sukumar on 3/25/2017
 */

public class HomeActivityFunction extends BaseModel {

    private ResponseListener responseListener;

    public HomeActivityFunction(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    public void callProjectListApi() {
        try {
            Call<ProjectListResponse> responseCall = apiService.getProjectDetails();
            validate(responseCall);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validate(Call<ProjectListResponse> baseResponseCall) {
        baseResponseCall.enqueue(new Callback<ProjectListResponse>() {
            @Override
            public void onResponse(Call<ProjectListResponse> call, Response<ProjectListResponse> response) {
                switch (response.code()) {
                    case 200:
                        responseListener.onSuccess(response.body().getData(), response.body().getStatus(), response.body().getMessage());
                        break;
                    case 400:
                        responseListener.showRequestErrorMessage(response.message());
                        break;
                    case 401:
                        responseListener.showLogoutDialog(response.message());
                        break;
                    case 500:
                        responseListener.showInternalErrorMessage(response.message());
                        break;
                }
            }

            @Override
            public void onFailure(Call<ProjectListResponse> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });

    }
}
