package com.company.hoi4divisiondesigner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class viewAdapter (context: Context, var batList: ArrayList<batData>) : RecyclerView.Adapter<viewAdapter.ViewHolder>()  {

    private var mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.batName.text = batList[position].batName
            holder.batQuant.text = batList[position].batQuant.toString()

            holder.addBat.setOnClickListener {
                if (batList[position].batQuant < 25) {
                    batList[position].batQuant += 1
                    notifyDataSetChanged()
                    (mContext as TemplateActivity).calculate()
                }
            }

            holder.delBat.setOnClickListener {
                if (batList[position].batQuant > 0) {
                    batList[position].batQuant -= 1
                    if (batList[position].batQuant == 0) removeItem(position, holder, batList)
                    notifyDataSetChanged()
                    (mContext as TemplateActivity).calculate()
                }
            }
    }

    override fun getItemCount(): Int {
        return batList.size
    }

    class ViewHolder (ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val batName: TextView = itemView.findViewById(R.id.batName)
        val batQuant: TextView = itemView.findViewById(R.id.batQuant)
        val addBat : ImageView = itemView.findViewById(R.id.addBat)
        val delBat : ImageView = itemView.findViewById(R.id.delBat)
        //val delRow : ImageView = itemView.findViewById(R.id.delRow)
    }

    private fun removeItem(position: Int, holder : ViewHolder, model: ArrayList<batData>) {
        val newPosition: Int = holder.adapterPosition
        model.removeAt(newPosition)
        notifyItemRemoved(newPosition)
        notifyItemRangeChanged(newPosition, model.size)
    }
}
