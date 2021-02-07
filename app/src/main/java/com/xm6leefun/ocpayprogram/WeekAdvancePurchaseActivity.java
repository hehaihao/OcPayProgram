package com.xm6leefun.ocpayprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description:每周-人工预购（2基8销）
 * @Author: ljj
 * @CreateDate: 2021/2/7 11:31
 */
public class WeekAdvancePurchaseActivity extends AppCompatActivity {

    private TextView tv_address_from, tv_address_to, tv_value, tv_address_to_sec, tv_value_sec, tv_usable_num, tv_status;
    private Button btn_launch_on_chain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_advance_purchase);
        tv_address_from = findViewById(R.id.tv_address_from);
        tv_address_to = findViewById(R.id.tv_address_to);
        tv_value = findViewById(R.id.tv_value);
        tv_address_to_sec = findViewById(R.id.tv_address_to_sec);
        tv_value_sec = findViewById(R.id.tv_value_sec);
        tv_usable_num = findViewById(R.id.tv_usable_num);
        tv_status = findViewById(R.id.tv_status);
        btn_launch_on_chain = findViewById(R.id.btn_launch_on_chain);


        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("每周 - 人工预购\n（2基8销）");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
