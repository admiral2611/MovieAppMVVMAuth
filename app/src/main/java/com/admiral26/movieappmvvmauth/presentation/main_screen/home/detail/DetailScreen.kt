package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.adapter.movie.actor.ActorAdapter
import com.admiral26.movieappmvvmauth.adapter.movie.trailer.TrailerAdapter
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.databinding.ScreenDetailBinding
import com.admiral26.movieappmvvmauth.room.entity.MovieEntity
import com.admiral26.movieappmvvmauth.util.poster


class DetailScreen : BaseFragment(R.layout.screen_detail) {
    private val binding by viewBinding(ScreenDetailBinding::bind)
    private val args: DetailScreenArgs by navArgs()
    private val actorAdapter by lazy { ActorAdapter() }
    private val trailerAdapter by lazy { TrailerAdapter() }
    private val viewModel: DetailViewModel by viewModels<DetailViewModelImp>()
    private lateinit var movieEntity: MovieEntity
    private var isCheck = false


    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        viewModel.getDetailMovie(args.id)
        viewModel.getCreditMovie(args.id)
        viewModel.getTrailerMovie(args.id)
        viewModel.checkIsSave(args.id)
        observe()
        setAdapter()
        listenerActions()
        // binding.ivFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_black_24dp))

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

        binding.ivFavorite.setOnClickListener {
            if (isCheck) {
                Log.d("save1", "listenerActions: true")
                val movie = MovieEntity(
                    movieEntity.id,
                    movieEntity.genreIds,
                    movieEntity.originalTitle,
                    movieEntity.voteAverage,
                    movieEntity.releaseDate,
                    movieEntity.posterPath
                )
                binding.ivFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                viewModel.deleteMovie(movie)
            } else {
                Log.d("save1", "listenerActions: false")
                val movie = MovieEntity(
                    movieEntity.id,
                    movieEntity.genreIds,
                    movieEntity.originalTitle,
                    movieEntity.voteAverage,
                    movieEntity.releaseDate,
                    movieEntity.posterPath
                )
                binding.ivFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_black_24dp))
                viewModel.saveMovie(movie)
            }
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

                movieEntity = MovieEntity(
                    it.id,
                    it.genres[0].id,
                    it.title,
                    it.voteAverage,
                    it.releaseDate,
                    it.posterPath
                )
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

        viewModel.movieIsSave.observe(viewLifecycleOwner) {
            isCheck = it
            if (it) {
                binding.ivFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_black_24dp))
            } else {
                binding.ivFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_black_24dp))
            }
        }
    }
}