package dbnizar.com.dbnizar.dbnizarbase.presenter.ipresenter;

import dbnizar.com.dbnizar.dbnizarbase.model.dto.request.AddNewRequest;

/**
 * Created by sukumar on 3/25/2017
 */

public interface IAddNewProjectPresenter extends IBasePresenter {
    void onClickAdd(AddNewRequest addNewRequest);
}
