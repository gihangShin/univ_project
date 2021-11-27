package com.univ.app.model.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from user where user.user_Id = ?1 and user.user_Password = ?2", nativeQuery = true)
	Optional<User> findByUserIdAndUserPassword(String userId, String userPassword);

}