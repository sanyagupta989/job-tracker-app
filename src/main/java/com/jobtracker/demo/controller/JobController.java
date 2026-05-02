package com.jobtracker.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.demo.model.Job;
import com.jobtracker.demo.service.JobService;

@RestController
@RequestMapping("api/v1/job")
public class JobController {
	private final JobService jobService;
	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	// with paging
	@GetMapping("/paging")
	public Page<Job> getJobs(@RequestParam (defaultValue = "0") int page,
			@RequestParam (defaultValue="5") int size
	)
	{
		
		return jobService.getJob(page,size);
	} 
//	@GetMapping("/filter")
//	public List<Job> getJobsByFilter(@RequestParam (required=false) String company,
//			@RequestParam (required=false) String status,
//			@RequestParam (required=false) String role
//	)
//	{
//		
//		return jobService.getJobByFilter(company,status,role);
//	} 
	@GetMapping("/sort")
	public List<Job> getJobBySort(@RequestParam (defaultValue = "jobID") String sortBy,
			@RequestParam (defaultValue="asc") String direcn)
	{
		return jobService.getJobBySort(sortBy,direcn);
	}
//	@GetMapping("/sort/filter")
//	public List<Job> getJobBySortAndFilter(
//			@RequestParam (required=false) String company,
//			@RequestParam (required=false) String status,
//			@RequestParam (required=false) String role,
//			@RequestParam (defaultValue="jobID") String sortBy,
//			@RequestParam (defaultValue="asc") String direcn)
//	{
//		return jobService.getJobBySortAndFilter(company,status,role,sortBy,direcn);
//	}
	@GetMapping("/sort/filter/paging")
	public Page<Job> getJobBySortAndFilterAndPaging(
			@RequestParam (required=false) String company,
			@RequestParam (required=false) String status,
			@RequestParam (required=false) String role,
			@RequestParam (defaultValue="0") int page,
			@RequestParam (defaultValue="5") int size,
			@RequestParam (defaultValue="jobID") String sortBy,
			@RequestParam (defaultValue="asc") String direcn
			)
	{
		return jobService.getJobBySortAndFilterAndPaging(company,status,role
				
				,page,size,sortBy,direcn);
	}
	
	@PostMapping("/add")
	public List<Job> addJob(@RequestBody List<Job> job)
	{
		return jobService.addJobs(job);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable Integer id)
	{  
		 jobService.deleteJobs(id);
		 return ResponseEntity.noContent().build(); //Deleted Successful no content to show
	}
	@PutMapping("/update/{id}")
	public 	Job updateJob(@PathVariable Integer id,@RequestBody Job job)
	{
		return (jobService.updateJob(id,job));
	}
}
