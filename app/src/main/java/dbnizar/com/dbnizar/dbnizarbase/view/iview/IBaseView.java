package dbnizar.com.dbnizar.dbnizarbase.view.iview;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IBasePresenter;
import dbnizar.com.dbnizar.dbnizarbase.util.CodeSnippet;
import dbnizar.com.dbnizar.library.CustomException;


public interface IBaseView {


    void showMessage(String message);

    void showMessage(int resId);

    void showMessage(CustomException e);

    void showProgressbar();

    void dismissProgressbar();

    FragmentActivity getActivity();

    void showSnackBar(String message);

    void showSnackBar(@NonNull View view, String message);

    void showNetworkMessage();

    CodeSnippet getCodeSnippet();

    void bindPresenter(IBasePresenter iPresenter);
}
