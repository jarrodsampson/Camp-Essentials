package hidetut.fix.j2gliteware.camper1.helpers;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.util.Pair;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hidetut.fix.j2gliteware.camper1.R;
import hidetut.fix.j2gliteware.camper1.dashboard.details.ItemDetailActivity;

public class ListRecyclerItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView mItemTextView;
    private final TextView mItemTextViewTitle;
    private final ImageView mImage;
    ActionMode mActionMode;
    Context mCTX;
    String mTitle = null;

    public ListRecyclerItemViewHolder(final View parent, TextView itemTextView, TextView itemTextViewTitle, ImageView image) {
        super(parent);
        mItemTextView = itemTextView;
        mItemTextViewTitle = itemTextViewTitle;
        mImage = image;
    }
    public static ListRecyclerItemViewHolder newInstance(View parent) {
        TextView itemTextView = (TextView) parent.findViewById(R.id.itemTextView);
        TextView itemTextViewTitle = (TextView) parent.findViewById(R.id.textView);
        ImageView image = (ImageView) parent.findViewById(R.id.imageViewClickable);
        return new ListRecyclerItemViewHolder(parent, itemTextView, itemTextViewTitle, image);
    }

    private void clickerListener(View v, Context ctx, String header) {
        Snackbar.make(v, header, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        Pair<View, String> imagePair = Pair.create((View) mImage, "profile");

        Intent i = new Intent(ctx, ItemDetailActivity.class);
        i.putExtra("Title", header);
        ctx.startActivity(i);
    }

    public void setImage(final Context ctx, final int position, final Integer[] images) {
        mImage.setImageResource(images[position]);
    }

    public void setItemText(final String text, final Context ctx) {

        mCTX = ctx;
        mTitle = text;
        mItemTextView.setText(text);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickerListener(v, ctx, mTitle);
            }
        });


    }


    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1
    };



}