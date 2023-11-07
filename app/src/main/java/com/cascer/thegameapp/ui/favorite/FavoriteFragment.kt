package com.cascer.thegameapp.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cascer.thegameapp.databinding.FragmentFavoriteBinding
import com.cascer.thegameapp.domain.model.Game
import com.cascer.thegameapp.ui.GameAdapter
import com.cascer.thegameapp.ui.detail.DetailActivity
import com.cascer.thegameapp.utils.gone
import com.cascer.thegameapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels()
    private val gameAdapter by lazy { GameAdapter { toDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onResume() {
        super.onResume()
        setupViewModel()
    }

    private fun setupView() {
        with(binding) {
            rvList.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = gameAdapter
            }
        }
    }

    private fun toDetail(game: Game) {
        startActivity(Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_DATA, game)
        })
    }

    private fun setupViewModel() {
        with(viewModel) {
            favoriteGames.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    binding.emptyView.root.visible()
                    binding.rvList.gone()
                } else {
                    binding.emptyView.root.gone()
                    binding.rvList.visible()
                    gameAdapter.sendData(it)
                }
            }
        }
    }
}