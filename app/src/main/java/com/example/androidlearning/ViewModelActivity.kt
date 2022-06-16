package com.example.androidlearning

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidlearning.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity(), LifecycleOwner{

    private val viewModel: ViewModelActivityViewModel by viewModels()

    private lateinit var binding : ActivityViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)
        setContentView(binding.root)

        binding.textView.text = viewModel.number.toString();

        binding.button.setOnClickListener{
            viewModel.addNumber();
            binding.textView.text = viewModel.number.toString();

        }

        viewModel.seconds().observe(this, Observer {
            binding.textView2.text = (it+1).toString()
        })
        viewModel.finished().observe(this, Observer {
            if (it){
                binding.textView2.text = "0"
                Toast.makeText(this, "Finished!", Toast.LENGTH_SHORT).show()
            }
        })

        binding.button2.setOnClickListener{
            if(binding.editTextNumber.text.isEmpty() || binding.editTextNumber.text.length < 4)
                Toast.makeText(this,"Invalid Number", Toast.LENGTH_SHORT).show()
            else
            {
                viewModel.timerValue.value = binding.editTextNumber.text.toString().toLong()
                viewModel.startTimer()
            }
        }
        binding.button3.setOnClickListener{
            binding.textView2.text = "0"
            viewModel.stopTimer()
        }




    }
}