package com.employee.jpademo.repository;

import com.employee.jpademo.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Respository <T extends Master> extends JpaRepository<T,Integer>{

}
