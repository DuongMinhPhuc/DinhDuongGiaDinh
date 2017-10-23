package phucduongcom.dinhduonggiadinh.layout_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phucduongcom.dinhduonggiadinh.R;

/**
 * Created by phucd on 10/21/2017.
 */

public class Vitamin extends AppCompatActivity {
    private Button btnBackVitamin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitamin_va_khoang_chat);
        Button btnBack = (Button) findViewById(R.id.btn_back_vitamin);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vitamin.this, layout3.class);
                startActivity(intent);
            }
        });
    }

}
