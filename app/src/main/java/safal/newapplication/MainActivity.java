package safal.newapplication;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


import java.lang.reflect.Method;

import safal.newapplication.widgets.RobotoLightEditText;

public class MainActivity extends AppCompatActivity {

    public String string;
    public String number;
    Button btn_Test_Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        final RobotoLightEditText txtcallnumber;
        txtcallnumber = (RobotoLightEditText) findViewById(R.id.mobile);
        string = txtcallnumber.getText().toString().trim();//There no work call
        number = "tel:" + string;

        EndCallListener callListener = new EndCallListener();
        TelephonyManager mTM = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        mTM.listen(callListener, PhoneStateListener.LISTEN_CALL_STATE);

        btn_Test_Call = (Button) findViewById(R.id.btn_Test_Call);

        btn_Test_Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    //callIntent.setData(Uri.parse("tel:xxxxxxx")); //This work
                    number = txtcallnumber.getText().toString().trim();
                    number = "tel:" + number;//There work call
                    callIntent.setData(Uri.parse(number));
                    startActivity(callIntent);
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }


            }
        });

    }

    boolean call_end_start = false;

    private class EndCallListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if(TelephonyManager.CALL_STATE_OFFHOOK == state) {
                //wait for phone to go offhook (probably set a boolean flag) so you know your app initiated the call.

                Log.i(TAG, "OffHook");

                try
                {
                    Log.d(TAG,"wait for 5 sec");
                    Thread.sleep(5000);

                    fun_END_Call();
                }
                catch (Exception e)
                {
                    Log.d(TAG,"Error  ;"+e.getMessage());
                    e.printStackTrace();
                }


            }
        }
    }

    String TAG = "testCall";
    public void fun_END_Call()
    {
        try {
            //String serviceManagerName = "android.os.IServiceManager";
            String serviceManagerName = "android.os.ServiceManager";
            String serviceManagerNativeName = "android.os.ServiceManagerNative";
            String telephonyName = "com.android.internal.telephony.ITelephony";

            Class telephonyClass;
            Class telephonyStubClass;
            Class serviceManagerClass;
            Class serviceManagerNativeClass;

            Method telephonyEndCall;

            Object telephonyObject;
            Object serviceManagerObject;

            telephonyClass = Class.forName(telephonyName);
            telephonyStubClass = telephonyClass.getClasses()[0];
            serviceManagerClass = Class.forName(serviceManagerName);
            serviceManagerNativeClass = Class.forName(serviceManagerNativeName);

            Method getService = serviceManagerClass.getMethod("getService", String.class);

            Method tempInterfaceMethod = serviceManagerNativeClass.getMethod("asInterface", IBinder.class);

            Binder tmpBinder = new Binder();
            tmpBinder.attachInterface(null, "fake");

            serviceManagerObject = tempInterfaceMethod.invoke(null, tmpBinder);
            IBinder retbinder = (IBinder) getService.invoke(serviceManagerObject, "phone");
            Method serviceMethod = telephonyStubClass.getMethod("asInterface", IBinder.class);

            telephonyObject = serviceMethod.invoke(null, retbinder);
            telephonyEndCall = telephonyClass.getMethod("endCall");
            telephonyEndCall.invoke(telephonyObject);
            Log.v("VoiceCall", "Call End Complete.");


        } catch (Exception e) {
            e.printStackTrace();
            Log.e("VoiceCall", "FATAL ERROR: could not connect to telephony subsystem");
            Log.e("VoiceCall", "Exception object: " + e);
        }

    }

    private void initializeFonts() {
        Fonts.ROBOTO_REGULAR = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        Fonts.ROBOT0_LIGHT = Typeface.createFromAsset(getAssets(),"OpenSans-Light.ttf");
        Fonts.ROBOTO_BOLD = Typeface.createFromAsset(getAssets(), "Brandon_bld.otf");
        Fonts.Brandon_Grotesque = Typeface.createFromAsset(getAssets(), "Brandon-Grotesque.ttf");
        Fonts.FONT_ICON = Typeface.createFromAsset(getAssets(),"houseproud-font.ttf");

    }

    public static final class Fonts {
        public static Typeface FONT_ICON;
        public static Typeface ROBOTO_REGULAR;
        public static Typeface ROBOT0_LIGHT;
        public static Typeface ROBOTO_BOLD;
        public static Typeface Brandon_Grotesque;

    }

}
