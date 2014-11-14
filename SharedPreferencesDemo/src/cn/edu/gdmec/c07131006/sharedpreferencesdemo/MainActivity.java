package cn.edu.gdmec.c07131006.sharedpreferencesdemo;

import cn.edu.gdmec.c07131006.sharepreferencesdemo.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText etname,etage,etheight;
	private final static String PREFENCES_NAME = "personal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText) findViewById(R.id.editText1);
        etage = (EditText) findViewById(R.id.editText2);
        etheight = (EditText) findViewById(R.id.editText3);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Read(View v){
    	SharedPreferences myPre = getSharedPreferences(PREFENCES_NAME,Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);;
    	String name = myPre.getString("name", "cxp");
    	int age = myPre.getInt("age", 20);
    	float height = myPre.getFloat("height", 1.73f);
    	etname.setText(name);
    	etage.setText(String.valueOf(age));
    	etheight.setText(String.valueOf(height));
    }
    
    
    public void Wrieat(View v){
    	SharedPreferences myPre = getSharedPreferences(PREFENCES_NAME,Context.MODE_WORLD_READABLE+Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
    	SharedPreferences.Editor myEditor = myPre.edit();
    	myEditor.putString("name", etname.getText().toString());
    	myEditor.putInt("age", Integer.parseInt(etage.getText().toString()));
    	myEditor.putFloat("etheight", Float.parseFloat(etheight.getText().toString()));
    	myEditor.commit();
    }
    
}
