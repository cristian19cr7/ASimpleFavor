package com.example.newsimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.newsimple.TaskDBschema.*;

import java.util.ArrayList;
import java.util.List;

public class TaskDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "taskllist.db";
    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase mDatabase;

    public TaskDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.mDatabase = db;

        final String SQL_CREATE_TASK_TABLE = "CREATE TABLE " +
                TaskTable.TABLE_NAME + " (" +
                TaskTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskTable.HEADER + " TEXT NOT NULL, " +
                TaskTable.DESCRIPTION + " TEXT NOT NULL, " +
                TaskTable.DATE + " TEXT NOT NULL, " +
                TaskTable.START_TIME  + " TEXT NOT NULL, " +
                TaskTable.END_TIME + " TEXT, " +
                TaskTable.ADDRESS_LAT + " DOUBLE NOT NULL, " +
                TaskTable.ADDRESS_LONG + " DOUBLE NOT NULL, " +
                TaskTable.PAYOUT + " INTEGER NOT NULL, " +
                TaskTable.CONTACT_EMAIL + " TEXT NOT NULL, " +
                TaskTable.CONTACT_PHONE + " TEXT," +
                TaskTable.TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        db.execSQL(SQL_CREATE_TASK_TABLE);
        initDb();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskTable.TABLE_NAME);
        onCreate(db);
    }
    private void initDb(){
        TaskCard task = new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234");
        addTask(task);
    }

    public void addTask(TaskCard task){
        mDatabase = getWritableDatabase();
        insertTask(task);
    }

    private void insertTask(TaskCard task){
        ContentValues cv = new ContentValues();
        cv.put(TaskTable.HEADER, task.getTaskHeader());
        cv.put(TaskTable.DESCRIPTION, task.getTaskDesc());
        cv.put(TaskTable.DATE,task.getTaskDate());
        cv.put(TaskTable.START_TIME,task.getTaskStartTime());
        cv.put(TaskTable.END_TIME, task.getTaskEndTime());
        cv.put(TaskTable.ADDRESS_LAT, task.getTaskAddressLat());
        cv.put(TaskTable.ADDRESS_LONG, task.getTaskAddressLong());
        cv.put(TaskTable.PAYOUT, task.getTaskBudget());
        cv.put(TaskTable.CONTACT_EMAIL, task.getTaskEmail());
        cv.put(TaskTable.CONTACT_PHONE, task.getPhone());
        mDatabase.insert(TaskTable.TABLE_NAME, null, cv);
    }

    public List<TaskCard> getListofTask() {
        List<TaskCard> taskCardList = new ArrayList<>();
        mDatabase = getReadableDatabase();
        Cursor c = mDatabase.rawQuery("SELECT * FROM " + TaskTable.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                TaskCard t = new TaskCard();
                t.setTaskHeader(c.getString(c.getColumnIndex(TaskTable.HEADER)));
                t.setTaskDesc(c.getString(c.getColumnIndex(TaskTable.DESCRIPTION)));
                t.setTaskDate(c.getString(c.getColumnIndex(TaskTable.DATE)));
                t.setTaskStartTime(c.getString(c.getColumnIndex(TaskTable.START_TIME)));
                t.setTaskEndTime(c.getString(c.getColumnIndex(TaskTable.END_TIME)));
                t.setTaskAddressLat(c.getDouble(c.getColumnIndex(TaskTable.ADDRESS_LAT)));
                t.setTaskAddressLong(c.getDouble(c.getColumnIndex(TaskTable.ADDRESS_LONG)));
                t.setTaskBudget(c.getInt(c.getColumnIndex(TaskTable.PAYOUT)));
                t.setTaskEmail(c.getString(c.getColumnIndex(TaskTable.CONTACT_EMAIL)));
                t.setTaskPhone(c.getString(c.getColumnIndex(TaskTable.CONTACT_PHONE)));
                taskCardList.add(t);
            } while (c.moveToNext());
        }

        c.close();
        return taskCardList;
    }
}
