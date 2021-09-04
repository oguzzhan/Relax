package com.ozzy.relax.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ozzy.relax.R
import com.ozzy.relax.databinding.DashboardFragmentBinding
import com.ozzy.relax.utils.extension.backGroundColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    lateinit var binding: DashboardFragmentBinding
    val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().backGroundColor(R.color.dashboard_dark)
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }


}