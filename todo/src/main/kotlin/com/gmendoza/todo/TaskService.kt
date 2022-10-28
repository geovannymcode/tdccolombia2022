package com.gmendoza.todo

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class TaskService(val repository: TaskRepository){
    fun  getAll() = repository.findAll()
    fun save(task: Task) = repository.save(task)
    fun delete(id: Long): Boolean{
        val found = repository.existsById(id)
        if(found){
            repository.deleteById(id)
        }
        return found
    }
}