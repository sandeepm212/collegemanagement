package com.management.college.model.util;

import java.io.Serializable;

/**
 * Stores the paging info for a list view.
 * 
 * @author <a href="mailto:ravi@endofthenight.com">ravi@endofthenight.com</a>
 */
public class PagingInfo implements Serializable {

    private int     resultsPerPage;

    private int     startIndex;

    private int     currentPageResultCount;

    private int     totalResultCount;

    private String  sortColumn;

    private boolean sortOrderAsc;

    private String  listPageUrl;

    /**
     * The default constructor.
     */
    public PagingInfo() {

    }

    /**
     * Returns the resultsPerPage.
     * 
     * @return the resultsPerPage
     */
    public int getResultsPerPage() {
        return resultsPerPage;
    }

    /**
     * Returns the startIndex.
     * 
     * @return the startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Returns the currentPageResultCount.
     * 
     * @return the currentPageResultCount
     */
    public int getCurrentPageResultCount() {
        return currentPageResultCount;
    }

    /**
     * Sets the currentPageResultCount.
     * 
     * @param currentPageResultCount
     *            The currentPageResultCount to set
     */
    public void setCurrentPageResultCount(int currentPageResultCount) {
        this.currentPageResultCount = currentPageResultCount;
    }

    /**
     * Returns the totalResultCount.
     * 
     * @return the totalResultCount
     */
    public int getTotalResultCount() {
        return totalResultCount;
    }

    /**
     * Returns the sortColumn.
     * 
     * @return the sortColumn
     */
    public String getSortColumn() {
        return sortColumn;
    }

    /**
     * Returns the sortOrderAsc.
     * 
     * @return the sortOrderAsc
     */
    public boolean isSortOrderAsc() {
        return sortOrderAsc;
    }

    /**
     * Sets the resultsPerPage.
     * 
     * @param resultsPerPage
     *            The resultsPerPage to set
     */
    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    /**
     * Sets the startIndex.
     * 
     * @param startIndex
     *            The startIndex to set
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * Sets the totalResultCount.
     * 
     * @param totalResultCount
     *            The totalResultCount to set
     */
    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    /**
     * Sets the sortColumn.
     * 
     * @param sortColumn
     *            The sortColumn to set
     */
    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    /**
     * Sets the sortOrderAsc.
     * 
     * @param sortOrderAsc
     *            The sortOrderAsc to set
     */
    public void setSortOrderAsc(boolean sortOrderAsc) {
        this.sortOrderAsc = sortOrderAsc;
    }

    /**
     * Returns the listPageUrl.
     * 
     * @return the listPageUrl
     */
    public String getListPageUrl() {
        return listPageUrl;
    }

    /**
     * Sets the listPageUrl.
     * 
     * @param listPageUrl
     *            The listPageUrl to set
     */
    public void setListPageUrl(String listPageUrl) {
        this.listPageUrl = listPageUrl;
    }

    public String getPagingLabel() {

        StringBuffer buf = new StringBuffer(128);

        buf.append(startIndex + 1).append(" to ").append(startIndex + currentPageResultCount);
        buf.append(" of ").append(totalResultCount);

        return buf.toString();
    }

    public String getPagingLinks() {

        int numPages = totalResultCount / resultsPerPage;
        // if there are some records remaining, add an extra page.
        if ((totalResultCount % resultsPerPage) > 0) {
            numPages++;
        }

        int curPage = startIndex / resultsPerPage;

        StringBuffer buf = new StringBuffer(256);
        int numExtraLinks = 2;
        int startPage = Math.max(0, curPage - numExtraLinks);
        int endPage = Math.min(numPages, curPage + numExtraLinks + 1);
        
        for (int i = startPage; i < endPage; i++) {
            buf.append("<a ");
            if (i == curPage) {
                buf.append("class=\"curPage\" ");
                buf.append("href=\"").append("javascript:void(0);").append("\"");
            } else {
                buf.append("onclick=\"handlePagingClick('").append(i * resultsPerPage).append("'); return false;\"");
                buf.append("href=\"").append(this.listPageUrl);
                if (this.listPageUrl.contains("?")) {
                    buf.append("&");
                } else {
                    buf.append("?");
                }
                buf.append("st=").append(i * resultsPerPage);
                buf.append("&nr=").append(resultsPerPage);
                if (sortColumn != null) {
                    buf.append("&sc=").append(sortColumn);
                }
                buf.append("&so=").append(sortOrderAsc);
                buf.append("\"");
            }
            buf.append(">");
            buf.append(i + 1).append("</a>");
        }

        return buf.toString();
    }
}
