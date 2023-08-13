package com.android.today.presentation.scrap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.today.data.Pick
import com.android.today.databinding.ItemPickBinding
import com.android.today.util.extension.ItemDiffCallback


class ScrapAdapter :
    ListAdapter<Pick, ScrapAdapter.ScrapViewHolder>(scrapDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScrapViewHolder {
        val itemScrapScrapBinding =
            ItemPickBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ScrapViewHolder(
            itemScrapScrapBinding
        )
    }

    override fun onBindViewHolder(holder: ScrapViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ScrapViewHolder(private val binding: ItemPickBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Pick) {
            binding.data = data
        }
    }

    companion object {
        private val scrapDiffUtil = ItemDiffCallback<Pick>(
            onItemsTheSame = { old, new -> old.image == new.image },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}