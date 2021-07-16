package com.itz.iwas.usecases.auth;

import com.itz.iwas.models.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<UserMaster, Long> {
    //    @Query(value = "select TOP 1 * " +
//            "from userInfo where userId = :username",nativeQuery = true)
    UserMaster findByUserId(String username);
}
