package com.example.login.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.login.R
import com.example.login.databinding.LogInFragmentBinding

class LogInFragment : Fragment() {

    private lateinit var viewModel: LogInViewModel

    private lateinit var binding: LogInFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.log_in_fragment,
            container,
            false
        )

        Log.i("LogIn", "Called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(LogInViewModel::class.java)

        binding.logInViewModel = viewModel
        binding.setLifecycleOwner (this)

        binding.firstNameButton.setOnClickListener {
            viewModel.updateFirstName(binding.firstNameEditBox.text.toString())
            Log.i("LogIn", "First name: ${viewModel.firstname.value}")
        }

        binding.lastNameButton.setOnClickListener {
            viewModel.updateLastName(binding.lastNameEditBox.text.toString())
            Log.i("LogIn", "Last name: ${viewModel.lastname.value}")
        }

        binding.userNameButton.setOnClickListener {
            viewModel.updateUserName(binding.userNameEditBox.text.toString())
            Log.i("LogIn", "User name: ${viewModel.username.value}")
        }

        viewModel.eventLogInFinish.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) {
                val action =LogInFragmentDirections.actionLogInDestinationToLoggedInFragment()
                findNavController(this).navigate(action)
                viewModel.onCanWePassComplete()
            }
        })

        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()
//        ).get(LogInViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}

