package com.padcmyanmar.abbc.project6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.abbc.project6.R
import com.padcmyanmar.abbc.project6.delegate.NewsItemActionDelegate
import com.padcmyanmar.abbc.project6.viewHolder.BaseNewViewHolder
import com.padcmyanmar.abbc.project6.viewHolder.NewsViewHolder
import com.padcmyanmar.abbc.project6.viewHolder.SportNewsViewHolder

class NewsAdapter(private val delegate: NewsItemActionDelegate) : RecyclerView.Adapter<BaseNewViewHolder>() {

    val VIEW_TYPE_NEWS = 1
    val VIEW_TYPE_SPORT_NEWS = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNewViewHolder {
        when(viewType) {
            VIEW_TYPE_NEWS -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_news,parent,false)
                return NewsViewHolder(itemView,delegate)
            }
            VIEW_TYPE_SPORT_NEWS -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_sport_news,parent,false)
                return SportNewsViewHolder(itemView,delegate)
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_sport_news,parent,false)
                return SportNewsViewHolder(itemView,delegate)
            }
        }

    }


    override fun getItemCount(): Int {
        return 12
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position % 3 == 0 -> {
                VIEW_TYPE_SPORT_NEWS
            }
            else -> {
                VIEW_TYPE_NEWS
            }
        }
    }

    override fun onBindViewHolder(holder: BaseNewViewHolder, position: Int) {

    }
}