package ru.qixi.recyclerextension;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by qixi on 02.10.15.
 */
public interface IHolderClickListener {

    void onClick(View view, RecyclerView.ViewHolder holder);

}
