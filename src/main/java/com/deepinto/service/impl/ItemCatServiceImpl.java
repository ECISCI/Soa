package com.deepinto.service.impl;

import com.deepinto.entity.EasyUITreeNode;
import com.deepinto.jedis.JedisClient;
import com.deepinto.mapper.TbItemCatMapper;
import com.deepinto.pojo.TbItemCat;
import com.deepinto.pojo.TbItemCatExample;
import com.deepinto.service.ItemCatService;
import com.deepinto.utils.JsonUtils;
import com.deepinto.utils.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    public static final String TAG = ItemCatServiceImpl.class.getSimpleName();
    @Autowired
    TbItemCatMapper mapper;

    @Autowired
    JedisClient jedisClient;

    private String CONTENT_LIST = "CONTENT_LIST";

    @Override
    public List<EasyUITreeNode> getItemCat(Long parentId) throws Exception {


        // 1.查询缓存
        String json = jedisClient.hget(CONTENT_LIST, parentId + "");
        // 2.如果缓存中有直接响应
        if (org.apache.commons.lang3.StringUtils.isNoneBlank(json)) {
            List<EasyUITreeNode> jsonToList = JsonUtils.jsonToList(json, EasyUITreeNode.class);
            L.i(TAG, "直接从redis缓存中拿出json数据parentId值为:" + parentId + "::json数据值为::" + jsonToList.toString());
            return jsonToList;
        }


        TbItemCatExample example = new TbItemCatExample();

        TbItemCatExample.Criteria criteria = example.createCriteria();

        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> tbItemCats = mapper.selectByExample(example);

        List<EasyUITreeNode> resultTreeNode = new ArrayList<EasyUITreeNode>();


        // 把列表转化成EasyUITreeNode列表
        for (TbItemCat tbItemCat : tbItemCats) {
            // 创建 EasyUITreeNode对象
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent() ? "closed" : "open");
            // 添加到结果列表
            resultTreeNode.add(node);
        }

        // 如果是从数据库中查询出来的数据则要将数据存入Redis缓存中
        jedisClient.hset(CONTENT_LIST, parentId + "", JsonUtils.objectToJson(resultTreeNode));
        L.i(TAG, "将数据存入redis缓存中parentId值为:" + parentId + "::json数据值为::" + JsonUtils.objectToJson(resultTreeNode));


        return resultTreeNode;
    }
}
