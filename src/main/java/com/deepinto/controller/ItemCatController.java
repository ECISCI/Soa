package com.deepinto.controller;

import com.deepinto.entity.EasyUITreeNode;
import com.deepinto.service.ItemCatService;
import com.deepinto.utils.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatController {

    @Autowired
    ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {


        L.i("进入了 getItemCatList");
        List<EasyUITreeNode> listItemCat = null;
        try {
            listItemCat = itemCatService.getItemCat(parentId);
        } catch (Exception e) {
            e.printStackTrace();
            L.i("错误信息:" + e);
        }

        return listItemCat;
    }

}
