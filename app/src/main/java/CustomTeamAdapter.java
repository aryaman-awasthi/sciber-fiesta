import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import in.co.stitchup.sf19.R;

public class CustomTeamAdapter extends ArrayAdapter<String>
{
    private final Context context;
    private final String[] name;
    private final String[] post;
    private final String[] image;

    public CustomTeamAdapter(Context context, String[] name,String[] post,String[] image)
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

        propic.setImageResource(Integer.parseInt(image[position]));
        post1.setText(post[position]);
        name1.setText(name[position]);
        return view;
    }
}
