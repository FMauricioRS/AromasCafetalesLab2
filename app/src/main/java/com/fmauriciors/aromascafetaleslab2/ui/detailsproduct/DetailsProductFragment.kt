package com.fmauriciors.aromascafetaleslab2.ui.detailsproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmauriciors.aromascafetaleslab2.R

class DetailsProductFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsProductFragment()
    }

    private lateinit var viewModel: DetailsProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsProductViewModel::class.java)
        // TODO: Use the ViewModel
    }

}