package com.admiral26.movieappmvvmauth.presentation.singUp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootRespons
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderRespons
import com.admiral26.movieappmvvmauth.databinding.ScreenSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpScreen : BaseFragment(R.layout.screen_sign_up) {

    private val binding by viewBinding(ScreenSignUpBinding::bind)
    private val viewModel: SignUpViewModel by viewModels<SignUpViewModelImp>()

    private var token: String? = null
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.createToken()
        observe()
        setListen()
    }

    private fun observe() {
        viewModel.tokenLD.observe(this) {
            it?.let {
                token = it.requestToken
            }
        }

        viewModel.loginLD.observe(this) {
            it?.let {
                viewModel.createSession(SessionRequest(it.requestToken))
            }
        }

        viewModel.sessionLD.observe(this) {
            it?.let {
                viewModel.saveSession(it.sessionId)
                findNavController().navigate(SignUpScreenDirections.actionSignUpScreenToMainScreen2())
                Log.d("TAG11", "observe:homga Kirdi")
            }
        }
    }

    private fun setListen() {

        binding.registerButton.setOnClickListener {
            binding.progresSignUp.visibility = View.VISIBLE
            val userName = binding.username.text?.trim().toString()
            val password = binding.password.text?.trim().toString()

            if (userName.isBlank() || password.isBlank()) {
                binding.progresSignUp.visibility = View.GONE
                return@setOnClickListener

            }

            token?.let {
                val body = LoginRequest(username = userName, password = password, requestToken = it)
                viewModel.login(body)
            }


        }


        binding.signuptostart.setOnClickListener {
            val url = "https://www.themoviedb.org/signup"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}