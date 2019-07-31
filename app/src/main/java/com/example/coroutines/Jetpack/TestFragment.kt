package com.example.coroutines.Jetpack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class TestFragment : Fragment() {

    init {

        lifecycleScope.launchWhenCreated {

        }

        lifecycleScope.launchWhenStarted {

        }

        lifecycleScope.launchWhenResumed {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {

            //TODO 做一些View相关的的计算操作等
        }

    }
}