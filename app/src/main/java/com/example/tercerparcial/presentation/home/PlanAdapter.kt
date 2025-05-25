package com.example.tercerparcial.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tercerparcial.databinding.ItemPlanBinding
import com.example.tercerparcial.domain.model.Plan

class PlanAdapter(private val plans: List<Plan>) : RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {

    inner class PlanViewHolder(private val binding: ItemPlanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(plan: Plan) {
            binding.tvPlanName.text = plan.name
            binding.tvOldPrice.text = "Antes: $${plan.oldPrice}"
            binding.tvNewPrice.text = "Ahora: $${plan.newPrice}"
            binding.tvData.text = "${plan.dataGB}GB"
            binding.tvFeatures.text = plan.features.joinToString("\n")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val binding = ItemPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanViewHolder(binding)
    }

    override fun getItemCount(): Int = plans.size

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        holder.bind(plans[position])
    }
}
