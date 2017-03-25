package dbnizar.com.dbnizar.dbnizarbase.view.iview;

import dbnizar.com.dbnizar.dbnizarbase.adapter.ProjectListAdapter;

/**
 * Created by sukumar on 3/25/2017
 */

public interface IHomeActivityView extends IBaseView {

    void loginType(int flag, String title);

    void navigateToAddProjectDetailsActivity();

    void setAdapter(ProjectListAdapter adapter);
}
