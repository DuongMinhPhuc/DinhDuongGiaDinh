package phucduongcom.dinhduonggiadinh.layout_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import phucduongcom.dinhduonggiadinh.R;
import phucduongcom.dinhduonggiadinh.adapter.CustomAdapterLayout1;
import phucduongcom.dinhduonggiadinh.data.DBUsers;
import phucduongcom.dinhduonggiadinh.model.User;

/**
 * Created by phucd on 10/26/2017.
 */

public class Layout1 extends AppCompatActivity {
    private EditText edtName;
    private EditText edtCount;
    private Button btnLuu;
    private Button btnUpdate;
    private ListView lvTaiKhoan;
    private DBUsers dbUsers;
    private CustomAdapterLayout1 customAdapter;
    private List<User> usersList;
    private User user;
    public static final String COUNT = "count";
    public static final String BUNDLE = "bundel";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        dbUsers = new DBUsers(this);
        initWidget();
        usersList = dbUsers.getAllUsers();
        setAdapter();
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                User user = createUser();
                if (user != null) {
                    dbUsers.addUser(user);
                }
                }
                catch(Exception e){
                    Toast.makeText(Layout1.this, "Chưa điền đủ thông tin hoặc điền sai", Toast.LENGTH_SHORT).show();}
                updateListUsers();
                setAdapter();
            }
        });
        lvTaiKhoan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                user = usersList.get(position);
                int count = user.getmCount();
                byExtras(count);
            }
        });
        lvTaiKhoan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                User user = usersList.get(position);
                int result = dbUsers.deleteUser(user.getmID());
                if(result>0){
                    Toast.makeText(Layout1.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListUsers();
                }else{
                    Toast.makeText(Layout1.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    public void byExtras(int count){
        Intent intent = new Intent(Layout1.this, Layout3.class);
        intent.putExtra(COUNT,count);
        startActivity(intent);
    }



    private void initWidget() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtCount = (EditText) findViewById(R.id.edt_count);
        lvTaiKhoan = (ListView) findViewById(R.id.lv_tai_khoan);
        btnLuu = (Button) findViewById(R.id.btn_luu_layou1);
    }
    private void setAdapter() {
        if (customAdapter == null) {
            customAdapter = new CustomAdapterLayout1(this, R.layout.item_list_users, usersList);
            lvTaiKhoan.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            lvTaiKhoan.setSelection(customAdapter.getCount()-1);
        }
    }

    private User createUser() {
        String name = edtName.getText().toString();
        Integer count = Integer.parseInt(edtCount.getText().toString());
        User user = new User(name,count);
        return user;
    }
    public void updateListUsers(){
        usersList.clear();
        usersList.addAll(dbUsers.getAllUsers());
        if(customAdapter!= null){
            customAdapter.notifyDataSetChanged();
        }
    }
}
