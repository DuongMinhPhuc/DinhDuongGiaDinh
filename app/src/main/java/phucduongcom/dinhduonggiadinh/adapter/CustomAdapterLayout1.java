package phucduongcom.dinhduonggiadinh.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import phucduongcom.dinhduonggiadinh.R;
import phucduongcom.dinhduonggiadinh.model.User;

/**
 * Created by phucd on 10/26/2017.
 */

public class CustomAdapterLayout1 extends ArrayAdapter<User> {
    private Context context;
    private int resoure;
    private List<User> listUsers;

    public CustomAdapterLayout1(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resoure=resource;
        this.listUsers=objects;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_users,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.tvCount = (TextView)convertView.findViewById(R.id.tv_count);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User user = listUsers.get(position);
        viewHolder.tvId.setText(String.valueOf(user.getmID()));
        viewHolder.tvName.setText(user.getmName());
        viewHolder.tvCount.setText(String.valueOf(user.getmCount()));
        return convertView;
    }
    public class ViewHolder{
        private TextView tvId;
        private TextView tvName;
        private TextView tvCount;
    }
}
