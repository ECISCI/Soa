package com.deepinto.controller;

import com.deepinto.utils.L;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ming
 * @描述 一些公共的jsp页面
 */
@Controller
public class PublicController {

    /**
     * 首页
     *
     * @return index.jsp
     */
    @RequestMapping("/index")
    public String index() {

        L.i("请求访问:index");

        return "index";
    }

    /**
     * 添加商品
     *
     * @return item-add.jsp
     */
    @RequestMapping("/item-add")
    public String itemAdd() {

        L.i("请求访问:itemAdd");

        return "item-add";
    }

    /**
     * 查询商品
     *
     * @return item-list.jsp
     */
    @RequestMapping("/item-list")
    public String itemList() {

        L.i("请求访问:itemList");

        return "item-list";
    }

    /**
     * 商品规格
     *
     * @return item-param-list.jsp
     */
    @RequestMapping("/item-param-list")
    public String itemParamList() {

        L.i("请求访问:itemParamList");

        return "item-param-list";
    }

    /**
     * 内容管理
     *
     * @return item-param-list.jsp
     */
    @RequestMapping("/content-category")
    public String contentCategory() {

        L.i("请求访问:contentCategory");

        return "content-category";
    }

    /**
     * solr索引库
     *
     * @return index-item.jsp
     */
    @RequestMapping("/index-item")
    public String indexItem() {

        L.i("请求访问:contentCategory");

        return "index-item";
    }


}
