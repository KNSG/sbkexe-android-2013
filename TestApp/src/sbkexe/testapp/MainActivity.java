package sbkexe.testapp;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/* *** remove this line ***

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

*** remove this line ***/


public class MainActivity extends Activity  
/* remove this line
 implements LocationListener 
 * remove this line */

{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
/* *** remove this line ***

	// //////////////////////////////////////////////////////////////
	// additional implementation 
	// //////////////////////////////////////////////////////////////
	private BufferedWriter   bw       = null;
	private File             datafile = null;
	private LocationManager  manager  = null;
	
	@Override
	protected void onStart() {
		super.onStart();
		// open export file
		try {
			File dir = new File(Environment.getExternalStorageDirectory(),"sbkexe");
			if( !dir.exists() ) { dir.mkdir(); }
			
			String filename = DateUtils.formatDate(new Date(),"yyyyMMdd") + ".csv";
			datafile = new File(dir,filename);   
			bw       = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(datafile,true)));
			
			TextView.class.cast(findViewById(R.id.filepathvalue)).setText(datafile.getAbsolutePath());
		}
		catch(IOException exp) { Log.e("onStart()","exception",exp); }
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		// location manager for GPS functionality
		manager = LocationManager.class.cast( this.getSystemService(Context.LOCATION_SERVICE) );
		manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5*60*1000L,100,this);	// GPS, 5 min interval, 100 m
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		try {
			if( bw != null ) { bw.close(); bw = null; }
		}
		catch(IOException exp) { Log.e("onStart()","exception",exp); }
		manager.removeUpdates(this);
	}

* *** remove this line *** */

/* *** remove this line *** 
 

	protected void updateView(String time,double lon,double lat) {
		TextView.class.cast(findViewById(R.id.timevalue)).setText(time);
		TextView.class.cast(findViewById(R.id.longitudevalue)).setText(String.valueOf(lon));
		TextView.class.cast(findViewById(R.id.latitudevalue)).setText(String.valueOf(lat));
	}
	
	// listener methods
	@Override
	public void onLocationChanged(Location location) {
		if( location != null ) { 
			Date   time = new Date(location.getTime());	// GPS time
			double lat  = location.getLatitude();		// latitude
			double lon  = location.getLongitude();		// longitude
			String date_str = DateUtils.formatDate(time, "yyyy-MM-dd HH:mm:ss.SSS");
			
			updateView(date_str,lon,lat);	// update view
			try {
				if( bw != null ) { 
					bw.write(String.format("%s,%f,%f",date_str,lon,lat)); 
					bw.newLine();
				}
			}
			catch(IOException exp) { Log.e("onLocationChanged","exception",exp); }
		}
	}
	
	@Override
	public void onStatusChanged(String provider,int status,Bundle extras){
		// nothing to do; this method will be called when the provider status changes
		// status values are OUT_OF_SERVICE, TEMPORARY_UNAVAILABLE, AVAILABLE
	}

	@Override
	public void onProviderEnabled(String provider) {
		// nothing to do; this method will be called when GPS or WiFi positioning functionality is enabled
	}
	
	@Override
	public void onProviderDisabled(String provider) {
		// nothing to do; this method will be called when GPS or WiFi positioning functionality is disabled
	}
	
** remove this line ********** */
}
