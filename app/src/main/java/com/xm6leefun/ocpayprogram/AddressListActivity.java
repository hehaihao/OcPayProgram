package com.xm6leefun.ocpayprogram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xm6leefun.ocpayprogram.adapter.AddressAdapter;
import com.xm6leefun.ocpayprogram.bean.AddressBean;
import com.xm6leefun.ocpayprogram.utils.ConstantsValue;
import com.xm6leefun.ocpayprogram.utils.SharePreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description: 地址本
 * @Author: ljj
 * @CreateDate: 2021/2/7 14:54
 */
public class AddressListActivity extends AppCompatActivity {

    private ListView listView;

    private List<AddressBean> addressBeanList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        listView = findViewById(R.id.list_item);

        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        TextView base_tv_right = findViewById(R.id.base_tv_right);
        base_tv_right.setVisibility(View.VISIBLE);
        base_tv_right.setText("添加");
        base_tv_title.setText("地址本");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        base_tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddressListActivity.this, AddressAddActivity.class));
            }
        });
        AddressAddActivity.setOnClickAddAddressListener(new AddressAddActivity.OnClickAddAddressListener() {
            @Override
            public void backAddress(AddressBean addressBean) {
                if (addressBeanList != null) {
                    addressBeanList.add(addressBean);
                    if (addressAdapter != null) {
                        try {
                            addressAdapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        initData();
    }

    private void initData() {
        String addressListJson = SharePreferenceUtil.getString(ConstantsValue.ADDRESS_LIST);
        if (!TextUtils.isEmpty(addressListJson)) {  // 取出sp中的json
            JSONArray objects = JSON.parseArray(addressListJson);
            Log.e("addressList", "objects: " + objects.toJSONString());
            addressBeanList = JSONObject.parseArray(objects.toJSONString(), AddressBean.class);
            Log.e("addressList", "addressBeanList: " + addressBeanList.get(0).getAddress());
        }

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                boolean showDelete = bundle.getBoolean("showDelete");
                initAdapter(showDelete);  // 转账跳转而来的选择地址不显示删除按钮，添加地址跳转而来显示删除按钮
            }
        }
    }

    AddressAdapter addressAdapter;
    private void initAdapter(boolean showDelete) {
        addressAdapter = new AddressAdapter(AddressListActivity.this,R.layout.item_address, addressBeanList, showDelete);

        // 将适配器上的数据传递给listView
        listView.setAdapter(addressAdapter);

        // 为ListView注册一个监听器，当用户点击了ListView中的任何一个子项时，就会回调onItemClick()方法
        // 在这个方法中可以通过position参数判断出用户点击的是那一个子项
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddressBean addressBean = addressBeanList.get(position);
                clickBackAddressListener.backAddress(addressBean);
                finish();
            }
        });
        AddressAdapter.setOnClickDeleteListener(new AddressAdapter.OnClickDeleteListener() {
            @Override
            public void onDelete(int position) {
                try {
                    addressAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 对缓存进行操作
                deleteAddress(position);
                addressBeanList.remove(position);
            }
        });
    }

    private void deleteAddress(int position) {
        String addressListJson = SharePreferenceUtil.getString(ConstantsValue.ADDRESS_LIST);
        List<AddressBean> addressBeanList = new ArrayList<>();
        if (!TextUtils.isEmpty(addressListJson)) {  // 取出sp中的json
            JSONArray objects = JSON.parseArray(addressListJson);
            addressBeanList = JSONObject.parseArray(objects.toJSONString(), AddressBean.class);
        }
        addressBeanList.remove(position);
        String addressListStr = JSON.toJSONString(addressBeanList);
        SharePreferenceUtil.setString(ConstantsValue.ADDRESS_LIST, addressListStr);

        Toast.makeText(AddressListActivity.this, "删除成功" + addressBeanList.size(), Toast.LENGTH_SHORT).show();
    }

    public interface OnClickBackAddressListener {
        void backAddress(AddressBean address);
    }
    public static OnClickBackAddressListener clickBackAddressListener;
    public static void setOnClickBackAddressListener (OnClickBackAddressListener onClickBackAddressListener) {
        clickBackAddressListener = onClickBackAddressListener;
    }

}
