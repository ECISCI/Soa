package com.deepinto.service;

import com.deepinto.entity.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {

    List<EasyUITreeNode> getItemCat(Long parentId) throws Exception;
}
