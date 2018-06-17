package org.launchcode.models;

import static org.launchcode.models.JobFieldType.EMPLOYER;

/**
 * Created by LaunchCode
 */
public class Employer extends JobField {

    public Employer(String value)
    {
       // super(value);
        super(value, EMPLOYER);
    }
}
