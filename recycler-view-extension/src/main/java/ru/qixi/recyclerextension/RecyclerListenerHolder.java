package ru.qixi.recyclerextension;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by qixi on 02.10.15.
 */
public class RecyclerListenerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    IHolderClickListener listener;


    public RecyclerListenerHolder(View itemView, IHolderClickListener pClickListener) {
        super(itemView);
        listener = pClickListener;
    }


    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view, this);
        }
    }

}