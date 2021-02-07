package com.xm6leefun.ocpayprogram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xm6leefun.ocpayprogram.R;
import com.xm6leefun.ocpayprogram.bean.AddressBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * @Description: 地址本适配器
 * @Author: ljj
 * @CreateDate: 2021/2/7 16:18
 */
public class AddressAdapter extends ArrayAdapter<AddressBean> {

    private Context context;
    private int resourceId;
    private boolean showDelete;
    private List<AddressBean> addressBeanList = new ArrayList<>();

    public AddressAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<AddressBean> objects, boolean showDelete) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.resourceId = textViewResourceId;
        this.addressBeanList = objects;
        this.showDelete = showDelete;
    }
    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent){
        AddressBean addressBean = getItem(position); //获取当前项的AddressBean实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.tv_name=view.findViewById(R.id.tv_name);
            viewHolder.tv_address=view.findViewById(R.id.tv_address);
            viewHolder.tv_delete=view.findViewById(R.id.tv_delete);

            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }

        // 获取控件实例，并调用set...方法使其显示出来
        viewHolder.tv_name.setText(addressBean.getName());
        viewHolder.tv_address.setText(addressBean.getAddress());
        viewHolder.tv_delete.setVisibility(showDelete ? View.VISIBLE : View.GONE);
        viewHolder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDeleteListener.onDelete(position);
            }
        });
        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView tv_name;
        TextView tv_address;
        TextView tv_delete;
    }

    public interface OnClickDeleteListener {
        void onDelete(int position);
    }
    public static OnClickDeleteListener onClickDeleteListener;
    public static void setOnClickDeleteListener(OnClickDeleteListener clickDeleteListener) {
        onClickDeleteListener = clickDeleteListener;
    }
}
