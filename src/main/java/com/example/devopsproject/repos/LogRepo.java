package com.example.devopsproject.repos;

import com.example.devopsproject.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Log, Long> {
}
