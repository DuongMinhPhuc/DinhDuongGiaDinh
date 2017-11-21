package phucduongcom.dinhduonggiadinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import phucduongcom.dinhduonggiadinh.adapter.CustomAdapterLayout1;
import phucduongcom.dinhduonggiadinh.data.DBUsers;
import phucduongcom.dinhduonggiadinh.model.User;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtCount;
    private Button btnLuu;
    private Button btnUpdate;
    private ListView lvTaiKhoan;
    private DBUsers dbUsers;
    private CustomAdapterLayout1 customAdapter;
    private List<User> usersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbUsers = new DBUsers(this);
        initWidget();
        usersList = dbUsers.getAllUsers();
        setAdapter();

        btnLuu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                User user = createUser();
                if (user != null) {
                    dbUsers.addUser(user);
                }
                updateListUsers();
                setAdapter();
            }
        });
    }

    private void initWidget() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtCount = (EditText) findViewById(R.id.edt_count);
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
