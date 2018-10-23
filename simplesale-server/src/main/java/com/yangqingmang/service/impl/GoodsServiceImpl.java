package com.yangqingmang.service.impl;

import com.yangqingmang.dto.Goods;
import com.yangqingmang.mapper.GoodsMapper;
import com.yangqingmang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/3 下午1:14
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public List<Goods> findByName(String name) {
        return goodsMapper.findByName(name);
    }

    @Override
    public int addNewGoods(Goods goods) {
        return goodsMapper.addNewGoods(goods);
    }

    @Override
    public int delete(String id) {
        return goodsMapper.delete(id);
    }
}
