package com.wxf.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wxf.bean.InfoBean;
import com.wxf.crud.MySqliteOpenHelper;

public class InfoDao {
	private MySqliteOpenHelper mySqliteOpenHelper;

	public InfoDao(Context context) {
		mySqliteOpenHelper = new MySqliteOpenHelper(context);
	}

	public void add(InfoBean bean) {

		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		db.execSQL("insert into info(name,phone) values(?,?)", new Object[] {
				bean.name, bean.phone });
		db.close();
	}

	public void del(String name) {
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		db.execSQL("delete from info where name=?", new Object[] { name });
		db.close();
	}

	public void update(InfoBean bean) {
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		db.execSQL("update info set phone=?where name=?", new Object[] {
				bean.phone, bean.name });
		db.close();
	}

	public void query(String name) {
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select _id,name,phone from info where name=?",
				new String[] { name });
		if (null != cursor && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				int id = cursor.getInt(0);
				String nameStr = cursor.getString(1);
				String phoneStr = cursor.getString(2);
System.out.println("id"+id+"name"+nameStr+"phone"+phoneStr);
			}
			cursor.close();
		}
		db.close();
	}
}
