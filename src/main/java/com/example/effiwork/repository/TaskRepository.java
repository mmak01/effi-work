package com.example.effiwork.repository;

import com.example.effiwork.entity.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Tasks, String> {

}
