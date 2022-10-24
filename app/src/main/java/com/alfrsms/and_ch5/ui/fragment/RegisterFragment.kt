package com.alfrsms.and_ch5.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alfrsms.and_ch5.R
import com.alfrsms.and_ch5.data.AppDatabase
import com.alfrsms.and_ch5.data.user.entity.UserEntity
import com.alfrsms.and_ch5.databinding.FragmentRegisterBinding
import com.alfrsms.and_ch5.ui.viewmodel.LoginViewModelFactory
import com.alfrsms.and_ch5.ui.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var registerViewModel : RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).accountDatabaseDao()
        val viewModelFactory = LoginViewModelFactory(dataSource, application)
        registerViewModel = ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]

        binding.btnRegister.setOnClickListener{ toCreateAccount() }
    }

    private fun toCreateAccount() {
        val usernameRegist = binding.etRegisterUsername.text.toString()
        val emailRegist = binding.etRegisterEmail.text.toString()
        val passwordRegist = binding.etRegisterPassword.text.toString()
        val confirmPasswordRegist = binding.etRegisterConfirmPassword.text.toString()

        registerViewModel.insertAccount(
            UserEntity(userName = usernameRegist,
                email = emailRegist, password = passwordRegist)
        )
        Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}