package hidetut.fix.j2gliteware.camper1.helpers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hidetut.fix.j2gliteware.camper1.R;
import hidetut.fix.j2gliteware.camper1.dashboard.CoolingListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.EnergyListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.GasListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.LightingListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.SoilListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.SoundListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.TemperatureListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.TimeListActivity;
import hidetut.fix.j2gliteware.camper1.dashboard.WaterListActivity;

public class GridRecyclerItemViewHolder extends RecyclerView.ViewHolder{

    private final TextView mGrid_item_label;
    private String mTextItem;
    private View mViewHeld;
    private ImageView mImage;

    public GridRecyclerItemViewHolder(final View parent, TextView gridItemTextView, ImageView image) {
        super(parent);
        mGrid_item_label = gridItemTextView;
        mImage = image;
    }
    public static GridRecyclerItemViewHolder newInstance(View parent) {
        TextView gridItemTextView = (TextView) parent.findViewById(R.id.grid_item_label);
        ImageView image = (ImageView) parent.findViewById(R.id.grid_item_image);
        return new GridRecyclerItemViewHolder(parent, gridItemTextView, image);
    }
    public void setItemText(final Context ctx, final CharSequence text) {
        mTextItem = text + "";
        mGrid_item_label.setText(text);
    }
    public void setImage(final Context ctx, final int position) {

        mImage.setImageResource(mThumbIds[position]);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        Intent i = new Intent(ctx, TemperatureListActivity.class);
                        ctx.startActivity(i);
                        return;
                    case 1:
                        Intent i2 = new Intent(ctx, LightingListActivity.class);
                        ctx.startActivity(i2);
                        return;
                    case 2:
                        Intent i3 = new Intent(ctx, SoilListActivity.class);
                        ctx.startActivity(i3);
                        return;
                    case 3:
                        Intent i4 = new Intent(ctx, GasListActivity.class);
                        ctx.startActivity(i4);
                        return;
                    case 4:
                        Intent i5 = new Intent(ctx, SoundListActivity.class);
                        ctx.startActivity(i5);
                        return;
                    case 5:
                        Intent i6 = new Intent(ctx, TimeListActivity.class);
                        ctx.startActivity(i6);
                        return;
                    case 6:
                        Intent i7 = new Intent(ctx, WaterListActivity.class);
                        ctx.startActivity(i7);
                        return;
                    case 7:
                        Intent i8 = new Intent(ctx, EnergyListActivity.class);
                        ctx.startActivity(i8);
                        return;
                    case 8:
                        Intent i9 = new Intent(ctx, CoolingListActivity.class);
                        ctx.startActivity(i9);
                    default:

                }


            }
        });
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.therm,
            R.drawable.bulb,
            R.drawable.soil,
            R.drawable.flame,
            R.drawable.mega,
            R.drawable.stop,
            R.drawable.water,
            R.drawable.sun,
            R.drawable.fan
    };

}
