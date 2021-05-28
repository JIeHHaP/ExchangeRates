package com.jiehhap.exchangerates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


class MainActivity : AppCompatActivity() {

    private var docJsoup = Document("https://www.open.ru/")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val thread = Thread(Runnable {
            docJsoup = Jsoup.connect("https://kovalut.ru/kurs/novosibirsk/").get()
            var tables = Elements(docJsoup.getElementsByTag("tbody"))
            var exchange_table = tables.get(2)
            var elements_exTable = Elements(exchange_table.children())
            Log.d("MyLog", "Title: " + elements_exTable.get(3).text())

        })
        thread.start()




    }

}