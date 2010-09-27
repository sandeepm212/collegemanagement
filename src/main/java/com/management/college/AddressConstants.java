package com.management.college;

import java.util.ArrayList;
import java.util.List;

import com.management.college.model.LabelValue;

public class AddressConstants {

    public static final String     usStateNames[] = {
        "Alabama",
        "Alaska",
        "American Samoa",
        "Arizona",
        "Arkansas",
        "California",
        "Colorado",
        "Connecticut",
        "Delaware",
        "District of Columbia",
        "Florida",
        "Georgia",
        "Guam ",
        "Hawaii",
        "Idaho",
        "Illinois",
        "Indiana",
        "Iowa",
        "Kansas",
        "Kentucky",
        "Louisiana",
        "Maine",
        "Maryland",
        "Massachusetts",
        "Michigan",
        "Minnesota",
        "Mississippi",
        "Missouri",
        "Montana",
        "Nebraska",
        "Nevada",
        "New Hampshire",
        "New Jersey",
        "New Mexico",
        "New York",
        "North Carolina",
        "North Dakota",
        "Northern Mariana Islands",
        "Ohio",
        "Oklahoma",
        "Oregon",
        "Pennsylvania",
        "Puerto Rico",
        "Rhode Island",
        "South Carolina",
        "South Dakota",
        "Tennessee",
        "Texas",
        "Utah",
        "Vermont",
        "Virgin Islands",
        "Virginia",
        "Washington",
        "West Virginia",
        "Wisconsin",
        "Wyoming"                                };

    /**
     * The list of 2-letter codes of the states in the US.
     */
    public static final String     usStateCodes[] = {
        "AL",
        "AK",
        "AS",
        "AZ",
        "AR",
        "CA",
        "CO",
        "CT",
        "DE",
        "DC",
        "FL",
        "GA",
        "GU",
        "HI",
        "ID",
        "IL",
        "IN",
        "IA",
        "KS",
        "KY",
        "LA",
        "ME",
        "MD",
        "MA",
        "MI",
        "MN",
        "MS",
        "MO",
        "MT",
        "NE",
        "NV",
        "NH",
        "NJ",
        "NM",
        "NY",
        "NC",
        "ND",
        "MP",
        "OH",
        "OK",
        "OR",
        "PA",
        "PR",
        "RI",
        "SC",
        "SD",
        "TN",
        "TX",
        "UT",
        "VT",
        "VI",
        "VA",
        "WA",
        "WV",
        "WI",
        "WY"                                     };

    /**
     * 
     */
    public static List<LabelValue> usStatesList;
    static {
        usStatesList = loadUSStates();
    }

    private static List<LabelValue> loadUSStates() {
        List<LabelValue> states = new ArrayList<LabelValue>(51);

        for (int i = 0; i < usStateNames.length; i++) {
            states.add(new LabelValue(usStateNames[i], usStateCodes[i]));
        }

        return states;
    }

    /**
     * 
     */
    public static final String     canadaStatesNames[] = {
        "Alberta",
        "British Columbia",
        "Manitoba",
        "New Brunswick",
        "Newfoundland and Labrador",
        "Northwest Territories",
        "Nova Scotia",
        "Nunavut",
        "Ontario",
        "Prince Edward Island",
        "Quebec",
        "Saskatchewan",
        "Yukon"

                                                       };

    /**
     * 
     */
    public static final String     canadaStateCodes[]  = {
        "AB",
        "BC",
        "MB",
        "NB",
        "NL",
        "NT",
        "NS",
        "NU",
        "ON",
        "PE",
        "QC",
        "SK",
        "YT"

                                                       };

    /**
     * List of canada states.
     */
    public static List<LabelValue> canadaStatesList;
    static {
        canadaStatesList = loadCanadaStates();
    }

    private static List<LabelValue> loadCanadaStates() {
        List<LabelValue> states = new ArrayList<LabelValue>(51);

        for (int i = 0; i < canadaStatesNames.length; i++) {
            states.add(new LabelValue(canadaStatesNames[i], canadaStateCodes[i]));
        }

        return states;
    }
    
    /**
     * The name of the property used for work company name
     */
    public static final String   PROP_ADDRESS_WORK_COMPANY_NAME   = "address.work.company.name";
    
    /**
     * The name of the property used for work job title
     */
    public static final String   PROP_ADDRESS_WORK_JOB_TITLE   = "address.work.job.title";

    /**
     * The Address Properties ex: company, job title etc.
     */
    public static final String addressProperties[]            = { "companyName", "jobTitle" };

    
    
}
