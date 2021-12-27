package com.material.view.chips

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.material.R
import com.material.databinding.FragmentSettingsBinding
import com.material.view.Parameters
import com.material.view.picture.PictureOfTheDayFragment

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    val binding: FragmentSettingsBinding
        get() {
            return _binding!!
        }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.themeGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.theme_light -> Parameters.getInstance().theme = R.style.Theme_Material
                R.id.theme_night -> Parameters.getInstance().theme = R.style.Theme_MaterialAlt
            }
            Parameters.getInstance().resetFragment = true
            requireActivity().recreate()
        }

        binding.chipForDelete.setOnCloseIconClickListener {
            //binding.chipForDelete.visibility = View.GONE
            binding.chipForDelete.isChecked = false
        }

        binding.tabs.getTabAt(0)!!.text = "Работает"
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_one -> {
                    Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
                }
                R.id.navigation_two -> {
                    Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
                }
                R.id.navigation_third -> {
                    Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SettingsFragment()
    }

}