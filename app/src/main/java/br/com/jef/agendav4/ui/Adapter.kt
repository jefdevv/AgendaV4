package br.com.jef.agendav4.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.jef.agendav4.R
import br.com.jef.agendav4.utils.listener.AgendaListener

class Adapter(
    private val listCard: MutableList<String>,
    private val listNumber: MutableList<String>,
    private val listGender: MutableList<String>,
    private val listener: AgendaListener

) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = listCard.size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val name = listCard[position]
        val number = listNumber[position]
        val gender = listGender[position]
        holder.txtName.text = name
        holder.txtTelNumber.text = number
        holder.txtGender.text = gender
        holder.cardView.setOnClickListener {
            listener.onClick(name, number, gender)
        }
        holder.imgDelete.setOnClickListener {
            listCard.remove(name)
            listNumber.remove(number)
            listGender.remove(gender)
            notifyDataSetChanged()
        }


    }
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtName = view.findViewById<TextView>(R.id.txtNameCard)
    val txtTelNumber = view.findViewById<TextView>(R.id.txtTelephoneCard)
    val txtGender = view.findViewById<TextView>(R.id.txtGenderCard)
    val cardView = view.findViewById<CardView>(R.id.card)
    val imgDelete = view.findViewById<ImageView>(R.id.imgDelete)

}
