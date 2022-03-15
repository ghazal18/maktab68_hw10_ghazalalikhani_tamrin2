package com.example.myapplication


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentHintBinding

class HintFragment : Fragment() {
    lateinit var binding: FragmentHintBinding
    private val args : HintFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHintBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonShowAnswer.setOnClickListener {
            var answer = args.answer

            Toast.makeText(activity, "answer is $answer", Toast.LENGTH_SHORT).show()


        }
    }

}