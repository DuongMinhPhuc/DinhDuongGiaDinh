package phucduongcom.dinhduonggiadinh.layout_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import phucduongcom.dinhduonggiadinh.R;
import phucduongcom.dinhduonggiadinh.adapter.CustomAdapterLayout3;
import phucduongcom.dinhduonggiadinh.model.NhomThucPham;
import phucduongcom.dinhduonggiadinh.model.User;

/**
 * Created by phucd on 10/21/2017.
 */

public class Layout3 extends AppCompatActivity {
    private ImageButton btnCallDuongBot;
    private ImageButton btnCallChatBeo;
    private ImageButton btnCallVitamin;
    private ImageButton btnCallProtein;
    private int count;
    private Button btnback;
    private Button btnnext;
    private ListView lvNhomThucPham;
    private List<NhomThucPham> ntpList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        setDataByExtras();
        btnback = (Button) findViewById(R.id.btn_back_layout3);
        btnnext = (Button) findViewById(R.id.btn_next_layout3);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Layout3.this, Layout1.class);
                startActivity(intent);
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Layout3.this, Layout4.class);
                startActivity(intent);
            }
        });
        lvNhomThucPham = (ListView) findViewById(R.id.lv_layout3);
        customlv();
    }
    public void setDataByExtras(){
        Intent intent = getIntent();
        count = intent.getIntExtra(Layout1.COUNT,0);
    }
    public void customlv(){
        ArrayList<NhomThucPham> arrContact = new ArrayList<>();

        NhomThucPham luongthuc = new NhomThucPham("Các loại lương thực",R.drawable.duongbot);
        arrContact.add(luongthuc);
        NhomThucPham rauxanh = new NhomThucPham("Các loại rau xanh",R.drawable.rauxanh);
        arrContact.add(rauxanh);
        NhomThucPham quachin = new NhomThucPham("Các Loại quả chín",R.drawable.cuqua);
        arrContact.add(quachin);
        NhomThucPham dam = new NhomThucPham("Thực phẩm chứa đạm",R.drawable.dam);
        arrContact.add(dam);
        NhomThucPham daumo = new NhomThucPham("Thực phẩm chứa dầu/mỡ",R.drawable.daumo);
        arrContact.add(daumo);

        CustomAdapterLayout3 customAdaper = new CustomAdapterLayout3(this,R.layout.custom_listview_layout3,arrContact);
        lvNhomThucPham.setAdapter(customAdaper);

    }
}
