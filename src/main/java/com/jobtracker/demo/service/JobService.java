package com.jobtracker.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobtracker.demo.model.Job;
import com.jobtracker.demo.repo.JobRepository;
@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	public JobService(JobRepository jobRepository )
	{
		this.jobRepository=jobRepository ;
	}
	public Page<Job> getJob(int page, int size)
	{
		Pageable pageable=PageRequest.of(page,size);
		return  jobRepository.findAll(pageable);
	}
	public List<Job> addJobs(List<Job> job) {
		// TODO Auto-generated method stub
		return jobRepository.saveAll(job);
	}
	public void deleteJobs(Integer id) {
		// TODO Auto-generated method stub
		 Job job = jobRepository.findById(id)
		            .orElseThrow(() -> new ResponseStatusException(
		                    HttpStatus.NOT_FOUND,
		                    "Job not found with id: " + id));
		    jobRepository.delete(job);
	}
	public Job updateJob(Integer id, Job job) {
	    Job existingJob = jobRepository.findById(id)
	    		.orElseThrow(() -> new ResponseStatusException(
	                    HttpStatus.NOT_FOUND,
	                    "Job not found with id: " + id));
	    existingJob.setCompany(job.getCompany());
	    existingJob.setRole(job.getRole());
	    existingJob.setStatus(job.getStatus());
	    return jobRepository.save(existingJob);
	}
	public List<Job> getJobBySort(String sortBy, String direcn) {
		// TODO Auto-generated method stub
		Sort.Direction dir=direcn.equalsIgnoreCase("desc")?
				Sort.Direction.DESC:Sort.Direction.ASC;
		Sort sort=Sort.by(dir,sortBy);
		return jobRepository.findAll(sort);
	}
	public Page<Job> getJobBySortAndFilterAndPaging(String company, String status, String role, int page, int size,
			String sortBy, String direcn) {
		// TODO Auto-generated method stub
		Sort.Direction dir=direcn.equalsIgnoreCase("desc")?
				Sort.Direction.DESC:Sort.Direction.ASC;
		Sort sort=Sort.by(dir,sortBy);
		Pageable pageable=PageRequest.of(page,size,sort);
		if(company!=null && role!=null && status!=null )
		{
			return jobRepository.findByCompanyIgnoreCaseAndStatusIgnoreCaseAndRoleIgnoreCase(company,status,role,pageable);
		}
		else if(company!=null && role!=null )
		{
			return jobRepository.findByCompanyIgnoreCaseAndRoleIgnoreCase(company,role,pageable);
		}
		else if(company!=null && status!=null )
		{
			return jobRepository.findByCompanyIgnoreCaseAndStatusIgnoreCase(company,status,pageable);
		}
		else if( role!=null && status!=null )
		{
			return jobRepository.findByStatusIgnoreCaseAndRoleIgnoreCase(status,role,pageable);
		}
		else if (company!=null)
		{
			return jobRepository.findByCompanyIgnoreCase(company,pageable);
		}
		else if(role!=null)
		{
			return jobRepository.findByRoleIgnoreCase(role,pageable);
		}
		else if(status!=null)
		{
			return jobRepository.findByStatusIgnoreCase(status,pageable);
		}
		else
		{
			return jobRepository.findAll(pageable);
		}
	}
	
}
