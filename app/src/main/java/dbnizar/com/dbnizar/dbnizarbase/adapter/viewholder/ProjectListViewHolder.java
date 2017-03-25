package dbnizar.com.dbnizar.dbnizarbase.adapter.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import dbnizar.com.dbnizar.R;
import dbnizar.com.dbnizar.dbnizarbase.adapter.listener.IProjectListener;
import dbnizar.com.dbnizar.dbnizarbase.model.common.ProjectListModelData;

/**
 * Created by sukumar on 3/25/2017
 */

public class ProjectListViewHolder extends BaseViewHolder<ProjectListModelData> implements View.OnClickListener {

    private IProjectListener iProjectListener;
    TextView mTextViewTitle, textViewClientName, textViewStartDate, textViewManagerName, textViewStatus;
    LinearLayout linearLayout;

    public ProjectListViewHolder(View itemView, IProjectListener iProjectListener) {
        super(itemView);
        this.iProjectListener = iProjectListener;
        bindView();
    }

    private void bindView() {
        mTextViewTitle = (TextView) itemView.findViewById(R.id.item_project_title);
        textViewClientName = (TextView) itemView.findViewById(R.id.item_client_name);
        textViewManagerName = (TextView) itemView.findViewById(R.id.item_manager_name);
        textViewStartDate = (TextView) itemView.findViewById(R.id.item_start_date);
        textViewStatus = (TextView) itemView.findViewById(R.id.item_status);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.parent_layout);
    }

    @Override
    protected void populateData(ProjectListModelData data) {

        linearLayout.setOnClickListener(this);


        mTextViewTitle.setText(data.getProjectName());

        textViewClientName.setText(data.getClientName());
        textViewStartDate.setText(data.getOfficialStartDate());

        textViewStatus.setText("On Going");

        textViewManagerName.setText(data.getProjectManagerName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parent_layout:
                iProjectListener.onClickItem();
                break;
        }
    }
}
