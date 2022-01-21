package com.cnr.cse476assignment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewTab extends Fragment {

    public static EditText edittext;
    public static WebView webView,webView2;
    static String CurrentUrl="";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewTab.
     */
    // TODO: Rename and change types and number of parameters
    public static NewTab newInstance(String param1, String param2) {
        NewTab fragment = new NewTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        /*webView = (WebView) webView.findViewById(R.id.myWebVieww);
        webView.setWebViewClient(new MywebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);*/


        //webView.loadUrl("https://www.google.com.tr/?hl=tr");
        //webView.loadUrl("http://www.sancaktepe.bel.tr/tr/");

        ////edittext=(EditText) edittext.findViewById(R.id.siteaddresss);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_tab, container, false);

        webView = (WebView) view.findViewById(R.id.myWebVieww);
        webView.setWebViewClient(new MywebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        /*webView2 = (WebView) view.findViewById(R.id.myWebVieww);
        webView2.setWebViewClient(new MywebViewClient());
        WebSettings webSettings2 = webView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);*/

        edittext=(EditText) view.findViewById(R.id.siteaddresss);

        return view;
    }




    /*public void goSite(View view) {

        String address=edittext.getText().toString();
        webView.loadUrl(address);
        String urll=webView.getUrl().toString();
        edittext.setText(urll);
    }*/



    /*private class MywebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            CurrentUrl=request.getUrl().toString();
            edittext.setText(CurrentUrl);
            return false;

        }
    }*/

    private class MywebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String dom="";
            try {
                URI uri = new URI(url);
                String host = uri.getHost();
                String domain = host.startsWith("www.") ? host.substring(4) : host;
                dom=domain;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            MainActivity.tabLayout.getTabAt(MainActivity.CurrentTabIndex).setText(dom);
            edittext.setText(url);
            return false;

        }
    }



}