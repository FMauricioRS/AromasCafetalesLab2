package com.fmauriciors.aromascafetaleslab2.ui.listproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fmauriciors.aromascafetaleslab2.R
import com.fmauriciors.aromascafetaleslab2.databinding.FragmentListProductBinding

class ListProductFragment : Fragment() {

    companion object {
        fun newInstance() = ListProductFragment()
    }

    private lateinit var listProductBinding: FragmentListProductBinding
    private lateinit var listProductViewModel: ListProductViewModel
    //private lateinit var productsAdapter: ProductsAdapter
    //private var productsList: ArrayList<Product> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listProductBinding = FragmentListProductBinding.inflate(inflater, container, false)
        listProductViewModel = ViewModelProvider(this)[ListProductViewModel::class.java]
        return listProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        listProductViewModel.loadProductDone.observe(viewLifecycleOwner) { result ->
            onLoadProductsDoneSubscribe(result)
        }

        listProductsViewModel.loadProducts()

        productsAdapter = ProductsAdapter(productsList)

        listProductsBinding.productsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListProductsFragment.requireContext())
            adapter = productsAdapter
            setHasFixedSize(false)
        }*/
        listProductBinding.newProductButton.setOnClickListener {
            findNavController().navigate(ListProductFragmentDirections.actionListProductFragmentToNewProductFragment())
        }
    }


}