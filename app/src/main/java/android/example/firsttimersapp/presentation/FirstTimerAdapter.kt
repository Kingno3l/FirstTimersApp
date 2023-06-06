package android.example.firsttimersapp.presentation

import android.example.firsttimersapp.R
import android.example.firsttimersapp.databinding.ItemFirstTimerBinding
import android.example.firsttimersapp.domain.FirstTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private lateinit var binding: ItemFirstTimerBinding

class FirstTimerAdapter(
    var firstTimers: List<FirstTimer>

) : RecyclerView.Adapter<FirstTimerAdapter.FirsttimerViewHolder>() {

    inner class FirsttimerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvFullName: TextView = itemView.findViewById(R.id.tvFullName)
        val tvPhoneNumber: TextView = itemView.findViewById(R.id.tvPhoneNumber)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
        val tvPrayerReq: TextView = itemView.findViewById(R.id.tvPrayerReq)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirsttimerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_first_timer,parent, false)
        return FirsttimerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return firstTimers.size
    }

    override fun onBindViewHolder(holder: FirsttimerViewHolder, position: Int) {
        holder.tvFullName.text = firstTimers[position].fullName
        holder.tvPhoneNumber.text = firstTimers[position].phoneNumber
        holder.tvEmail.text = firstTimers[position].email
        holder.tvAddress.text = firstTimers[position].address
        holder.tvPrayerReq.text = firstTimers[position].prayerRequest
    }

}