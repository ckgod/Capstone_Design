package com.ckg.appletree.fragment.sign

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.ckg.appletree.R
import com.ckg.appletree.activity.MainActivity
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentLoginBinding
import com.ckg.appletree.databinding.FragmentMainBinding

class LoginFragment() : BaseKotlinFragment<FragmentLoginBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_login

    override val showBottomSheetFlag: Boolean
        get() = false

    override fun initStartView() {
        binding.btnLogin.setOnClickListener {
            val nextIntent = Intent(requireContext(), MainActivity::class.java)
            startActivity(nextIntent)
            requireActivity().finish()
        }
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "LoginFragment"
    }

}