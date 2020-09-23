package com.lawrence.BeautyQuotient.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawrence.BeautyQuotient.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

}