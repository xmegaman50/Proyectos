package com.boxstudio.emulapobre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WebView = (WebView) this.findViewById(R.id.webView);
        WebView.getSettings().setJavaScriptEnabled(true);
        //WebView.getSettings().setAppCacheEnabled(true);
        WebView.loadUrl("file:///android_asset/emulapobre/index.html");
        //WebView.loadUrl("http://www.xmegaman50.eu5.org/emulapobre");

        WebView.setWebViewClient(new WebViewClient() {


            public void onReceivedError(WebView view, int errorCode, String description, String
                    failingUrl) {
                WebView.loadUrl("file:///android_asset/emulapobre/error.html");

            }

        });


    }

    @Override
    public void onBackPressed() {

        // Check if there's history
        if (this.WebView.canGoBack())
            this.WebView.goBack();
        else
            super.onBackPressed();
    }

    private class MyWebViewClient extends WebViewClient {
    }
}