package com.capitalone.sage.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchRunner {

	// Read from flat file, process and write to database

	public static void main(String[] args) {

		// Creating application context object
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch-context.xml");

		// Creating the job luncher
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		// Creating the job
		Job job = (Job) context.getBean("payment-accounts.tokenization");

		// Execution the JOB
		JobExecution execution;
		try {
			execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit status : " + execution.getStatus());
		} catch (JobExecutionAlreadyRunningException e) {
			System.out.println("Job fileStore failed");
			e.printStackTrace();
		} catch (JobRestartException e) {
			System.out.println("Job fileStore failed");
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			System.out.println("Job fileStore failed");
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			System.out.println("Job fileStore failed");
			e.printStackTrace();
		}
	}

}
