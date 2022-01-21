package com.cnr.cse476assignment2;

import static com.cnr.cse476assignment2.NewTab.webView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*private EditText edittext;
    private WebView webView;
    String CurrentUrl="";*/


    static TabLayout tabLayout;
    ViewPager viewPager;
    static int tabCounter=1;
    String originalUrll="";
    static int CurrentTabIndex=0;

    String[] originalUrls={"","","","","","","","","","","","","","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* webView = findViewById(R.id.myWebView);
        webView.setWebViewClient(new MywebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);*/


        ///webView.loadUrl("https://www.google.com.tr/?hl=tr");
        ///webView.loadUrl("http://www.sancaktepe.bel.tr/tr/");

        //edittext=(EditText) findViewById(R.id.siteaddress);




        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("BLANKPAGE"));
        //originalUrls.add(tabCounter-1,originalUrll);
        //tabLayout.addTab(tabLayout.newTab().setText("025"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i=tab.getPosition();
                CurrentTabIndex=i;
                /*if(MainActivity.tabCounter==2){
                    NewTab.webView.loadUrl("http://www.sancaktepe.bel.tr/tr/");
                }*/
                //NewTab.webView.loadUrl(originalUrls.get(i));
                NewTab.webView.loadUrl(originalUrls[i]);
                NewTab.edittext.setText(originalUrls[i]);

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int i=tab.getPosition();
                originalUrls[i]=webView.getOriginalUrl();
                /*originalUrll=webView.getOriginalUrl();
                originalUrls.add(i,originalUrll);
                originalUrll="";*/
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }






    public void goSite(View view) {

        String address=NewTab.edittext.getText().toString();
        NewTab.webView.loadUrl(address);
        String urll= NewTab.webView.getUrl().toString();
        NewTab.edittext.setText(urll);
    }

    public void OpenNewTab(View view){
        //tabLayout.addTab(tabLayout.newTab().setText("025"));
        if(tabCounter<20){
            tabLayout.addTab(tabLayout.newTab().setText("BLANKPAGE"));
            tabCounter++;
        }

        /*originalUrll="";
        originalUrls.add(tabCounter-1,originalUrll);*/
    }



    /*public class MywebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            NewTab.CurrentUrl=request.getUrl().toString();
            NewTab.edittext.setText(NewTab.CurrentUrl);
            return false;
        }
    }*/
}