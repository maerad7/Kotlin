package com.example.maerad7.doseokxml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.xmlpull.v1.XmlPullParser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_xml.setOnClickListener{
            var xpp = resources.getXml(R.xml.doseok_custom)
            while(xpp.eventType != XmlPullParser.END_DOCUMENT){
                if(xpp.eventType==XmlPullParser.START_TAG){
                    if(xpp.name == "word"){
                        println(xpp.getAttributeValue(0))
                    }
                }
                xpp.next()
            }
        }
    }
}
