package dbnizar.com.dbnizar.dbnizarbase.view.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter.IBasePresenter;
import dbnizar.com.dbnizar.dbnizarbase.util.CodeSnippet;
import dbnizar.com.dbnizar.dbnizarbase.view.iview.IBaseView;
import dbnizar.com.dbnizar.library.CustomException;


public abstract class BaseFragment extends Fragment implements IBaseView {

    protected String TAG = getClass().getSimpleName();


    @Override
    public void bindPresenter(IBasePresenter iBasePresenter) {
        // nothing to implement here!
    }


    @Override
    public void showMessage(String message) {
        ((IBaseView) getActivity()).showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        ((IBaseView) getActivity()).showMessage(resId);
    }

    @Override
    public void showMessage(CustomException e) {
        ((IBaseView) getActivity()).showMessage(e);
    }

    @Override
    public void showProgressbar() {
        ((IBaseView) getActivity()).showProgressbar();
    }

    @Override
    public void dismissProgressbar() {
        ((IBaseView) getActivity()).dismissProgressbar();
    }

    @Override
    public void showSnackBar(String message) {
        ((IBaseView) getActivity()).showSnackBar(message);
    }

    @Override
    public void showNetworkMessage() {
        ((IBaseView) getActivity()).showNetworkMessage();
    }

    @Override
    public CodeSnippet getCodeSnippet() {
        return ((IBaseView) getActivity()).getCodeSnippet();
    }

    @Override
    public void showSnackBar(@NonNull View view, String message) {
        ((IBaseView) getActivity()).showSnackBar(view, message);
    }
}
