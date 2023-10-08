package com.example.demo.onetomany.example.respository;


import com.example.demo.onetomany.example.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<Category,Integer> {

}
