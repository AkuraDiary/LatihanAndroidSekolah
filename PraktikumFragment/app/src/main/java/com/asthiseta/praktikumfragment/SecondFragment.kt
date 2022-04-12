package com.asthiseta.praktikumfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class SecondFragment : Fragment() {
    private var myViewModel: MyViewModel? = null
    private var txtName: TextView? = null
    private var txtAlamat: TextView? = null
    private var txtTelp: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myViewModel = ViewModelProviders.of(requireActivity()).get(MyViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile,
            container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.textViewName)
        txtAlamat = view.findViewById(R.id.textViewAlamat)
        txtTelp = view.findViewById(R.id.textViewNoTelp)

        myViewModel!!.apply {
            name.observe(requireActivity()
            ) { s -> txtName!!.text = s }

            alamat.observe(requireActivity()
            ) { s -> txtAlamat!!.text = s }

            telp.observe(requireActivity()
            ) { s -> txtTelp!!.text = s }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myViewModel!!.name.removeObservers(requireActivity())
        txtAlamat = null
        txtName = null
        txtTelp = null
    }
    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}