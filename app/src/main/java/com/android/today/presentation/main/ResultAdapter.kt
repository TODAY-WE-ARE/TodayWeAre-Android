package com.android.today.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.today.data.ResultData
import com.android.today.databinding.ItemResultBinding
import com.android.today.util.extension.ItemDiffCallback

class ResultAdapter :
    ListAdapter<ResultData, ResultAdapter.ResultViewHolder>(resultDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultViewHolder {
        val itemResultBinding =
            ItemResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ResultViewHolder(
            itemResultBinding
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ResultViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResultData) {
            binding.data = data
        }
    }

    companion object {
        private val resultDiffUtil = ItemDiffCallback<ResultData>(
            onItemsTheSame = { old, new -> old.category == new.category },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
