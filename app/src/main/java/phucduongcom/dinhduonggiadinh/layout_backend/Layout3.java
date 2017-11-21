package phucduongcom.dinhduonggiadinh.layout_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

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
    private NhomThucPham nhomThucPham;
    private float canLuongThuc;
    private float canRauXanh;
    private float canQuaChin;
    private float canDam;
    private float canDauMo;

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
        lvNhomThucPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                nhomThucPham = ntpList.get(position);
                int id = nhomThucPham.getIDimage();
                switch (id){
                    case R.drawable.duongbot:
                    { Intent intent = new Intent(Layout3.this, LuongThuc.class);
                        startActivity(intent);
                        break;}
                    case R.drawable.rauxanh:
                    {Intent intent = new Intent(Layout3.this, RauXanh.class);
                        startActivity(intent);
                        break;}
                    case R.drawable.cuqua:
                    {Intent intent = new Intent(Layout3.this, QuaChin.class);
                        startActivity(intent);
                        break;}
                    case R.drawable.dam:
                    {Intent intent = new Intent(Layout3.this, Dam.class);
                        startActivity(intent);
                        break;}
                    case R.drawable.daumo:
                    {Intent intent = new Intent(Layout3.this, DauMo.class);
                        startActivity(intent);
                        break;}
                }
            }
        });

    }
    public void setDataByExtras(){
        Intent intent = getIntent();
        count = intent.getIntExtra(Layout1.COUNT,0);
        //chứa số lượng người count
        canLuongThuc = (float) (count*0.4);
        canRauXanh = (float) (count * 0.33);
        canDam = (float) (count * 0.2);
        canDauMo = (float) (count * 0.02);
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
        ntpList=arrContact;
    }
}
