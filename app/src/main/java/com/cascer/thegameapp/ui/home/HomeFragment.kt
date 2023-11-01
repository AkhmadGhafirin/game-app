package com.cascer.thegameapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cascer.thegameapp.data.Resource
import com.cascer.thegameapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

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

        }
    }

    private fun setupViewModel() {
        with(viewModel) {
            games.observe(viewLifecycleOwner) {
                if (it != null) {
                    when(it) {
                        is Resource.Success -> {
                            Log.d("HomeFragment", "setupViewModel: ${it.data}")
                        }
                        is Resource.Error -> {
                            Log.d("HomeFragment", "setupViewModel: ${it.message}")
                        }
                        is Resource.Loading -> {
                            Log.d("HomeFragment", "setupViewModel: Loading")
                        }
                    }
                }
            }
        }
    }
}