package dbnizar.com.dbnizar.dbnizarbase.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public T data;
    String TAG = getClass().getSimpleName();

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(T data) {
        this.data = data;
        populateData(data);
    }

    protected abstract void populateData(T data);
}
