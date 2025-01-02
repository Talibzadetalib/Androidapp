package com.example.androidapp.signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidapp.CoreFragment
import com.example.androidapp.MainActivity
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentSigninBinding


class SignInFragment : CoreFragment<FragmentSigninBinding>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.registerNowTv?.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_createAccountFragment)
        }
        binding?.signInLinear?.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_createAccountFragment)
            validateAndLogin()
        }

    }
    private fun validateAndLogin() {
        val email = binding?.inputTextSignIn?.text.toString()
        val password = binding?.inputPasswordSignIn?.text.toString()

        // Clear previous errors
        binding?.inputTextSignIn?.error = null
        binding?.inputPasswordSignIn?.error = null

        // Validate credentials
        when {
            !isValidEmail(email) -> binding?.inputTextSignIn?.error = "Invalid email format"
            password.length < 4 -> binding?.inputPasswordSignIn?.error = "Password must be at least 4 characters"
            email == "test@te.st" && password == "1234" -> navigateToMain()
            else -> {
                binding?.inputTextSignIn?.error = "Invalid email or password"
                binding?.inputPasswordSignIn?.error = "Invalid email or password"
            }
        }
    }

    private fun navigateToMain() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}