package com.admiral26.movieappmvvmauth.presentation.main_screen.profil

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.databinding.ScreenProfileBinding
import com.admiral26.movieappmvvmauth.presentation.main_screen.MainScreenDirections
import com.admiral26.movieappmvvmauth.util.avatar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileScreen : BaseFragment(R.layout.screen_profile) {
    private val binding by viewBinding(ScreenProfileBinding::bind)
    private val viewModel: ProfileViewModel by viewModels<ProfileViewModelImp>()

    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        binding.progresImageProfil.visibility = View.VISIBLE
        viewModel.getAllDetail()
        observe()
       binding.logOut.setOnClickListener{
           AlertDialog.Builder(requireContext())
               .setIcon(R.drawable.log)
               .setTitle("Log Out")
               .setMessage("Do you want log out ?")
               .setPositiveButton("Yes") { d, _ ->
                   viewModel.logOut()
                   d.dismiss()
               }
               .setNegativeButton("No") { d, _ ->
                   d.cancel()
               }
               .show()
       }
    }

    private fun observe() {
        viewModel.getAllDetail.observe(this) {
            Log.d("data", "observe: ${it.toString()}")
            it?.let { data ->
                binding.progresImageProfil.visibility = View.GONE
                binding.profilName.visibility = View.VISIBLE
                binding.userProfilePhoto.avatar(data.avatar.tmdb.avatarPath)
                if (data.name.isBlank()) {
                    binding.name.text = "User"
                } else {
                    binding.name.text = data.name
                }
                binding.userName.text = data.username
            }
        }

        viewModel.logOut.observe(viewLifecycleOwner) {
            it?.let {
                viewModel.deleteSession()
                findNavController().navigate(MainScreenDirections.actionMainScreen2ToSignUpScreen())
            }
        }
    }
}