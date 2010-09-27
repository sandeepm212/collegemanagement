package com.management.college.service;

import java.util.List;

import com.management.college.model.LabelValue;

/**
 * Business Service Interface to talk to persistence layer and
 * retrieve values for drop-down choice lists.
 *
 * @author <a href="mailto:sandeep.mandrumaka@gmail.com">Sandeep Mandrumaka</a>
 */
public interface LookupManager extends UniversalManager {
    /**
     * Retrieves all possible roles from persistence layer
     * @return List of LabelValue objects
     */
    List<LabelValue> getAllRoles();
}
