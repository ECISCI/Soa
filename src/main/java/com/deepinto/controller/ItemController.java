package com.deepinto.controller;

import com.deepinto.entity.EasyUIDataGridResult;
import com.deepinto.pojo.TbItem;
import com.deepinto.service.ItemService;
import com.deepinto.utils.PublicResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {


    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

        // 电商 服务查询商品列表
        EasyUIDataGridResult result = itemService.getItemList(page, rows);

        System.out.println(result.toString());
        // ItemCatController增加一段测试字段
        return result;

    }

    /**
     * 商品添加功能
     */
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public PublicResult addItem(TbItem item, String desc) {

        PublicResult addItem = itemService.addItem(item, desc);

        return addItem;

    }

}
