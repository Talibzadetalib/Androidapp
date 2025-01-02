package com.example.androidapp.createaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidapp.CoreFragment
import com.example.androidapp.CredentialsManager
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentCreateAccountBinding


class CreateAccountFragment : CoreFragment<FragmentCreateAccountBinding>(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.backToSignIn?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding?.createAccountLinear?.setOnClickListener {
            val email = binding?.inputTextCA2?.text.toString()
            val password = binding?.passwordTextEditText?.text.toString()

            val registrationSuccess = CredentialsManager.register(email, password)

            if (registrationSuccess) {
                Toast.makeText(
                    requireContext(),
                    "Registration successful: $email",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Registration failed: Email already exists",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}