package com.example.jetpack_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.jetpack_navigation.databinding.FragmentMainBinding


class MainFragment : Fragment(), View.OnClickListener {

      var navcontroller : NavController? = null
    lateinit var binding: FragmentMainBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigationcontroller has refernce to nav_graph
        navcontroller = Navigation.findNavController(binding.root)

        binding.viewTransactionsBtn.setOnClickListener(this)
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       // when is the alternative of switch case
        when(v!!.id){
            R.id.view_transactions_btn -> navcontroller!!.navigate(R.id.action_mainFragment_to_viewtransactionsFragment)
            R.id.send_money_btn -> navcontroller!!.navigate(R.id.action_mainFragment_to_chooserecepientFragment)
            R.id.view_balance_btn -> navcontroller!!.navigate(R.id.action_mainFragment_to_viewbalanceFragment)

        }


    }

}