package com.boxstudio.chencha;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;



import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private CCGLSurfaceView mGLSurfaceView;

	//<!-- Admob Ads Using Google Play Services SDK -->
	private static final String AD_UNIT_ID = "ca-app-pub-1141613635835332/7968365003";
	private static final String AD_INTERSTITIAL_UNIT_ID = "df2cce209f194168";
	



	public static MainActivity app;
	
	public void onCreate(Bundle savedInstanceState)
	{
		app = this;
		
		super.onCreate(savedInstanceState);
				
		// set view
		mGLSurfaceView = new CCGLSurfaceView(this);
		
		
		//Ads ----------------
		// Create the adView
 		RelativeLayout layout = new RelativeLayout(this);
 		layout.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

 		//<!-- Ads Using Google Play Services SDK -->

 	    
 		// Add the adView to it
 		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
 				LayoutParams.WRAP_CONTENT,
 				LayoutParams.WRAP_CONTENT);
 		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
 		params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
 		

 		
 		layout.addView(mGLSurfaceView);

 		
 		setContentView(layout);
 		//New AdRequest 

 		//-----------------------------------------------------Interstitial Add
 		// Create an Interstitial ad.

 		 // Load the interstitial ad.
 	    //showInterstitialAds();

 		//----------------------
		// set director
		CCDirector director = CCDirector.sharedDirector();
		director.attachInView(mGLSurfaceView);
		director.setAnimationInterval(1/60);

		// get display info
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		G.display_w = displayMetrics.widthPixels;
		G.display_h = displayMetrics.heightPixels;
		G.scale = Math.max(G.display_w/1280.0f, G.display_h/800.0f);
		G.width = G.display_w / G.scale;
		G.height = G.display_h / G.scale;
		
		// get data
		SharedPreferences sp = CCDirector.sharedDirector().getActivity().getSharedPreferences("GameInfo", 0);
		G.music = sp.getBoolean("music", true);
		G.sound = sp.getBoolean("sound", true);
		
		// create sound
		G.soundMenu = MediaPlayer.create(this, R.raw.menu);
		G.soundMenu.setLooping(true);
		G.soundGame = MediaPlayer.create(this, R.raw.game);
		G.soundGame.setLooping(true);
		G.soundCollide = MediaPlayer.create(this, R.raw.collide);
		G.soundJump = MediaPlayer.create(this, R.raw.jump);
		G.soundLongJump = MediaPlayer.create(this, R.raw.long_jump);
		G.soundSpeedDown = MediaPlayer.create(this, R.raw.speed_down);
		G.soundSpeedUp = MediaPlayer.create(this, R.raw.speed_up);
		G.soundDirection = MediaPlayer.create(this, R.raw.direction_sign);
		G.soundClick = MediaPlayer.create(this, R.raw.menu_click);
		G.soundCollect = MediaPlayer.create(this, R.raw.collect);
		G.bgSound = G.soundMenu;
             
		// show menu
        CCScene scene = CCScene.node();
        scene.addChild(new MenuLayer(true));
        director.runWithScene(scene);
    }  
	
    @Override
    public void onPause()
    {

    	
        super.onPause();
        G.bgSound.pause();
        CCDirector.sharedDirector().onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        

        if( G.music ) G.bgSound.start();
        
        CCDirector.sharedDirector().onResume();
    }

    @Override
    public void onDestroy()
    {
    	// Destroy the AdView.

	    
        super.onDestroy();
        G.bgSound.pause();
        CCDirector.sharedDirector().end();
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
    	if( keyCode == KeyEvent.KEYCODE_BACK )
    	{
    		CCDirector.sharedDirector().onKeyDown(event);
    		return true;
    	}
		return super.onKeyDown(keyCode, event);
    }
    

}
