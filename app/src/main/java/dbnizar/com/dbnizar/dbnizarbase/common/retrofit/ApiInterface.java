package dbnizar.com.dbnizar.dbnizarbase.common.retrofit;


import dbnizar.com.dbnizar.dbnizarbase.model.dto.request.AddNewRequest;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.response.BaseResponse;
import dbnizar.com.dbnizar.dbnizarbase.model.dto.response.ProjectListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("addProject")
    Call<BaseResponse> callAddNewRequest(@Body AddNewRequest addNewRequest);


    @GET("getProJectDetails")
    Call<ProjectListResponse> getProjectDetails();

}

