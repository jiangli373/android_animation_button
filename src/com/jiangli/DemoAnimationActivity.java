package com.jiangli;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
public class DemoAnimationActivity extends Activity implements OnClickListener,AnimationListener{
    /** Called when the activity is first created. */
	 private Button bt;
	 private boolean flag =false;
	 Animation anim;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(flag==false){
			anim = new TranslateAnimation(0, 120, 0, 0);
			anim.setAnimationListener(this);
			 anim.setInterpolator(new AccelerateDecelerateInterpolator());  
		       anim.setDuration(500);  
		        bt.startAnimation(anim);
		        flag = true;
		}else{
			anim = new TranslateAnimation(0, -120, 0, 0);
			anim.setAnimationListener(this);
			 anim.setInterpolator(new AccelerateDecelerateInterpolator());  
		        anim.setDuration(500);  
		        bt.startAnimation(anim);
		        flag = false;
		}
	}
	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		bt.clearAnimation();
		if(flag){
		bt.layout(120,0, 120+bt.getWidth(),bt.getHeight());
	}else{
		bt.layout(0, 0, bt.getWidth(),bt.getHeight());
	}
	}
	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
	}
}