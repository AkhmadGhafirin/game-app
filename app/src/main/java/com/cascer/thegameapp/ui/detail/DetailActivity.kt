package com.cascer.thegameapp.ui.detail

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cascer.thegameapp.R
import com.cascer.thegameapp.databinding.ActivityDetailBinding
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.utils.ImageUtils.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        with(binding) {
            val game = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(EXTRA_DATA, Game::class.java)
            } else {
                intent.getParcelableExtra(EXTRA_DATA)
            }

            game?.let {
                tvTitle.text = it.name
                ivGame.load(this@DetailActivity, it.backgroundImage)

                var favorite = it.isFavorite

                setStatusFavorite(favorite)
                fabFavorite.setOnClickListener { _ ->
                    favorite = !favorite
                    val status = if (favorite) "Add to" else "Remove from"
                    Toast.makeText(this@DetailActivity, "$status Favorite", Toast.LENGTH_SHORT)
                        .show()
                    viewModel.setFavoriteGame(it, favorite)
                    setStatusFavorite(favorite)
                }
            }
        }
    }

    private fun setStatusFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_24
                )
            )
        } else {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_border_24
                )
            )
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}