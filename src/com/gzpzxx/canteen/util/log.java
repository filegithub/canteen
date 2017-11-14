package com.gzpzxx.canteen.util;

import android.util.Log;

public class log {
    public final static boolean DBG = true;
	public log(){
		
	}
	public static void i(String TAG , Object content){
		if(DBG)Log.i("canteen",TAG + " , " + content);
	}
	public static void d(String TAG , Object content){
		if(DBG)Log.d("canteen",TAG +" , "+ content);
	}
	public static void e(String TAG , Object content){
		if(DBG)Log.e("canteen",TAG +" , "+ content);
	}
	public static void w(String TAG , Object content){
		if(DBG)Log.w("canteen",TAG +" , "+ content);
	}
	public static void v(String TAG , Object content){
		if(DBG)Log.w("canteen",TAG +" , "+  content);
	}
}
