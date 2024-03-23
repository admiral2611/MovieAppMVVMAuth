package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.adapter.movie.actor.ActorAdapter
import com.admiral26.movieappmvvmauth.adapter.movie.trailer.TrailerAdapter
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.databinding.ScreenDetailBinding
import com.admiral26.movieappmvvmauth.util.poster


class DetailScreen : BaseFragment(R.layout.screen_detail) {
    private val binding by viewBinding(ScreenDetailBinding::bind)
    private val args: DetailScreenArgs by navArgs()
    private val actorAdapter by lazy { ActorAdapter() }
    private val trailerAdapter by lazy { TrailerAdapter() }
    private val viewModel: DetailViewModel by viewModels<DetailViewModelImp>()


    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        viewModel.getDetailMovie(args.id)
        viewModel.getCreditMovie(args.id)
        viewModel.getTrailerMovie(args.id)
        observe()
        setAdapter()
        listenerActions()

        /*requireActivity().onBackPressedDispatcher.addCallback{
            findNavController().navigate(DetailScreenDirections.actionDetailScreenToMainScreen())
        }*/
    }

    private fun listenerActions() {
        actorAdapter.onClicked = {
            findNavController().navigate(DetailScreenDirections.actionDetailScreenToActorScreen(it))
        }

        trailerAdapter.onClickTrailer = {
            val webIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$it"))
            startActivity(webIntent)
        }
    }


    private fun setAdapter() {
        binding.rvListActor.adapter = actorAdapter
        binding.rvListActor.setHasFixedSize(true)

        binding.rvListTrailer.adapter = trailerAdapter
        binding.rvListTrailer.setHasFixedSize(true)
    }

    private fun observe() {
        viewModel.detailLd.observe(viewLifecycleOwner) {
            it?.let {

                binding.ivBackdrop.poster(it.backdropPath)
                binding.ivPoster.poster(it.posterPath)
                binding.tvMovieTitleValue.text = it.title
                binding.tvVoteAverage.text = it.voteAverage.toString()
                binding.tvDescriptionValue.text = it.overview
                binding.tvTaglineTitle.text = it.tagline
            }
        }

        viewModel.creditLd.observe(viewLifecycleOwner) {
            it?.let {
                actorAdapter.setData(it.cast)
            }
        }

        viewModel.trailerLd.observe(viewLifecycleOwner) {
            it?.let {
                trailerAdapter.setData(it.results)
            }
        }
    }
}