package dbnizar.com.dbnizar.dbnizarbase.model.webservice;

import dbnizar.com.dbnizar.dbnizarbase.common.retrofit.ResponseListener;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.request.AddNewRequest;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.response.BaseResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sukumar on 3/25/2017
 */

public class AddNewFunction extends BaseModel {

    private ResponseListener responseListener;

    public AddNewFunction(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }


    public void callAddNewRequest(AddNewRequest addNewRequest) {
        try {
            Call<BaseResponse> responseCall = apiService.callAddNewRequest(addNewRequest);
            validate(responseCall);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validate(Call<BaseResponse> baseResponseCall) {
        baseResponseCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                switch (response.code()) {
                    case 200:
                        responseListener.onSuccess(response.body().toString(), response.body().getStatus(), response.body().getMessage());
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
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                responseListener.onFailure(t);

            }
        });

    }
}
