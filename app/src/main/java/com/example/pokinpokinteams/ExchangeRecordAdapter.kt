package com.example.pokinpokinteams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExchangeRecordAdapter(
    private val records: MutableList<ExchangeRecord>
) : RecyclerView.Adapter<ExchangeRecordAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val phone: TextView = itemView.findViewById(R.id.txtPhone)
        val points: TextView = itemView.findViewById(R.id.txtPoints)
        val time: TextView = itemView.findViewById(R.id.txtTime)
        val status: TextView = itemView.findViewById(R.id.txtStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_record, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val r = records[position]
        holder.phone.text = "📞  ${r.phone}"
        holder.points.text = "⭐  +${r.points} Points"
        holder.time.text = r.time
        holder.status.text = "✓  Completed"
    }

    override fun getItemCount(): Int = records.size

    fun addToTop(record: ExchangeRecord) {
        records.add(0, record)
        notifyItemInserted(0)
    }
}
