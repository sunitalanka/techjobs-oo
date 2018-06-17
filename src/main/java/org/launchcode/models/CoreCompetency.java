package org.launchcode.models;

import static org.launchcode.models.JobFieldType.CORE_COMPETENCY;

/**
 * Created by LaunchCode
 */
public class CoreCompetency extends JobField {

    public CoreCompetency(String value)
    {
        //super(value);
        super(value, CORE_COMPETENCY);
    }
}
