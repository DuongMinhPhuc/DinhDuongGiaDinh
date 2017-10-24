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

public class layout3 extends AppCompatActivity{
    private ImageButton btnCallDuongBot;
    private ImageButton btnCallChatBeo;
    private ImageButton btnCallVitamin;
    private ImageButton btnCallProtein;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
    }
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.imgbtn_chat_beo: {
                Intent intent = new Intent(layout3.this,ChatBeo.class);
                startActivity(intent);
                break;
            }
            case R.id.imgbtn_duong_bot: {
                Intent intent = new Intent(layout3.this,DuongBot.class);
                startActivity(intent);
                break;
            }
            case R.id.imgbtn_protein: {
                Intent intent = new Intent(layout3.this,Protein.class);
                startActivity(intent);
                break;
            }
            case R.id.imgbtn_vitamin: {
                Intent intent = new Intent(layout3.this,Vitamin.class);
                startActivity(intent);
                break;
            }
        }
    }


}
