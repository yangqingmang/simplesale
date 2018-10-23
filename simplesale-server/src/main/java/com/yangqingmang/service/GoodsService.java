package com.yangqingmang.service;

import com.yangqingmang.dto.Goods;

import java.util.List;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/3 下午1:13
 */
public interface GoodsService {

    /**
     * 查询所有商品
     * @return
     */
    List<Goods> findAllGoods();

    /**
     * 按名字查询商品
     * @param name
     * @return
     */
    List<Goods> findByName(String name);

    /**
     * 新增商品
     * @param goods
     * @return
     */
    int addNewGoods(Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delete(String id);
}
