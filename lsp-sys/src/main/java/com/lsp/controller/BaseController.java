package com.lsp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsp.core.common.ShiroUtils;
import com.lsp.entity.SysUser;
import com.lsp.result.PageEntity;
import com.lsp.result.R;
import com.lsp.utils.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by songbo on 2018/8/1.
 */
public class BaseController {
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return String.format("redirect:%s", url);
    }

    public SysUser getUser()
    {
        return ShiroUtils.getUser();
    }

    public void setUser(SysUser user)
    {
        ShiroUtils.setUser(user);
    }

    public Long getUserId()
    {
        return getUser().getUserId();
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage(PageEntity page)
    {
        if (StringUtils.isNotNull(page.getPageNo()) && StringUtils.isNotNull(page.getPageSize()))
        {
            PageHelper.startPage(page.getPageNo(), page.getPageSize(), page.getOrderBy());
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected R getDataTable(List<?> list)
    {
        R r = new R();
        r.put("code",0);
        r.put("data",list);
        r.put("count",new PageInfo(list).getTotal());
        return r;
    }
}
