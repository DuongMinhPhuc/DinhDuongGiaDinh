package phucduongcom.dinhduonggiadinh.layout_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phucduongcom.dinhduonggiadinh.R;

/**
 * Created by phucd on 10/24/2017.
 */

public class QuaChin extends AppCompatActivity {
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qua_chin);
        Button btnBack = (Button) findViewById(R.id.btn_back_qua_chin);
        btnBack.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent intent = new Intent(QuaChin.this, Layout3.class);
        startActivity(intent);
        }
        });
        }
        }