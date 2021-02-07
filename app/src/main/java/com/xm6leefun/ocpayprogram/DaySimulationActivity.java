package com.xm6leefun.ocpayprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.onlychain.signsdk.wallet.base.ApiConfig;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description:每日模拟
 * @Author: hhh
 * @CreateDate: 2021/2/7 9:44
 */
public class DaySimulationActivity extends AppCompatActivity {

    private TextView tv_address_from, tv_address_from_sec, tv_address_to, tv_address_to_sec, tv_address_to_thd,
            tv_value, tv_value_sec, tv_value_thd, tv_usable_num, tv_usable_num_sec, tv_status, tv_status_sec;
    private Button btn_launch_on_chain, btn_launch_on_chain_sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_simulation);
        tv_address_from = findViewById(R.id.tv_address_from);
        tv_address_from_sec = findViewById(R.id.tv_address_from_sec);
        tv_address_to = findViewById(R.id.tv_address_to);
        tv_address_to_sec = findViewById(R.id.tv_address_to_sec);
        tv_address_to_thd = findViewById(R.id.tv_address_to_thd);
        tv_value = findViewById(R.id.tv_value);
        tv_value_sec = findViewById(R.id.tv_value_sec);
        tv_value_thd = findViewById(R.id.tv_value_thd);
        tv_usable_num = findViewById(R.id.tv_usable_num);
        tv_usable_num_sec = findViewById(R.id.tv_usable_num_sec);
        tv_status = findViewById(R.id.tv_status);
        btn_launch_on_chain = findViewById(R.id.btn_launch_on_chain);
        btn_launch_on_chain_sec = findViewById(R.id.btn_launch_on_chain_sec);

        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("每日 - 模拟");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 发起上链
     * @param view
     */
    public void launchOnChain(View view) {
        Toast.makeText(this, "发起上链", Toast.LENGTH_LONG).show();
    }

    /**
     * 发起上链2
     * @param view
     */
    public void launchOnChainSec(View view) {
        Toast.makeText(this, "发起上链2", Toast.LENGTH_LONG).show();
    }
}
