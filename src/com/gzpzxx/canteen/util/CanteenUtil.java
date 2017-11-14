package com.gzpzxx.canteen.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;

public class CanteenUtil {
	public static final String TWO_SHARW_TAG = "com.gzpzxx.canteen";
	/**
	 * 获取屏幕的尺寸
	 * @param context
	 * @return
	 */
	public static int[] getScreenSize(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getResources().getDisplayMetrics();
		int[] size = { dm.widthPixels, dm.heightPixels };
		return size;
	}
	
	/**
	 * 获取状态栏的高度
	 * @param activity
	 * @return
	 */
	public static int getStatusBarH(Activity activity){
		Rect frame = new Rect();  
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);  
		return frame.top;
	}
}
