package gcm;

import java.io.IOException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class SendGcm {

	
	static String myId="d32TY9wTRy0:APA91bEodnFZOA146LO9U6uwHh5n9kuO_RYRswV3pYUVqE8xu5e9C6FDap4FV7PJn3r4K3ToLnOZplHhLhg_XX7Kn1mRNZFgao0RfnGPpZWCyeeai-AJcF-lPGNRn2nDe1S3jDGF0xgT";
	
	public static void main(String args[]){
		send(myId,"HelloWorld!");
	}
	
	public static void send(String id, String msg){
		String apikey="AIzaSyBrb4X2Y_6y_l43vZZI-Njoohcf7u7bUc4";
		Sender sender = new Sender(apikey);
		Message message = new Message.Builder()
		    .addData("message", msg)
		    .addData("other-parameter", "some value")
		    .build();
		try {
			Result result = sender.send(message, id, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
