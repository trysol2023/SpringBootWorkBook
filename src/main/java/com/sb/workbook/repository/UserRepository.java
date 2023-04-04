package com.sb.workbook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.workbook.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

}
