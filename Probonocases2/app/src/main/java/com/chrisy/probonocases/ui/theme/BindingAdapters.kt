package com.chrisy.probonocases.ui.theme

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.core.content.ContextCompat
import com.chrisy.probonocases.R

/**
 * Binding adapter for setting the text color based on case status
 * @param view The TextView to apply the color to
 * @param status The case status string
 */
@BindingAdapter("statusColor")
fun setStatusColor(view: TextView, status: String?) {
    status?.let {
        val colorRes = when (it.lowercase()) {
            "won" -> R.color.green
            "lost" -> R.color.red
            "pending" -> R.color.orange
            "untouched" -> R.color.gray
            else -> R.color.black
        }
        view.setTextColor(ContextCompat.getColor(view.context, colorRes))
    }
}

/**
 * Optional: Add another binding adapter to set the background tint based on status
 */
@BindingAdapter("statusBackgroundTint")
fun setStatusBackgroundTint(view: TextView, status: String?) {
    status?.let {
        val colorRes = when (it.lowercase()) {
            "won" -> R.color.green
            "lost" -> R.color.red
            "pending" -> R.color.orange
            "untouched" -> R.color.gray
            else -> R.color.black
        }
        view.background?.setTint(ContextCompat.getColor(view.context, colorRes))
    }
}