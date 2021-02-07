package com.xm6leefun.ocpayprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onlychain.signsdk.wallet.base.ApiConfig;

public class MainActivity extends AppCompatActivity {

    private TextView crr_node_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crr_node_text = findViewById(R.id.crr_node_text);
        crr_node_text.setText("当前节点："+ApiConfig.IPs);
    }

    /**
     * 输入keystore密码
     * @param view
     */
    public void inputPwd(View view) {

    }

    /**
     * 每日-模拟
     * @param view
     */
    public void daySimulation(View view) {
        startActivity(new Intent(this,DaySimulationActivity.class));
    }

    /**
     * 每周-人工预购（2基8销）
     * @param view
     */
    public void weekAdvancePurchase(View view) {
        startActivity(new Intent(this,WeekAdvancePurchaseActivity.class));
    }

    /**
     * 每日-分配
     * @param view
     */
    public void dayDistribution(View view) {
        startActivity(new Intent(this,DayDistributionActivity.class));
    }

    /**
     * 每周-节点基金（零钱合并和转打款号）
     * @param view
     */
    public void weekNodeFund(View view) {
        startActivity(new Intent(this,WeekNodeFundActivity.class));
    }

    /**
     * 每日-贡献
     * @param view
     */
    public void dayContribution(View view) {
        startActivity(new Intent(this, DayContributionActivity.class));
    }

    /**
     * 其它或自定义转账
     * @param view
     */
    public void other(View view) {

    }

    /**
     * 设置节点
     * @param view
     */
    public void setNode(View view) {

    }
}