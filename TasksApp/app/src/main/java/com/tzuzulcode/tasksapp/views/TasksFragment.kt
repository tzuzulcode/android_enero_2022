package com.tzuzulcode.tasksapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tzuzulcode.tasksapp.data.source.local.TaskDatabase
import com.tzuzulcode.tasksapp.adapters.TaskItemAdapter
import com.tzuzulcode.tasksapp.databinding.FragmentTasksBinding
import com.tzuzulcode.tasksapp.viewmodels.TasksViewModel
import com.tzuzulcode.tasksapp.viewmodels.TasksViewModelFactory

class TasksFragment : Fragment() {

    //Agregar Binding
    private  var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTasksBinding.inflate(inflater,container,false)
        val view = binding.root

        val application = requireNotNull(this.activity).application

        val dao = TaskDatabase.getInstance(application).taskDao

        val viewModelFactory = TasksViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(TasksViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = TaskItemAdapter{ taskId ->
            viewModel.onTaskClicked(taskId)
        }
        binding.tasksList.adapter = adapter

        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.navigateToTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                Toast.makeText(context,"Clicked task $it",Toast.LENGTH_SHORT).show()
                val action = TasksFragmentDirections.actionTasksFragmentToEditTaskFragment(it)
                this.findNavController().navigate(action)
            }
        })

        return view
    }
}