package com.boxstudio.holasoygerman;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    String paginaweb2 = "file:///android_asset/holasoygerman/index.html";
    String errorweb = "file:///android_asset/holasoygerman/error.html";
     WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myWebView = (WebView) this.findViewById(R.id.webView);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());
       // myWebView.loadUrl("https://www.onlinequizcreator.com/es/cuanto-sabes-de-vegetta-777/quiz-253506");
        myWebView.loadUrl(paginaweb2);
        myWebView.setWebViewClient(new WebViewClient(){
            public void onReciveError (WebView view, int errorCode, String description, String fallingUrl){
                myWebView.loadUrl(errorweb);
                }
            }
        );
    }

    @Override
    public void onBackPressed() {

        // Check if there's history
        if (this.myWebView.canGoBack())
            this.myWebView.goBack();
        else
            super.onBackPressed();

    }

    private class MyWebViewClient extends WebViewClient {
    }
}
