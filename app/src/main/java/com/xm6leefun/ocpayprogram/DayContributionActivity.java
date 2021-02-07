package com.xm6leefun.ocpayprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description:每日贡献
 * @Author: ljj
 * @CreateDate: 2021/2/7 11:15
 */
public class DayContributionActivity extends AppCompatActivity {

    private TextView tv_address_from, tv_address_to, tv_usable_num, tv_status;
    private EditText ed_value;
    private Button btn_launch_on_chain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_contribution);
        tv_address_from = findViewById(R.id.tv_address_from);
        tv_address_to = findViewById(R.id.tv_address_to);
        ed_value = findViewById(R.id.ed_value);
        tv_usable_num = findViewById(R.id.tv_usable_num);
        tv_status = findViewById(R.id.tv_status);
        btn_launch_on_chain = findViewById(R.id.btn_launch_on_chain);

        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("每日 - 贡献");
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
}
