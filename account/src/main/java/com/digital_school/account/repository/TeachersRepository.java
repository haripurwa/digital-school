package com.digital_school.account.repository;

import com.digital_school.account.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeachersRepository extends JpaRepository<Teachers, String> {
}
