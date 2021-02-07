package com.xm6leefun.ocpayprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description:每日分配
 * @Author: ljj
 * @CreateDate: 2021/2/7 10:22
 */
public class DayDistributionActivity extends AppCompatActivity {

    private TextView tv_format, tv_goal_total_value, tv_goal_address,
            tv_address_from_static, tv_usable_num_static, tv_status_static,
            tv_address_from_activity, tv_usable_num_activity, tv_status_activity,
            tv_address_from_mine, tv_usable_num_mine, tv_status_mine,
            tv_address_from_dynamic, tv_usable_num_dynamic, tv_status_dynamic;
    private Button btn_on_static, btn_on_activity, btn_on_mine, btn_on_dynamic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_distribution);
        initBaseView();
    }

    private void initBaseView() {
        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("每日 - 模拟");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_format = findViewById(R.id.tv_format);
        tv_goal_total_value = findViewById(R.id.tv_goal_total_value);
        tv_goal_address = findViewById(R.id.tv_goal_address);
        tv_address_from_static = findViewById(R.id.tv_address_from_static);
        tv_usable_num_static = findViewById(R.id.tv_usable_num_static);
        tv_status_static = findViewById(R.id.tv_status_static);
        tv_address_from_activity = findViewById(R.id.tv_address_from_activity);
        tv_usable_num_activity = findViewById(R.id.tv_usable_num_activity);
        tv_status_activity = findViewById(R.id.tv_status_activity);
        tv_address_from_mine = findViewById(R.id.tv_address_from_mine);
        tv_usable_num_mine = findViewById(R.id.tv_usable_num_mine);
        tv_status_mine = findViewById(R.id.tv_status_mine);
        tv_address_from_dynamic = findViewById(R.id.tv_address_from_dynamic);
        tv_usable_num_dynamic = findViewById(R.id.tv_usable_num_dynamic);
        tv_status_dynamic = findViewById(R.id.tv_status_dynamic);
        btn_on_static = findViewById(R.id.btn_on_static);
        btn_on_activity = findViewById(R.id.btn_on_activity);
        btn_on_mine = findViewById(R.id.btn_on_mine);
        btn_on_dynamic = findViewById(R.id.btn_on_dynamic);
    }

    /**
     * 静态
     * @param view
     */
    public void onStatic(View view) {
        Toast.makeText(this, "静态", Toast.LENGTH_SHORT).show();
    }

    /**
     * 活动
     * @param view
     */
    public void onActivity(View view) {
        Toast.makeText(this, "活动", Toast.LENGTH_SHORT).show();
    }

    /**
     * 生态节矿70%
     * @param view
     */
    public void onMine(View view) {
        Toast.makeText(this, "生态节矿70%", Toast.LENGTH_SHORT).show();
    }

    /**
     * 动态
     * @param view
     */
    public void onDynamic(View view) {
        Toast.makeText(this, "动态", Toast.LENGTH_SHORT).show();
    }
}
