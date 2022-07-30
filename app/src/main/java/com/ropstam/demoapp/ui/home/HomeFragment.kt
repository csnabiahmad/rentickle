package com.ropstam.demoapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ropstam.demoapp.app.utilities.AppCommonListner
import com.ropstam.demoapp.databinding.FragmentHomeBinding
import com.ropstam.demoapp.model.CategoriesModel
import com.ropstam.demoapp.ui.ItemDetailsActivity
import com.ropstam.demoapp.ui.adapter.CategoryViewAdapter
import com.ropstam.demoapp.ui.adapter.ProductsViewAdapter

class HomeFragment : Fragment(), AppCommonListner.onProductClick {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    lateinit var categoryAdapter : CategoryViewAdapter
    lateinit var productsAdapter: ProductsViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rvCategory = binding.rvCategories
        val rvProducts = binding.rvProducts
        val rvRecent = binding.rvRecent


        // initialize lists
        homeViewModel.setCategories()
        homeViewModel.setItems()


        // initialize recycler views
        homeViewModel.listOfCategory.observe(viewLifecycleOwner){
            categoryAdapter = CategoryViewAdapter(
                requireContext(),
                it
            )

            rvCategory.layoutManager =  GridLayoutManager(
                requireContext() ,
                3,
                RecyclerView.VERTICAL,
                false
            )
            rvCategory.adapter = categoryAdapter
        }
        homeViewModel.listOfItems.observe(viewLifecycleOwner){
            productsAdapter = ProductsViewAdapter(
                requireContext(),
                it,
                this
            )

            rvProducts.layoutManager =  LinearLayoutManager(
                requireContext() ,
                RecyclerView.HORIZONTAL,
                false
            )
            rvProducts.adapter = productsAdapter

            rvRecent.layoutManager =  LinearLayoutManager(
                requireContext() ,
                RecyclerView.HORIZONTAL,
                false
            )
            rvRecent.adapter = productsAdapter
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProductClicked(model: Any) {

        // starting Item Details Screen
        Intent(requireActivity(),ItemDetailsActivity::class.java).apply {
            startActivity(this)
        }

    }
}