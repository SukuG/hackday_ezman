package dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter;

import android.content.Intent;
import android.os.Bundle;


public interface IBasePresenter {
    void onCreatePresenter(Bundle bundle);

    void onStartPresenter();

    void onStopPresenter();

    void onPausePresenter();

    void onResumePresenter();

    void onDestroyPresenter();

    void onActivityResultPresenter(int requestCode, int resultCode, Intent data);
}
