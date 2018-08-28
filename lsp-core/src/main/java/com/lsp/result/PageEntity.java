package com.lsp.result;

import com.lsp.utils.StringUtils;
import lombok.Data;
import lombok.Getter;

/**
 * Created by Administrator on 2018/8/28.
 */

public class PageEntity {
    private int pageNo;
    private int pageSize;
    private int count;
    /** 排序列 */
    private String orderByColumn;
    /** 排序的方向 "desc" 或者 "asc". */
    private String isAsc;
    public String getOrderBy()
    {
        if (StringUtils.isEmpty(orderByColumn))
        {
            return "";
        }
        return StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public String getIsAsc() {
        return isAsc;
    }



    public void setCount(int count) {
        this.count = count;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }
}
