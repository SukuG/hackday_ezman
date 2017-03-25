package dbnizar.com.dbnizar.dbnizarbase.common.retrofit;


public interface ResponseListener<T> {
    void onSuccess(T mResponse, int status, String message);

    void onFailure(Throwable mThrowable);

    void showLogoutDialog(String message);

    void showRequestErrorMessage(String message);

    void showInternalErrorMessage(String message);


}
