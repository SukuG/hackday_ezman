package dbnizar.com.dbnizar.dbnizarbase.model.webservice;


import dbnizar.com.dbnizar.dbnizarbase.common.retrofit.ApiClient;
import dbnizar.com.dbnizar.dbnizarbase.common.retrofit.ApiInterface;

public class BaseModel {

    protected String TAG = this.getClass().getSimpleName();
    protected ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

}
