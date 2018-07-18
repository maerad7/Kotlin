package com.example.maerad7.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNaver.setOnClickListener {
            webView.webViewClient= WebViewClient()
            webView.loadUrl("https://www.naver.com")
        }
        buttonDaum.setOnClickListener {
            webView.webViewClient= WebViewClient()
            webView.loadUrl("https://www.daum.net")
        }
        buttonGoogle.setOnClickListener{
            webView.webViewClient= WebViewClient()
            webView.loadUrl("https://www.google.com")

        }
        }

}
