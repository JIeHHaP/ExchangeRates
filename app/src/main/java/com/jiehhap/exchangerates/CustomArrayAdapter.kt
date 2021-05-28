package com.jiehhap.exchangerates

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class CustomArrayAdapter(context: Context, resource: Int, listItem: List<ListItemClass>, private val inflater: LayoutInflater) : ArrayAdapter<ListItemClass?>(context, resource, listItem) {

    private var listItem: List<ListItemClass> = ArrayList<ListItemClass>()

    val context:Context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        val listItemMain: ListItemClass = listItem[position]
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_1, null, false)
            viewHolder = ViewHolder()
            viewHolder.bank_name = convertView.findViewById<TextView>(R.id.BankName)
            viewHolder.dollar_buy = convertView.findViewById<TextView>(R.id.Dollar_buy)
            viewHolder.dollar_sale = convertView.findViewById<TextView>(R.id.Dollar_sale)
            viewHolder.euro_buy = convertView.findViewById<TextView>(R.id.Euro_buy)
            viewHolder.euro_sale = convertView.findViewById<TextView>(R.id.Euro_sale)
            convertView.setTag(viewHolder)
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        viewHolder.bank_name?.text = listItemMain.bank_name_LIC
        viewHolder.dollar_buy?.text = (listItemMain.dollar_buy_LIC)
        viewHolder.dollar_sale?.text = (listItemMain.dollar_sale_LIC)
        viewHolder.euro_buy?.text = (listItemMain.euro_buy_LIC)
        viewHolder.euro_sale?.text = (listItemMain.euro_sale_LIC)

        return convertView!!
    }

    private inner class ViewHolder {
        var bank_name: TextView? = null
        var dollar_buy: TextView? = null
        var dollar_sale: TextView? = null
        var euro_buy: TextView? = null
        var euro_sale: TextView? = null

    }

    init {
        this.listItem = listItem
        this.context = context
    }
}