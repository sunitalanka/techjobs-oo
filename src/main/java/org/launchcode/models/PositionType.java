package org.launchcode.models;

import static org.launchcode.models.JobFieldType.POSITION_TYPE;

/**
 * Created by LaunchCode
 */
public class PositionType extends JobField {

    public PositionType(String value)
    {
        //super(value);
        super(value, POSITION_TYPE);
    }

}
