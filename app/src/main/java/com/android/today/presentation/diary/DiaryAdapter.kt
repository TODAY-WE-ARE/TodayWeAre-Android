package com.android.today.presentation.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.today.data.Diary
import com.android.today.databinding.ItemDiaryListBinding
import com.android.today.util.extension.ItemDiffCallback

class DiaryAdapter :
    ListAdapter<Diary, DiaryAdapter.DiaryViewHolder>(diaryDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiaryViewHolder {
        val itemDiaryListBinding =
            ItemDiaryListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return DiaryViewHolder(
            itemDiaryListBinding
        )
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class DiaryViewHolder(private val binding: ItemDiaryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Diary) {
            binding.data = data
        }
    }

    companion object {
        private val diaryDiffUtil = ItemDiffCallback<Diary>(
            onItemsTheSame = { old, new -> old.date == new.date },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
