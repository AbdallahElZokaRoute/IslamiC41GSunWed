package com.route.islamiappc41gsunwed.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islamiappc41gsunwed.R
import com.route.islamiappc41gsunwed.databinding.ActivityChapterDetailsBinding
import com.route.islamiappc41gsunwed.home.adapters.VersesAdapter
import com.route.islamiappc41gsunwed.home.model.AppConstants
import com.route.islamiappc41gsunwed.home.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityChapterDetailsBinding
    lateinit var adapter: VersesAdapter
    var chapter: Chapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiveParams()
        initRecyclerView()
        binding.chapterTitleEnTextView.text = chapter?.titleEn
        binding.chapterTitleArTextView.text = chapter?.titleAr
        binding.backIcon.setOnClickListener {
            finish()
        }

    }

    fun receiveParams() {           //               API  >= 33  = Android 13
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY, Chapter::class.java)
        } else {
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY)
        }
    }

    fun initRecyclerView() {
        adapter = VersesAdapter(readChapterVerses())
        binding.versesRecyclerView.adapter = adapter
    }

    private fun readChapterVerses(): List<String> {
        val fileContent = assets.open("quran/${chapter?.order}.txt").bufferedReader()
            .use {
                it.readText()
            }
        return fileContent.trim().split("\n")
    }
}