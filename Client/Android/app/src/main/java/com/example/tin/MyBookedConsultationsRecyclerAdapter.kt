package com.example.tin

import android.annotation.SuppressLint
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tin.data.Consultation
import kotlinx.android.synthetic.main.my_booked_consultation_item.view.*

class MyBookedConsultationsRecyclerAdapter(private val consultations: List<Consultation>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_booked_consultation_item, parent, false) as ConstraintLayout
        return MyBookedConsultationRecyclerViewHolder(item)
    }

    override fun getItemCount(): Int {
        return consultations.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val consultation = consultations[position]
        holder.itemView.elevation = 20.0f
        holder.itemView.person.text = consultation.person
        holder.itemView.day.text = consultation.day
        holder.itemView.start_time.text = "${consultation.startTime} - ${consultation.endTime}"
        holder.itemView.cancellation_button.setOnClickListener { v ->
            Log.d("Adapter", "Clicked $position")
        }
    }
}

class MyBookedConsultationRecyclerViewHolder(item: ConstraintLayout): RecyclerView.ViewHolder(item)