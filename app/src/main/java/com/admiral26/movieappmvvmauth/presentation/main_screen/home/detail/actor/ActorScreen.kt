package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail.actor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.adapter.movie.actor.ActorImageAdapter
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.databinding.ScreenActorBinding
import com.admiral26.movieappmvvmauth.util.view_pager_transformation.OverlapSliderTransformer

class ActorScreen : BaseFragment(R.layout.screen_actor) {
    private val binding by viewBinding(ScreenActorBinding::bind)
    private val viewModel: ActorViewModel by viewModels<ActorViewModelImp>()
    private val imageAdapter by lazy { ActorImageAdapter() }
    private val args: ActorScreenArgs by navArgs()
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getActorImage(args.actorId)
        viewModel.getActorDetail(args.actorId)
        listenerActions()
        observe()
        setAdapter()
    }

    private fun setAdapter() {
        binding.viewPager.adapter = imageAdapter
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.setPageTransformer(OverlapSliderTransformer(ViewPager2.ORIENTATION_HORIZONTAL))

    }

    private fun listenerActions() {

    }

    private fun observe() {
        viewModel.getImageLd.observe(viewLifecycleOwner) {
            it?.let {
                imageAdapter.setData(it.profiles)
            }
        }
        viewModel.getDetailLd.observe(viewLifecycleOwner) {
            it?.let {
                binding.actorName.text = it.name
                binding.biography.text = it.biography
            }
        }
    }
}