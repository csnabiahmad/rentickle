package com.ropstam.demoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ropstam.demoapp.R
import com.ropstam.demoapp.databinding.ListCategoryViewBinding
import com.ropstam.demoapp.model.CategoriesModel

class CategoryViewAdapter(
    private val context: Context,
    private val data: MutableList<CategoriesModel>)
    : RecyclerView.Adapter<CategoryViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListCategoryViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: CategoriesModel = data[position]
        holder.bind(context,category)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(private val itemBinding: ListCategoryViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(context: Context, mData: CategoriesModel) {

            itemBinding.apply {
                itemImage.load(context.getDrawable(mData.imageURL)){
                    placeholder(R.drawable.furniture)
                    error(R.drawable.furniture)
                }
                tvItemname.text = mData.name
            }

        }


    }
}
