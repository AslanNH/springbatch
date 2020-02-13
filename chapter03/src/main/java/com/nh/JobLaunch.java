package com.nh;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JobLaunch {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("job/job.xml");
        JobLauncher launcher = (JobLauncher)context.getBean("jobLauncher");

        Job job = (Job)context.getBean("billJob");
        try{
            JobExecution result = launcher.run(job,new JobParametersBuilder().addString("date","20130309").toJobParameters());
            System.out.println(result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
