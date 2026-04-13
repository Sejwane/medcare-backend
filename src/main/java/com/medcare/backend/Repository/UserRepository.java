package com.medcare.backend.Repository;

import com.medcare.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    
    @Modifying
    @Query(value = "UPDATE users SET is_deleted = false WHERE id = :id", nativeQuery = true)
    void restoreUser(@Param("id") Integer id);
}