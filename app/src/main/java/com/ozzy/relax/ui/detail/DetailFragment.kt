package com.ozzy.relax.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozzy.relax.R
import com.ozzy.relax.databinding.DetailFragmentBinding
import com.ozzy.relax.utils.extension.backGroundColor

class DetailFragment : Fragment() {

    lateinit var binding: DetailFragmentBinding
    val viewModel: DetailViewModel by viewModels()
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().backGroundColor(R.color.dark_grey)
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.viewModel?.setItem(args.meditation, args.story)
        return binding.root
    }
}