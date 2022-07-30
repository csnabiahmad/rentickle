package com.ropstam.demoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ropstam.demoapp.R
import com.ropstam.demoapp.app.AppCommonListner
import com.ropstam.demoapp.databinding.ListItemViewBinding
import com.ropstam.demoapp.model.ItemModel

class ProductsViewAdapter (
    private val context: Context,
    private val data: List<ItemModel>,
    private val listener: AppCommonListner.onProductClick)
    : RecyclerView.Adapter<ProductsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product: ItemModel = data[position]
        holder.bind(context,product,listener)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(private val itemBinding: ListItemViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(context: Context, mData: ItemModel, listener: AppCommonListner.onProductClick) {

            itemBinding.apply {
                itemImage.load(mData.imageURL){
                    placeholder(R.drawable.furniture)
                    error(R.drawable.furniture)
                }
                tvItemname.text = mData.itemName
                tvItemprice.text = mData.itemPrice

                itemImage.setOnClickListener {
                    listener.onProductClicked(mData)
                }
            }

        }


    }
}
