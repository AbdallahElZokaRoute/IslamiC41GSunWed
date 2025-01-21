package com.route.islamiappc41gsunwed.home.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.route.islamiappc41gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    var counter :Int = 0
    var zeker : Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.zekrCountText.text = counter.toString()
        onClickScreen()
        checkZekerDisplayed()
    }

    private fun onClickScreen(){
        binding.root.setOnClickListener{
            rotateImage(binding.seb7aBodyImage)
            incrementCounter()
        }
    }

    private fun rotateImage(image: ImageView) {
           val  rotate = ObjectAnimator.ofFloat(image,"rotation",0f,20f)
        rotate.duration= 1000
        rotate.start()
    }


    private fun incrementCounter(){

        if(counter < 33){
            counter++
        }
        else{
            counter = 0
            checkZekerDisplayed()

        }
        binding.zekrCountText.text = counter.toString()

    }


    private fun checkZekerDisplayed(){

        when (zeker) {
            0 -> {
                zeker++
                binding.zekrText.text =" سبحان الله "

            }
            1 -> {
                binding.zekrText.text =  " الحمدالله "
                zeker++
            }
            2 -> {
                binding.zekrText.text =   " لا اله الا الله "
                zeker++
            }
            3 ->{
                binding.zekrText.text =  " الله اكبر "
                zeker = 0
            }

        }

    }

}
