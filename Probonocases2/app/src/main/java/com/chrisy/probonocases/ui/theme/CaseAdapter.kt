package com.chrisy.probonocases.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chrisy.probonocases.R
import com.chrisy.probonocases.data.Case

class CaseAdapter(private val onCaseClicked: (Case) -> Unit) :
    ListAdapter<Case, CaseAdapter.CaseViewHolder>(CaseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_case, parent, false)
        return CaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        val case = getItem(position)
        holder.bind(case)
    }

    inner class CaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Use TextView directly without findViewById
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewCaseTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.textViewCaseDescription)
        private val statusTextView: TextView = itemView.findViewById(R.id.textViewCaseStatus)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onCaseClicked(getItem(position))
                }
            }
        }

        fun bind(case: Case) {
            titleTextView.text = case.title
            descriptionTextView.text = case.description
            statusTextView.text = case.status

            // Set status color based on status
            val statusColor = when(case.status.lowercase()) {
                "won" -> ContextCompat.getColor(itemView.context, R.color.green)
                "lost" -> ContextCompat.getColor(itemView.context, R.color.red)
                "pending" -> ContextCompat.getColor(itemView.context, R.color.orange)
                "untouched" -> ContextCompat.getColor(itemView.context, R.color.gray)
                else -> ContextCompat.getColor(itemView.context, R.color.blue)
            }

            // Apply the color to the background
            statusTextView.background?.setTint(statusColor)
        }
    }

    class CaseDiffCallback : DiffUtil.ItemCallback<Case>() {
        override fun areItemsTheSame(oldItem: Case, newItem: Case): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Case, newItem: Case): Boolean {
            return oldItem == newItem
        }
    }
}