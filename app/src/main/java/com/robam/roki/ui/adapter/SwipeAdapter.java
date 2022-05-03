package com.robam.roki.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.robam.roki.ItemSlideHelper;
import com.robam.roki.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.SwipeViewHolder>
        implements ItemSlideHelper.Callback {

    private Context context;
    private List<String> mDatas = new ArrayList<String>();

    private RecyclerView mRecyclerView;

    public SwipeAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_msg_remind, parent, false);
        return new SwipeViewHolder(view);
    }

    /**
     * 将recyclerView绑定Slide事件
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
        mRecyclerView.addOnItemTouchListener(new ItemSlideHelper(mRecyclerView.getContext(), this));
    }

    @Override
    public void onBindViewHolder(final SwipeViewHolder holder, final int position) {
        /**
         * 消息状态
         */

        //消息标题
        holder.tvMsg.setText(mDatas.get(position));
        //消息内容


        /**
         * -->特别注意，敲黑板了啊！！！在执行notify的时候，取position要取holder.getAdapterPosition()，
         * 消息被删除之后，他原来的position是final的，所以取到的值不准确，会报数组越界。
         */

        //消息主体监听，这里我是让他添加一条数据，替换成你需要的操作即可

        //标记已读监听

        //删除监听
        holder.tvMsgRemindDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeData(holder.getAbsoluteAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 此方法用来计算水平方向移动的距离
     *
     * @param holder
     * @return
     */
    @Override
    public int getHorizontalRange(RecyclerView.ViewHolder holder) {

            ViewGroup viewGroup = (ViewGroup) holder.itemView;
            //viewGroup包含3个控件，即消息主item、标记已读、删除，返回为标记已读宽度+删除宽度
            return viewGroup.getChildAt(1).getLayoutParams().width;
//                    + viewGroup.getChildAt(2).getLayoutParams().width;

    }

    @Override
    public RecyclerView.ViewHolder getChildViewHolder(View childView) {
        return mRecyclerView.getChildViewHolder(childView);
    }

    @Override
    public View findTargetView(float x, float y) {
        return mRecyclerView.findChildViewUnder(x, y);
    }

    /**
     * 自定义的ViewHolder
     */
    public class SwipeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMsg;
        private TextView tvMsgRemindDelete;

        public SwipeViewHolder(View itemView) {
            super(itemView);
            tvMsg = itemView.findViewById(R.id.tv_title);
            tvMsgRemindDelete = itemView.findViewById(R.id.tv_msg_remind_delete);
        }
    }

    /**
     * 添加单条数据
     *
     * @param position
     */
    public void addData(int position) {


        String vo = "test" + position;

        mDatas.add(position, vo);
        notifyItemInserted(position);
    }

    /**
     * 删除单条数据
     *
     * @param position
     */
    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

}
