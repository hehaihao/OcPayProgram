package com.xm6leefun.ocpayprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description:每周-节点基金（零钱合并和转打款号）
 * @Author: ljj
 * @CreateDate: 2021/2/7 11:39
 */
public class WeekNodeFundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_node_fund);

        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("每周-节点基金\n（零钱合并和转打款号）");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    /**
     * 开始合并
     * @param view
     */
    public void beginMerge(View view) {
        Toast.makeText(this, "开始合并", Toast.LENGTH_SHORT).show();
    }

    /**
     * 发起上链
     * @param view
     */
    public void launchOnChainSec(View view) {
        Toast.makeText(this, "发起上链", Toast.LENGTH_SHORT).show();
    }
}
