package com.ckg.appletree.ui.fragment

import android.animation.Animator
import android.content.Intent
import androidx.navigation.findNavController
import com.ckg.appletree.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.ckg.appletree.ApplicationClass.Companion.spToken
import com.ckg.appletree.R
import com.ckg.appletree.ui.activity.MainActivity
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentSplashBinding

class SplashFragment() : BaseKotlinFragment<FragmentSplashBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_splash

    override fun initStartView() {
        binding.splash.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                val jwtToken: String? = spToken?.getString(X_ACCESS_TOKEN, null)
                if(jwtToken == null) {
                    view?.findNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
                }
                else {
                    val nextIntent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(nextIntent)
                    requireActivity().finish()
                }
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }

        })
//        Handler().postDelayed({
//
//        }, SPLASH_TIME_OUT)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "SplashFragment"
        const val SPLASH_TIME_OUT: Long = 3000
    }
}