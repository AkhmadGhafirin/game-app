package com.cascer.thegameapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cascer.thegameapp.data.Resource
import com.cascer.thegameapp.databinding.FragmentHomeBinding
import com.cascer.thegameapp.ui.GameAdapter
import com.cascer.thegameapp.utils.gone
import com.cascer.thegameapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val gameAdapter by lazy { GameAdapter { } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
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

    private fun setupViewModel() {
        with(viewModel) {
            games.observe(viewLifecycleOwner) {
                if (it != null) {
                    when (it) {
                        is Resource.Success -> {
                            binding.progressbar.gone()
                            Log.d("HomeFragment", "setupViewModel: ${it.data}")
                            it.data?.let { data -> gameAdapter.sendData(data) }
                        }

                        is Resource.Error -> {
                            binding.progressbar.gone()
                            Log.d("HomeFragment", "setupViewModel: ${it.message}")
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }

                        is Resource.Loading -> {
                            Log.d("HomeFragment", "setupViewModel: Loading")
                            binding.progressbar.visible()
                        }
                    }
                }
            }
        }
    }
}