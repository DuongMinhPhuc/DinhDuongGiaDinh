package phucduongcom.dinhduonggiadinh.layout_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import phucduongcom.dinhduonggiadinh.R;

/**
 * Created by phucd on 10/21/2017.
 */

public class ChatBeo extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_beo);
        Button btnBack = (Button) findViewById(R.id.btn_back_chat_beo);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatBeo.this, layout3.class);
                startActivity(intent);
            }
        });
    }
}


