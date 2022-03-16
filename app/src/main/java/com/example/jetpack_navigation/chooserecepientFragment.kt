package com.example.jetpack_navigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.jetpack_navigation.databinding.FragmentChooserecepientBinding

class chooserecepientFragment : Fragment(), View.OnClickListener{


    var navcontroller : NavController? = null
    lateinit var binding: FragmentChooserecepientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_chooserecepient,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navcontroller = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(binding.inputRecipient1.text.toString())) {
                    val bundle = bundleOf("recipient" to binding.inputRecipient1.text.toString())
                    navcontroller!!.navigate(
                        R.id.action_chooserecepientFragment_to_specifyAmountFragment, bundle)
                }else{
                    Toast.makeText(activity, "Enter an recipient", Toast.LENGTH_SHORT).show()
                }

            }

        }

        }
    }

