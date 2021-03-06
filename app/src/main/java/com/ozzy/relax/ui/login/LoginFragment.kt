package com.ozzy.relax.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ozzy.relax.R
import com.ozzy.relax.databinding.LoginFragmentBinding
import com.ozzy.relax.utils.extension.backGroundColorDrawable


class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ContextCompat.getDrawable(requireContext(), R.drawable.login_status_bar)?.let {
            requireActivity().backGroundColorDrawable(it)
        }
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel?.goToDashboard?.observe(viewLifecycleOwner) {
            if (it.getContentIfNotHandled() == true) {
                findNavController().navigate(R.id.dashboardFragment)
            }
        }
    }
}