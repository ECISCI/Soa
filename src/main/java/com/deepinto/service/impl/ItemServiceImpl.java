package com.deepinto.service.impl;

import com.deepinto.entity.EasyUIDataGridResult;
import com.deepinto.mapper.TbItemDescMapper;
import com.deepinto.mapper.TbItemMapper;
import com.deepinto.pojo.TbItem;
import com.deepinto.pojo.TbItemDesc;
import com.deepinto.pojo.TbItemExample;
import com.deepinto.service.ItemService;
import com.deepinto.utils.IDUtils;
import com.deepinto.utils.PublicResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(long itemId) {

        // TbItem selectByPrimaryKey = itemMapper.selectByPrimaryKey(itemId);

        // 设置查询条件
        TbItemExample example = new TbItemExample();

        TbItemExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(itemId);

        List<TbItem> list = itemMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        // 1.设置分页信息
        PageHelper.startPage(page, rows);
        // 2.执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);

        // 创建一个返回值对象

        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);

        // 3.取分页信息
        PageInfo<TbItem> pages = new PageInfo<>(list);
        long total = pages.getTotal();
        result.setTotal(total);

        return result;
    }

    @Override
    public PublicResult addItem(TbItem item, String desc) {
        // 1.生成商品id
        long genItemId = IDUtils.genItemId();
        Random rand = new Random(10000L);
        // 2.补全item属性
        item.setId(genItemId);
        // 1-正常 2-下架 3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //
        if (item.getCid()==null){
            item.setCid(rand.nextLong());
        }
        // 3.向商品表中插入数据
        itemMapper.insert(item);
        // 4.创建一个商品描述表对应的pojo

        TbItemDesc tbItemdesc = new TbItemDesc();
        // 5.补全属性
        tbItemdesc.setItemId(genItemId);
        tbItemdesc.setItemDesc(desc);
        tbItemdesc.setCreated(new Date());
        tbItemdesc.setUpdated(new Date());
        // 6.向商品描述表中插入数据
        itemDescMapper.insert(tbItemdesc);

        // 7.返回成功
        return PublicResult.ok();
    }
}
