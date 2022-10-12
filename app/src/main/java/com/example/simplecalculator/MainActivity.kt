package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var input = binding.input
        var output = binding.output


        binding.button0.setOnClickListener {
            input.text = addToInputText("0")
        }
        binding.button1.setOnClickListener {
            input.text = addToInputText("1")
        }
        binding.button2.setOnClickListener {
            input.text = addToInputText("2")
        }
        binding.button3.setOnClickListener {
            input.text = addToInputText("3")
        }
        binding.button4.setOnClickListener {
            input.text = addToInputText("4")
        }
        binding.button5.setOnClickListener {
            input.text = addToInputText("5")
        }
        binding.button6.setOnClickListener {
            input.text = addToInputText("6")
        }
        binding.button7.setOnClickListener {
            input.text = addToInputText("7")
        }
        binding.button8.setOnClickListener {
            input.text = addToInputText("8")
        }
        binding.button9.setOnClickListener {
            input.text = addToInputText("9")
        }
        binding.buttonAddition.setOnClickListener {
            input.text = addToInputText("+")
        }
        binding.buttonEquals.setOnClickListener {
            if(showResult(binding.input.text.toString()).toString()=="0"){
                binding.output.text = "Wrong input"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.red_text))
            }else{
                binding.output.text = showResult(binding.input.text.toString()).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.blue_text))
            }
        }
        binding.buttonDelete.setOnClickListener {
            input.text = deleteFromInputText()
        }
        binding.buttonClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${binding.input.text}$buttonValue"
    }

    private fun deleteFromInputText(): String {
        return "${binding.input.text.dropLast(1)}"
    }

   private fun showResult(str: String): Int{
       var sum = 0
       val arr = str.split("+").toTypedArray()
       val ints = IntArray(arr.size)

       for(i in arr){
           if(i.isEmpty()){
               return 0
           }
       }
       arr.indices.forEach { ints[it] = arr[it].toInt() }

       for (i in ints){
           sum += i
       }
       return sum
    }

}