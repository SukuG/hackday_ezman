package dbnizar.com.dbnizar.dbnizarbase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dbnizar.com.dbnizar.R;
import dbnizar.com.dbnizar.dbnizarbase.adapter.listener.IProjectListener;
import dbnizar.com.dbnizar.dbnizarbase.adapter.viewholder.ProjectListViewHolder;
import dbnizar.com.dbnizar.dbnizarbase.model.common.ProjectListModelData;

/**
 * Created by sukumar on 3/25/2017
 */

public class ProjectListAdapter extends BaseRecyclerAdapter<ProjectListModelData, ProjectListViewHolder> {

    private IProjectListener iProjectListener;

    public ProjectListAdapter(List<ProjectListModelData> data, IProjectListener iProjectListener) {
        super(data);
        this.iProjectListener = iProjectListener;
    }

    @Override
    public ProjectListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_list, parent, false);
        return new ProjectListViewHolder(view, iProjectListener);
    }
}
