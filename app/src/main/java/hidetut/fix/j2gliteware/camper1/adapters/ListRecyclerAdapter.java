package hidetut.fix.j2gliteware.camper1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import hidetut.fix.j2gliteware.camper1.R;
import hidetut.fix.j2gliteware.camper1.helpers.ListRecyclerItemViewHolder;

public class ListRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mItemList;
    private Context mctx;
    private int lastPosition = -1;

    public ListRecyclerAdapter(Context ctx, List<String> itemList) {

        mItemList = itemList;
        mctx = ctx;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
        return ListRecyclerItemViewHolder.newInstance(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ListRecyclerItemViewHolder holder = (ListRecyclerItemViewHolder) viewHolder;
        String itemText = mItemList.get(position);
        holder.setItemText(itemText, mctx);
        holder.setImage(mctx, position);

        Animation animation = AnimationUtils.loadAnimation(mctx,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;
    }
    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

}
