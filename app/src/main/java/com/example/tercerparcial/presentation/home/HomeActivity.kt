package com.example.tercerparcial.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.tercerparcial.data.repository.FakePlanRepository
import com.example.tercerparcial.databinding.ActivityHomeBinding
import com.example.tercerparcial.domain.usecase.GetPlansUseCase
import android.content.Intent

class HomeActivity : ComponentActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory(GetPlansUseCase(FakePlanRepository()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PlanAdapter(viewModel.plans)
        binding.viewPager.adapter = adapter

        binding.btnPrev.setOnClickListener {
            binding.viewPager.currentItem = (binding.viewPager.currentItem - 1).coerceAtLeast(0)
        }

        binding.btnNext.setOnClickListener {
            binding.viewPager.currentItem = (binding.viewPager.currentItem + 1).coerceAtMost(adapter.itemCount - 1)
        }

        binding.btnSendSim.setOnClickListener {
            val intent = Intent(this, SendSimActivity::class.java)
            startActivity(intent)
        }
    }
}