package com.example.innerbottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.innerbottomnav.databinding.FragmentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fragmentContainer2: FragmentContainerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
        setNavigationListener()
    }

    private fun setNavigationListener() {
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fragmentA -> {
                    showToast("fragment a")
                    fragmentContainer2.findNavController().navigate(R.id.fragmentA)
                    true
                }
                R.id.fragmentB -> {
                    showToast("fragment b")
                    fragmentContainer2.findNavController().navigate(R.id.fragmentB)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupNavigation() {
        fragmentContainer2 = binding.navHostFragment2
        navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        bottomNavigationView = binding.bottomNav
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)
    }

    fun showToast(s: String) {
        Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show()
    }
}