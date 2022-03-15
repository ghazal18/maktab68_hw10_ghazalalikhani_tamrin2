package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentQustionBinding


class QustionFragment : Fragment() {
    lateinit var binding: FragmentQustionBinding
    var question = arrayListOf(
        "There are 219 episodes of Friends",
        "Prince Harry is taller than Prince William",
        "The star sign Aquarius is represented by a tiger",
        "Meryl Streep has won two Academy Awards",
        "Marrakesh is the capital of Morocco",
        "Idina Menzel sings 'let it go' 20 times in 'Let It Go' from Frozen",
        "Waterloo has the greatest number of tube platforms in London",
        "M&M stands for Mars and Moordale",
        "Gin is typically included in a Long Island Iced Tea",
        "'A' is the most common letter used in the English language"

    )
    var answer = arrayListOf(false, false, true, false, false, false, true, false, true, false)
    var questionNum = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQustionBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.textViewQuestion.text = question[questionNum]
        binding.buttonPrv.isEnabled = false


        binding.buttonTrue.setOnClickListener {
            var correctAnswer: Boolean = answer[questionNum]
            if (correctAnswer) {
                Toast.makeText(activity, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Wrong", Toast.LENGTH_SHORT).show()
            }

        }

        binding.buttonFalse.setOnClickListener {
            var correctAnswer: Boolean = answer[questionNum]
            if (!correctAnswer) {
                Toast.makeText(activity, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Wrong", Toast.LENGTH_SHORT).show()
            }

        }

        binding.buttonNext.setOnClickListener {
            binding.buttonPrv.isEnabled = true
            questionNum++
            binding.textViewQuestion.text = question[questionNum]
            if (questionNum == 9) {
                binding.buttonNext.isEnabled = false

            }

        }
        binding.buttonPrv.setOnClickListener {
            questionNum--
            binding.textViewQuestion.text = question[questionNum]
        }
        binding.buttonCheat.setOnClickListener {
            var answer = answer[questionNum]


            val action =
                QustionFragmentDirections.actionQustionFragmentToHintFragment(answer = answer)
            findNavController().navigate(action)
        }


    }


}


