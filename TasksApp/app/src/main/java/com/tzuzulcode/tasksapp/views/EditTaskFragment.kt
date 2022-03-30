package com.tzuzulcode.tasksapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.tzuzulcode.tasksapp.R
import com.tzuzulcode.tasksapp.adapters.StepItemAdapter
import com.tzuzulcode.tasksapp.data.source.local.TaskDatabase
import com.tzuzulcode.tasksapp.databinding.FragmentEditTaskBinding
import com.tzuzulcode.tasksapp.viewmodels.EditTaskViewModel
import com.tzuzulcode.tasksapp.viewmodels.EditTaskViewModelFactory


class EditTaskFragment : Fragment() {

    private var _binding :FragmentEditTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditTaskBinding.inflate(inflater,container,false)

        val view = binding.root
        val taskId = EditTaskFragmentArgs.fromBundle(requireArguments()).taskId

        val application = requireNotNull(this.activity).application

        val dao = TaskDatabase.getInstance(application).taskDao
        val stepDao = TaskDatabase.getInstance(application).stepDao

        val viewModelFactory = EditTaskViewModelFactory(taskId,dao,stepDao)

        val viewModel = ViewModelProvider(this,viewModelFactory).get(EditTaskViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = StepItemAdapter()

        binding.steps.adapter = adapter

        viewModel.task.observe(viewLifecycleOwner, Observer {
            Log.d("Pasos",it.steps.toString())
            adapter.submitList(it.steps)
        })

        viewModel.navigateToList.observe(viewLifecycleOwner, Observer { navigate->
            if(navigate){
                view.findNavController().navigate(R.id.action_editTaskFragment_to_tasksFragment)
                viewModel.onNavigatedToList()
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}