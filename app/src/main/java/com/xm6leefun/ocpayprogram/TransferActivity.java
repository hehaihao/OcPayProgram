package com.xm6leefun.ocpayprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description:其它或自定义转账
 * @Author: ljj
 * @CreateDate: 2021/2/7 11:15
 */
public class TransferActivity extends AppCompatActivity {

    public static final String SEND_TYPE = "sendType";
    public static final String MARKET_SEND = "市值send";
    public static final String MINE_SEND = "矿机send";
    public static final String ECOLOGY_SEND = "生态小号send";

    private TextView tv_address_market, tv_address_mine, tv_address_ecology;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        tv_address_market = findViewById(R.id.tv_address_market);
        tv_address_mine = findViewById(R.id.tv_address_mine);
        tv_address_ecology = findViewById(R.id.tv_address_ecology);

        TextView base_tv_title = findViewById(R.id.base_tv_title);
        ImageView base_iv_back = findViewById(R.id.base_iv_back);
        base_tv_title.setText("其它或自定义转账");
        base_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 市值send
     * @param view
     */
    public void marketSend(View view) {
        Intent intent = new Intent(this, SendActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(SEND_TYPE, MARKET_SEND);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 矿机send
     * @param view
     */
    public void mineSend(View view) {
        Intent intent = new Intent(this, SendActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(SEND_TYPE, MINE_SEND);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 生态小号send
     * @param view
     */
    public void ecologySend(View view) {
        Intent intent = new Intent(this, SendActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(SEND_TYPE, ECOLOGY_SEND);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
