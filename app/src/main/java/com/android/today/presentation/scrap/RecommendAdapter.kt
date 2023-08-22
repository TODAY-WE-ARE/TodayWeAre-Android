package com.android.today.presentation.scrap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.today.data.Pick
import com.android.today.databinding.ItemRecommendBinding
import com.android.today.util.extension.ItemDiffCallback

class RecommendAdapter :
    ListAdapter<Pick, RecommendAdapter.RecommendationViewHolder>(recommendationDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendationViewHolder {
        val itemRecommendRecommendedBinding =
            ItemRecommendBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RecommendationViewHolder(
            itemRecommendRecommendedBinding
        )
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class RecommendationViewHolder(private val binding: ItemRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Pick) {
            binding.data = data
        }
    }

    companion object {
        private val recommendationDiffUtil = ItemDiffCallback<Pick>(
            onItemsTheSame = { old, new -> old.image == new.image },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
