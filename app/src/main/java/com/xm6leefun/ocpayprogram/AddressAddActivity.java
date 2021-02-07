package com.xm6leefun.ocpayprogram;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xm6leefun.ocpayprogram.bean.AddressBean;
import com.xm6leefun.ocpayprogram.utils.ConstantsValue;
import com.xm6leefun.ocpayprogram.utils.SharePreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description: 添加地址
 * @Author: ljj
 * @CreateDate: 2021/2/7 14:53
 */
public class AddressAddActivity extends AppCompatActivity {

    private EditText et_name, et_address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_add);
        et_name = findViewById(R.id.et_name);
        et_address = findViewById(R.id.et_address);

        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("添加地址");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 确认保存地址
     * @param view
     */
    public void saveAddress(View view) {
        String addressListJson = SharePreferenceUtil.getString(ConstantsValue.ADDRESS_LIST);
        List<AddressBean> addressBeanList = new ArrayList<>();
        if (!TextUtils.isEmpty(addressListJson)) {  // 取出sp中的json
            JSONArray objects = JSON.parseArray(addressListJson);
            addressBeanList = JSONObject.parseArray(objects.toJSONString(), AddressBean.class);
        }
        AddressBean addressBean = new AddressBean(et_name.getText().toString().trim(), et_address.getText().toString().trim());
        addressBeanList.add(addressBean);
        String addressListStr = JSON.toJSONString(addressBeanList);
        SharePreferenceUtil.setString(ConstantsValue.ADDRESS_LIST, addressListStr);
        Toast.makeText(this, "保存地址成功", Toast.LENGTH_SHORT).show();
        clickAddAddressListener.backAddress(addressBean);
        finish();
    }

    public interface OnClickAddAddressListener {
        void backAddress(AddressBean addressBean);
    }
    public static OnClickAddAddressListener clickAddAddressListener;
    public static void setOnClickAddAddressListener (OnClickAddAddressListener onClickAddAddressListener) {
        clickAddAddressListener = onClickAddAddressListener;
    }
}
