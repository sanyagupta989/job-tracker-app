package com.jobtracker.demo.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobtracker.demo.model.Job;
@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
	

	Page<Job> findByCompanyIgnoreCaseAndStatusIgnoreCaseAndRoleIgnoreCase(String company, String status, String role, Pageable pageable);

	Page<Job> findByCompanyIgnoreCaseAndStatusIgnoreCase(String company, String status,Pageable pageable);

	Page<Job> findByCompanyIgnoreCaseAndRoleIgnoreCase(String company, String role,Pageable pageable);

	Page<Job> findByStatusIgnoreCaseAndRoleIgnoreCase(String status, String role, Pageable pageable);

	Page<Job> findByCompanyIgnoreCase(String company, Pageable pageable);

	Page<Job> findByStatusIgnoreCase(String status, Pageable pageable);

	Page<Job> findByRoleIgnoreCase(String role, Pageable pageable);


}
