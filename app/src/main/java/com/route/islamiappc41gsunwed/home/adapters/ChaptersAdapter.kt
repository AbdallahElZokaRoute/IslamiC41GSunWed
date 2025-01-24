package com.route.islamiappc41gsunwed.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamiappc41gsunwed.databinding.ItemChapterBinding
import com.route.islamiappc41gsunwed.home.adapters.callbacks.OnChapterClickListener
import com.route.islamiappc41gsunwed.home.model.Chapter

class ChaptersAdapter(val chapters: List<Chapter>) : Adapter<ChaptersAdapter.ChapterViewHolder>() {

    var onChapterClickListener: OnChapterClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val item = chapters[position]
        holder.bind(item, position)
    }

    inner class ChapterViewHolder(val binding: ItemChapterBinding) : ViewHolder(binding.root) {
        fun bind(chapter: Chapter, position: Int) {
            binding.chapterOrderTextView.text = "${chapter.order}"
            binding.chapterLengthTextView.text = "${chapter.length} Verses"
            binding.chapterTitleArTextView.text = chapter.titleAr
            binding.chapterTitleEnTextView.text = chapter.titleEn
            binding.root.setOnClickListener {
                onChapterClickListener?.onChapterClick(chapter, position)
            }
        }
    }

}