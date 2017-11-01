package phucduongcom.dinhduonggiadinh.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import phucduongcom.dinhduonggiadinh.R;
import phucduongcom.dinhduonggiadinh.model.NhomThucPham;
import phucduongcom.dinhduonggiadinh.model.User;

/**
 * Created by phucd on 11/1/2017.
 */

public class CustomAdapterLayout3 extends ArrayAdapter<NhomThucPham> {
    private Context context;
    private int resoure;
    private List<NhomThucPham> listNhomThucPham;
    public CustomAdapterLayout3(@NonNull Context context, @LayoutRes int resource, @NonNull List<NhomThucPham> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resoure=resource;
        this.listNhomThucPham=objects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview_layout3, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NhomThucPham ntp = listNhomThucPham.get(position);
        viewHolder.img.setImageResource(ntp.getIDimage());
        viewHolder.tvName.setText(ntp.getName());
        return convertView;
    }

    public class ViewHolder {
        TextView tvName;
        ImageView img;

    }
}

