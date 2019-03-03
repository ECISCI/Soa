package com.deepinto.service;

import com.deepinto.entity.EasyUIDataGridResult;
import com.deepinto.pojo.TbItem;
import com.deepinto.utils.PublicResult;

public interface ItemService {


    TbItem getItemById(long itemId);

    EasyUIDataGridResult getItemList(int page, int rows);

    PublicResult addItem(TbItem item, String desc);
}
