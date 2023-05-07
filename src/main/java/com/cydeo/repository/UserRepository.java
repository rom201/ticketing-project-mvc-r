package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);//check for @Where on the class

    @Transactional //for derived queries, for persisteen or deleted
    void deleteByUserName( String username);
//  if ddl operetion @Modifiing for native  and JPQL  when use @Query
    // can be putedd on top of service class

    List<User> findAllByRoleDescriptionIgnoreCase(String description);


}
