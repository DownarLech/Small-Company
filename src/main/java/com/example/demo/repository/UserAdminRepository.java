package com.example.demo.repository;

import com.example.demo.model.UserAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends CrudRepository<UserAdmin, Integer> {
}
