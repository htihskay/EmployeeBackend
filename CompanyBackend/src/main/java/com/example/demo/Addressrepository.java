package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Addressrepository extends JpaRepository<Address, Integer> {

}
