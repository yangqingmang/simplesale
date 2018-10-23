package com.yangqingmang.mapper;

import com.yangqingmang.dto.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/3 下午1:08
 */
public interface GoodsMapper {

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
    List<Goods> findByName(@Param("name") String name);

    /**
     * 新增新商品
     * @param goods
     * @return
     */
    int addNewGoods(Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delete(@Param("id") String id);
}
