package com.example.listchoiceapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.listchoiceapp.R
import com.example.listchoiceapp.data.Items
import com.example.listchoiceapp.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener=object :
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                insertDataToDatabase()
            }
        }



        return view
    }

    private fun insertDataToDatabase() {
        val materia=spinner.selectedItemPosition.toString()
        val items=Items(materia)
        mUserViewModel.addUser(items)
        Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment2)



    }

    val materias = arrayOf("geografia", "matematica", "lengua", "ingles")
    val arrayAdapter=ArrayAdapter(requireContext() ,android.R.layout.simple_spinner_item,materias)


}