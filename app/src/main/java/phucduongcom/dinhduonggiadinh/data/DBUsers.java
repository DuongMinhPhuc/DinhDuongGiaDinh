package phucduongcom.dinhduonggiadinh.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import phucduongcom.dinhduonggiadinh.model.User;

/**
 * Created by phucd on 10/25/2017.
 */

public class DBUsers extends SQLiteOpenHelper {
    private final String TAG = "DBUsers";
    private static final String DATABASE_NAME = "users_manager";
    private static final String TABLE_NAME = "user";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String COUNT = "count";
    private static int VERSION = 1;
    private Context context;
    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            COUNT + " TEXT)";
    public DBUsers(Context context){
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "DBUser: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
    }
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, user.getmName());
        values.put(COUNT, user.getmCount());
        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addStudent Successfuly");
    }
    public List<User> getAllUsers() {
        List<User> listStudent = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setmID(cursor.getInt(0));
                user.setmName(cursor.getString(1)+"");
                user.setmCount(cursor.getInt(2));
                listStudent.add(user);

            } while (cursor.moveToNext());
        }
        db.close();
        return listStudent;
    }
    public int updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,user.getmName());
        contentValues.put(COUNT,user.getmCount());
        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(user.getmID())});
    }
    public int deleteUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[] {String.valueOf(id)});
    }
}
