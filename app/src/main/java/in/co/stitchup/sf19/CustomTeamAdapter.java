package in.co.stitchup.sf19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import in.co.stitchup.sf19.R;

public class CustomTeamAdapter extends ArrayAdapter<String>
{
    private final Context context;
    private final String[] name;
    private final String[] post;
    private final Integer[] image;

    public CustomTeamAdapter(Context context, String[] name,String[] post,Integer[] image)
    {
        super(context, R.layout.team,name);
        this.context=context;
        this.name = name;
        this.image=image;
        this.post=post;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.team,null,true);
        TextView name1 = (TextView)view.findViewById(R.id.Name);
        TextView post1 = (TextView)view.findViewById(R.id.post);
        ImageView propic = (ImageView)view.findViewById(R.id.profile_image);

        Button bt1 = (Button) view.findViewById(R.id.butemail);
        Button bt2 = (Button) view.findViewById(R.id.butcall);
        bt1.setTag(position);
        bt2.setTag(position);

        propic.setImageResource(image[position]);
        post1.setText(post[position]);
        name1.setText(name[position]);
        return view;
    }
}
