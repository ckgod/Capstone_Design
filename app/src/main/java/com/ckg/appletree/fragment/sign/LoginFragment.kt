package com.ckg.appletree.fragment.sign

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ckg.appletree.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.ckg.appletree.R
import com.ckg.appletree.activity.MainActivity
import com.ckg.appletree.api.model.LoginRequest
import com.ckg.appletree.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentLoginBinding
import com.ckg.appletree.databinding.FragmentMainBinding

class LoginFragment() : BaseKotlinFragment<FragmentLoginBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_login

    override val showBottomSheetFlag: Boolean
        get() = false

    private val viewModel by lazy { LoginViewModel() }

    override fun initStartView() {
        binding.btnLogin.setOnClickListener {
            showProgress()
            viewModel.postLogin(LoginRequest(binding.etEmail.text.toString(), binding.etPassword.text.toString()))
        }
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
        viewModel.loginResponse.observe(this@LoginFragment, Observer {
            hideProgress()
            if(it == null) {
                showNetworkError()
            }
            else {
                Log.d(TAG, it.msg)
                if(it.code == 200) {
                    it.data?.let { it1 -> Log.d(TAG, it1) }
                    val preferences: SharedPreferences = requireContext().getSharedPreferences(X_ACCESS_TOKEN, Context.MODE_PRIVATE)
                    val editor = preferences.edit()
                    editor.putString(X_ACCESS_TOKEN, it.data)
                    editor.apply()
                    val nextIntent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(nextIntent)
                    requireActivity().finish()
                }
                else {
                    showCustomToast(it.msg)
                }
            }
        })
    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "LoginFragment"
    }

}