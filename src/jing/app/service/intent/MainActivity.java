package jing.app.service.intent;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private static final String MESSENGERS = "messenger";
	InnerHandler mH = new InnerHandler();
	Button mBegin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBegin = (Button) this.findViewById(R.id.begin);
		mBegin.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	class InnerHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			Toast.makeText(getApplicationContext(), "This is the service.", Toast.LENGTH_SHORT).show();
			super.handleMessage(msg);
		}
		
	}

	@Override
	public void onClick(View v) {
		Messenger m = new Messenger(mH);
		ArrayList<Messenger> list = new ArrayList<Messenger>();
		list.add(m);
		Intent intent = new Intent(getApplicationContext(), ReportService.class);
		intent.putParcelableArrayListExtra(MESSENGERS, list);
		startService(intent);
	}

}
