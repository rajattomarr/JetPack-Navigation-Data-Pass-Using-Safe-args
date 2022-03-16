package com.example.jetpack_navigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.jetpack_navigation.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(),View.OnClickListener {

   lateinit var navcontroller : NavController
     var recipient: String? = null
    lateinit var binding: FragmentSpecifyAmountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       recipient = arguments!!.getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_specify_amount,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navcontroller = Navigation.findNavController(view)

     binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
        val message = "sending money to $recipient"
        view.findViewById<TextView>(R.id.recipient).text = message
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.send_btn ->{
                if(!TextUtils.isEmpty(binding.inputAmount.text.toString())){
                    val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                    val bundle = bundleOf("recipient" to recipient,"amount" to amount)
                    navcontroller!!.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle)
                }
                else{
                    Toast.makeText(activity, "Enter an amount ", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

}