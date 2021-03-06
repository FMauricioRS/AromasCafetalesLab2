package com.fmauriciors.aromascafetaleslab2.ui.newproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fmauriciors.aromascafetaleslab2.R
import com.fmauriciors.aromascafetaleslab2.databinding.FragmentNewProductBinding

class NewProductFragment : Fragment() {

    companion object {
        fun newInstance() = NewProductFragment()
    }

    private lateinit var newProductBinding: FragmentNewProductBinding
    private lateinit var newProductViewModel: NewProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        newProductBinding = FragmentNewProductBinding.inflate(inflater, container, false)
        newProductViewModel = ViewModelProvider(this)[NewProductViewModel::class.java]
        return newProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newProductViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }
        newProductViewModel.dataValidated.observe(viewLifecycleOwner) { result ->
            onDataValidatedSubscribe(result)

            with(newProductBinding) {


                saveProductButton.setOnClickListener {

                    newProductViewModel.validateFields(
                        nameProductEditText.text.toString(),
                        costProductEditText.text.toString(),
                        resumeProductEditText.text.toString()
                    )
                }
            }

        }

    }

    private fun onDataValidatedSubscribe(result: Boolean) {
        with(newProductBinding) {
            val nameProduct: String = nameProductEditText.text.toString()
            val cost = costProductEditText.text.toString()
            val resumePlantation = resumeProductEditText.text.toString()

            newProductViewModel.saveProduct(nameProduct, cost, resumePlantation)

        }

    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()

    }

}