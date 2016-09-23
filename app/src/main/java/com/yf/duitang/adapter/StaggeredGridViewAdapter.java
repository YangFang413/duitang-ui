package com.yf.duitang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yf.duitang.R;
import com.yf.duitang.model.StaggeredGridViewItem;
import com.yf.duitang.personalui.ScaleImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/9/19.
 */
public class StaggeredGridViewAdapter extends ArrayAdapter<StaggeredGridViewItem> {

    private int resourceId;
    private Context context;

    public StaggeredGridViewAdapter(Context context, int resource, List<StaggeredGridViewItem> objects) {
        super(context, resource, objects);
        this.context = context;
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        StaggeredGridViewItem item = getItem(position);
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.staggeredImageView.setImageResource(item.getImageResource());
        viewHolder.imageDescription.setText(item.getImageDescription());
        viewHolder.imageCollectionNumber.setText(" " + String.valueOf(item.getCollectionNumber()));
        viewHolder.userImageView.setImageResource(item.getUserImageResource());
        viewHolder.userName.setText(item.getUserName());
        viewHolder.collectionName.setText("收藏到 " + item.getCollectionName());
        return view;
    }

    class ViewHolder{
        @Bind(R.id.staggeredgridview_image)
        ScaleImageView staggeredImageView;

        @Bind(R.id.staggeredgridview_image_description)
        TextView imageDescription;

        @Bind(R.id.staggeredgridview_image_collection)
        TextView imageCollectionNumber;

        @Bind(R.id.user_image_small)
        CircleImageView userImageView;

        @Bind(R.id.user_name)
        TextView userName;

        @Bind(R.id.collection_name)
        TextView collectionName;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

    }
}
