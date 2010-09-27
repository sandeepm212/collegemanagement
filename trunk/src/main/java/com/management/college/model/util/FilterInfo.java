/**
 * 
 */
package com.management.college.model.util;

import java.io.Serializable;

/**
 * A utility object to hold filter and paging data. This will be passed to a
 * DAO object from the web/service layer for each view request.
 * 
 * @author <a href="mailto:ravi@endofthenight.com">ravi@endofthenight.com</a>
 */
public class FilterInfo implements Serializable {

    /*
     * The starting index of the list of results on the current page.
     */
    private int               startIndex;

    /*
     * The number of results to be displayed on the current page.
     */
    private int               numResults;

    /*
     * The column on which to sort the current set of results.
     */
    private String            sortColumn;

    /*
     * If true, the results will be sorted in ascending order.
     */
    private boolean           sortOrderAsc;

    /*
     * If true, all the filters will be used together.
     */
    private boolean           includeAll;

    /**
     * The default constructor
     */
    public FilterInfo() {
        this.startIndex = 0;
        this.numResults = 10;
        this.sortOrderAsc = false;
        this.includeAll = false;
    }

    /**
     * @param inputStartIndex
     *            the starting index
     * @param inputNumResults
     *            the number of results
     * @param inputSortColumn
     *            the sort column
     * @param inputSortOrderAsc
     *            ascending or descending
     * @param inputFilterValues
     *            the list of filters
     * @param inputIncludeAll
     *            all or any
     */
    public FilterInfo(final int inputStartIndex, final int inputNumResults, final String inputSortColumn,
            final boolean inputSortOrderAsc, final boolean inputIncludeAll) {
        this.startIndex = inputStartIndex;
        this.numResults = inputNumResults;
        this.sortColumn = inputSortColumn;
        this.sortOrderAsc = inputSortOrderAsc;
        this.includeAll = inputIncludeAll;
    }

    /**
     * Returns the startIndex.
     * 
     * @return the startIndex
     */
    public int getStartIndex() {
        return this.startIndex;
    }

    /**
     * Returns the numResults.
     * 
     * @return the numResults
     */
    public int getNumResults() {
        return this.numResults;
    }

    /**
     * Returns the sortColumn.
     * 
     * @return the sortColumn
     */
    public String getSortColumn() {
        return this.sortColumn;
    }

    /**
     * Returns the sortOrderAsc.
     * 
     * @return the sortOrderAsc
     */
    public boolean isSortOrderAsc() {
        return this.sortOrderAsc;
    }


    /**
     * Returns the includeAll.
     * 
     * @return the includeAll
     */
    public boolean isIncludeAll() {
        return this.includeAll;
    }
    
    public int getPage () {
    	return (startIndex / numResults) + 1;
    }

    /**
     * Sets the startIndex.
     * 
     * @param inputStartIndex
     *            The startIndex to set
     */
    public void setStartIndex(final int inputStartIndex) {
        this.startIndex = inputStartIndex;
    }

    /**
     * Sets the numResults.
     * 
     * @param inputNumResults
     *            The numResults to set
     */
    public void setNumResults(final int inputNumResults) {
        this.numResults = inputNumResults;
    }

    /**
     * Sets the sortColumn.
     * 
     * @param inputSortColumn
     *            The sortColumn to set
     */
    public void setSortColumn(final String inputSortColumn) {
        this.sortColumn = inputSortColumn;
    }

    /**
     * Sets the sortOrderAsc.
     * 
     * @param inputSortOrderAsc
     *            The sortOrderAsc to set
     */
    public void setSortOrderAsc(final boolean inputSortOrderAsc) {
        this.sortOrderAsc = inputSortOrderAsc;
    }


    /**
     * Sets the includeAll.
     * 
     * @param inputIncludeAll
     *            The includeAll to set
     */
    public void setIncludeAll(final boolean inputIncludeAll) {
        this.includeAll = inputIncludeAll;
    }

}
