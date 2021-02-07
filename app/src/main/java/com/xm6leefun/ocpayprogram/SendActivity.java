package com.xm6leefun.ocpayprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xm6leefun.ocpayprogram.bean.AddressBean;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description: 市值send
 * @Author: ljj
 * @CreateDate: 2021/2/7 14:52
 */
public class SendActivity extends AppCompatActivity {

    private EditText et_value, et_address;
    private TextView tv_status, base_tv_title;
    private Button btn_choose_address, btn_launch_on_chain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        et_value = findViewById(R.id.et_value);
        et_address = findViewById(R.id.et_address);
        tv_status = findViewById(R.id.tv_status);
        btn_choose_address = findViewById(R.id.btn_choose_address);
        btn_launch_on_chain = findViewById(R.id.btn_launch_on_chain);

        initTopBar();
        initData();
    }

    private void initTopBar() {
        base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        TextView base_tv_right = findViewById(R.id.base_tv_right);
        base_tv_right.setVisibility(View.VISIBLE);
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        base_tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 跳转地址本
                chooseAddress(true);
            }
        });
        btn_choose_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 跳转地址本
                chooseAddress(false);
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String title = bundle.getString(TransferActivity.SEND_TYPE);
                base_tv_title.setText(title + "");
            }
        }

    }

    /**
     * 选择地址
     * @param showDelete
     */
    public void chooseAddress(boolean showDelete) {
        // 跳转地址本
        AddressListActivity.setOnClickBackAddressListener(new AddressListActivity.OnClickBackAddressListener() {
            @Override
            public void backAddress(AddressBean addressBean) {
                if (addressBean != null) {
                    et_address.setText(addressBean.getAddress() + "");
                }
            }
        });
        Intent intent = new Intent(this, AddressListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("showDelete", showDelete);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 确认上链
     */
    public void launchOnChain(View view) {
        Toast.makeText(this, "发起上链", Toast.LENGTH_SHORT).show();
    }

}
