package com.example.maerad7.doseokrealm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import io.realm.*
import kotlinx.android.synthetic.main.activity_main.*

open class Item:RealmObject(){
    open var name :String? =null
}
class MainActivity : AppCompatActivity() {
    var shoppingList = mutableListOf<Item>() //자바 list<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter=RcAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this)

        Realm.init(this)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()

        var realm = Realm.getInstance(config)
        button.setOnClickListener{
            realm.beginTransaction()
            var item = realm.createObject(Item::class.java)
            item.name = editText.text.toString()
            realm.commitTransaction()
        }

        realm.where(Item::class.java).findAll().addChangeListener {
            t: RealmResults<Item>?, changeSet: OrderedCollectionChangeSet? ->
            shoppingList.clear()
            shoppingList.addAll(t!!)
            (recyclerView.adapter as RcAdapter).notifyDataSetChanged()
        }
    }
    inner class RcAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            var textView = TextView(this@MainActivity)
            return CustomViewHolder(textView)
        }

        inner class CustomViewHolder(textView: TextView) : RecyclerView.ViewHolder(textView) {

        }

        override fun getItemCount(): Int {
            return shoppingList.size
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            var textView = p0!!.itemView as TextView
            textView.text = shoppingList[p1].name
        }

    }
}
