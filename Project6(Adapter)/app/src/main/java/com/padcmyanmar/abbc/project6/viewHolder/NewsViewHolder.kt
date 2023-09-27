package com.padcmyanmar.abbc.project6.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.abbc.project6.delegate.NewsItemActionDelegate

class NewsViewHolder(itemView: View, delegate: NewsItemActionDelegate) : BaseNewViewHolder(itemView,delegate) {

    init {
        itemView.setOnClickListener {
            delegate.onTapNews()
        }
    }
}