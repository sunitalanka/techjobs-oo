package org.launchcode.controllers;


import org.launchcode.models.Employer;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.Job;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
        Job rjob = jobData.findById(id);
        model.addAttribute("job", rjob);
        System.out.println("job name" + rjob.getName());

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.
        if (jobForm.getName() != null && !(jobForm.getName().isEmpty())) {


            Job job = new Job(jobForm.getName(), jobForm.getEmployers().get(jobForm.getEmployerId() - 1), jobForm.getLocations().get(jobForm.getLocationId() - 1),
                    jobForm.getPositionTypes().get(jobForm.getPositionTypeId() - 1), jobForm.getCoreCompetencies().get(jobForm.getCoreCompetencyId() - 1));
            jobData.add((job));
            model.addAttribute("title", "All Jobs");
            model.addAttribute("job", job);
            model.addAttribute("id", job.getId());


        }
        return "job-detail";
    }
}
