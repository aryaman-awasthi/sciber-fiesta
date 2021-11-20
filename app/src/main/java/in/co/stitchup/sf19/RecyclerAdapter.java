package in.co.stitchup.sf19;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends ArrayAdapter<Texts>
{

    private Activity mContext;
    private List<Texts> list;

    public RecyclerAdapter(Activity mContext, List<Texts> list) {
        super(mContext, R.layout.layout_recyclerview_item,list);
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_recyclerview_item,null,true);
        TextView tw = (TextView)listViewItem.findViewById(R.id.TextViewHead);
        ImageView im = (ImageView)listViewItem .findViewById(R.id.imageView);
        Texts texts = list.get(position);
        tw.setText(texts.getHead());
        Picasso.get().load(list.get(position).getUrl()).into(im);
        return  listViewItem;
    }
}
