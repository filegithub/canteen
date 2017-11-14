package com.gzpzxx.canteen;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.gzpzxx.canteen.smenu.BusinessInformation;
import com.gzpzxx.canteen.smenu.ChooseCity;
import com.gzpzxx.canteen.smenu.ChooseMer;
import com.gzpzxx.canteen.smenu.TwoDimensionalCode;
import com.gzpzxx.canteen.util.NianUtil;
import com.gzpzxx.canteen.util.log;
import com.nian.preferential.R;
import com.zdp.aseo.content.AseoZdpAseo;



public class HomeActivity extends Activity implements OnClickListener{
	private final static String TAG = "HomeActivity";
	
	public static final int REQUEST_CODE_CHOOSE_CITY  = 1;
	
	private Button locationBut, capBut,fireBut,riBut ,xiaochiBut,
	    jiangzheBut,chacanBut,zizhuBut,spaBut,shoushenBut;
	private EditText searchEdit;
	private Gallery  showPic;
	private SharedPreferences shared;
	private int data[] = {R.drawable.test1,R.drawable.test2,R.drawable.test3,
			R.drawable.test4,R.drawable.test5,R.drawable.test6};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.home);
		initResourceRefs();
		initSettings();
	}
	
    private void initResourceRefs(){
    	
    	locationBut = (Button) findViewById(R.id.home_location_button);
    	capBut = (Button) findViewById(R.id.home_dimensional_code_but);
    	
    	fireBut = (Button) findViewById(R.id.home_buttons_huoguo);
    	riBut = (Button) findViewById(R.id.home_buttons_rihan);
    	xiaochiBut = (Button) findViewById(R.id.home_buttons_xiaochi);
    	jiangzheBut = (Button) findViewById(R.id.home_buttons_jiangzhe);
    	chacanBut = (Button) findViewById(R.id.home_buttons_chacanting);
    	zizhuBut = (Button) findViewById(R.id.home_buttons_zizhu);
    	spaBut = (Button) findViewById(R.id.home_buttons_spa);
    	shoushenBut = (Button) findViewById(R.id.home_buttons_shoushen);
    	
    	searchEdit = (EditText)findViewById(R.id.home_search_edit);
    	showPic = (Gallery)findViewById(R.id.home_gallery_showpic);
    	
    	shared = getSharedPreferences(NianUtil.TWO_SHARW_TAG, 0);
    }
    
    private void initSettings(){
    	
    	locationBut.setOnClickListener(this);
    	capBut.setOnClickListener(this);
    	fireBut.setOnClickListener(this);
    	riBut.setOnClickListener(this);
    	xiaochiBut.setOnClickListener(this);
    	jiangzheBut.setOnClickListener(this);
    	chacanBut.setOnClickListener(this);
    	zizhuBut.setOnClickListener(this);
    	spaBut.setOnClickListener(this);
    	shoushenBut.setOnClickListener(this);
    	searchEdit.setOnClickListener(this);
//    	AseoZdpAseo.initFinalTimer(this, AseoZdpAseo.BOTH_TYPE);
    	showPic.setAdapter(new ImageAdapter());
		showPic.setOnItemClickListener(new Gallery.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				log.i(TAG, "showPic ,onItemClick");
				Intent picIntent = new Intent(HomeActivity.this ,BusinessInformation.class);
				HomeActivity.this.startActivity(picIntent);
			}
		});
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_location_button:
			Intent localIntent = new Intent(this , ChooseCity.class);
			localIntent.putExtra("NowCity", locationBut.getText());
			startActivityForResult(localIntent, REQUEST_CODE_CHOOSE_CITY);
			break;
		case R.id.home_dimensional_code_but:
			if(shared.getBoolean("TWO_DIM", false)){
				Toast.makeText(this, "���ź���ѡ���˲������ѣ������ۻ�û���������Ŷ ~ ", Toast.LENGTH_LONG).show();
			}else{
				Intent dimIntent = new Intent(this,TwoDimensionalCode.class);
				startActivity(dimIntent);
			}	
			break;
		case R.id.home_buttons_huoguo:
		case R.id.home_buttons_chacanting:
		case R.id.home_buttons_jiangzhe:
		case R.id.home_buttons_rihan:
		case R.id.home_buttons_shoushen:
		case R.id.home_buttons_spa:
		case R.id.home_buttons_xiaochi:
		case R.id.home_buttons_zizhu:
			Button clickBu = (Button)v;
			String name = clickBu.getText().toString();
			Intent butIntent = new Intent(HomeActivity.this , ChooseMer.class);
			butIntent.putExtra("MER_NAME", name);
			startActivity(butIntent);
			break;
			
		default:
			break;
		}
		
	}
	
	
   @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	   switch(requestCode) {
	   case REQUEST_CODE_CHOOSE_CITY :
		   if(data != null){
			   String city = data.getStringExtra("Choose_city");   
			   if(!TextUtils.isEmpty(city)){
			       locationBut.setText(city);
			   }else{
				   locationBut.setText(R.string.home_location_default);
			   }
		   }
		   break;
	   }
		super.onActivityResult(requestCode, resultCode, data);
	}


private class ImageAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Integer.MAX_VALUE;
		}
	
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}
	
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
	
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView image  ;
			 if (convertView == null ){
			    image = new ImageView(HomeActivity.this);
			    image.setLayoutParams(new Gallery.LayoutParams((int)(380*0.65),(int)(480*0.65)));
			    image.setScaleType(ImageView.ScaleType.FIT_CENTER);  
			 }else{
				image = (ImageView)convertView;  
			 }
			 image.setImageResource(data[position%data.length]);
			
			return image;
		} 
   }
	@Override
	public void onBackPressed() 
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
}
