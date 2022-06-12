package com.robam.roki.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.robam.roki.R;

import java.util.List;

public class InventoryAdapter extends BaseRecyclerViewAdapter<String> {

    private OnDeleteClickLister mDeleteClickListener;
    private Context mContext;

    public InventoryAdapter(Context context, List<String> data) {
        super(context, data, R.layout.item_inventory);
        mContext = context;
    }

    @Override
    protected void onBindData(RecyclerViewHolder holder, String bean, int position) {
        View view = holder.getView(R.id.tv_delete);
        view.setTag(position);
        if (!view.hasOnClickListeners()) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mDeleteClickListener != null) {
                        mDeleteClickListener.onDeleteClick(v, (Integer) v.getTag());
                    }
                }
            });
        }
        ((TextView) holder.getView(R.id.tv_item_desc)).setText(bean);
        String quantity = bean + "箱";
        ((TextView) holder.getView(R.id.tv_quantity)).setText(quantity);
        String detail = bean + "/" + bean;
        ((TextView) holder.getView(R.id.tv_detail)).setText(detail);
        String volume = bean + "方";
        ((TextView) holder.getView(R.id.tv_volume)).setText(volume);
         ImageView imageView = (ImageView) holder.getView(R.id.imageView);

        Glide.with(mContext).load(R.mipmap.wet).override(100, 100)
                .into(imageView);
    }

    public void setOnDeleteClickListener(OnDeleteClickLister listener) {
        this.mDeleteClickListener = listener;
    }

    public interface OnDeleteClickLister {
        void onDeleteClick(View view, int position);
    }
}
