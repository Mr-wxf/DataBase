package com.wxf.crud;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.wxf.bean.InfoBean;
import com.wxf.crud.R;
import com.wxf.dao.InfoDao;

public class MainActivity extends Activity implements OnClickListener {
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		findViewById(R.id.bt_add).setOnClickListener(this);
		findViewById(R.id.bt_del).setOnClickListener(this);
		findViewById(R.id.bt_update).setOnClickListener(this);
		findViewById(R.id.bt_query).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		InfoDao infoDao = new InfoDao(mContext);
		switch (v.getId()) {
		case R.id.bt_add:
			InfoBean bean = new InfoBean();
			bean.name = "ww";
			bean.phone = 111;
			infoDao.add(bean);

			break;
		case R.id.bt_del:
			InfoBean bean1 = new InfoBean();
			bean1.name = "ww";
			
			infoDao.add(bean1);

			break;
		case R.id.bt_update:
			InfoBean bean3 = new InfoBean();
			bean3.name = "ww";
			bean3.phone = 4444;
			infoDao.add(bean3);

			break;
		case R.id.bt_query:
			
			infoDao.query("ww");

			break;

		default:
			break;
		}

	}

}
