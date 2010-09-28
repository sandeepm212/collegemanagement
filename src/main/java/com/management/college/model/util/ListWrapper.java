package com.management.college.model.util;

import java.util.List;

/**
 * Used to Store the Results list and the total results count when paging is
 * used.
 */
public class ListWrapper<T> {

	private int totalResultsCount;

	private int filteredListCount;

	private List<T> list;

	private String breadcrumb;

	private int startIndex;

	private int page;

	public ListWrapper() {
		startIndex = 1;
		page = 1;
	}

	/**
	 * Return the total count of the results.
	 * 
	 * @return the total count
	 */
	public int getTotalResultsCount() {
		return totalResultsCount;
	}

	/**
	 * @param count
	 */
	public void setTotalResultsCount(int count) {
		this.totalResultsCount = count;
	}

	/**
	 * Return the list of objects.
	 * 
	 * @return the list of objects
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * @return
	 */
	public int getFilteredListCount() {
		return filteredListCount;
	}

	/**
	 * @param filteredListCount
	 */
	public void setFilteredListCount(int filteredListCount) {
		this.filteredListCount = filteredListCount;
	}

	/**
	 * Returns the beradCrumb for the current element.
	 * 
	 * @return the breadCrumb
	 */
	public String getBreadcrumb() {
		return this.breadcrumb;
	}

	/**
	 * Set the breadCrumb for the current element.
	 * 
	 * @param inputBreadcrumb
	 */
	public void setBreadcrumb(String inputBreadcrumb) {
		this.breadcrumb = inputBreadcrumb;
	}

	@Override
	public String toString() {
		return "filterCount: " + filteredListCount + ", totalCount: "
				+ totalResultsCount + " List: " + list;
	}

	public int getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(int inputStartIndex) {
		this.startIndex = inputStartIndex;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
