package jing.app.service.intent;

import java.util.ArrayList;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;

public class ReportService extends IntentService {

	public ReportService() {
		super("ReportService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		ArrayList<Parcelable> ms = intent.getParcelableArrayListExtra("messenger");
		if (ms != null && ms.size() > 0) {
		    Messenger m = (Messenger) ms.get(0);
		    Message msg = Message.obtain();
		    try {
				m.send(msg);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

}
