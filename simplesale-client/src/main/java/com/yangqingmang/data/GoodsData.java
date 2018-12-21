package com.yangqingmang.data;

import com.yangqingmang.goods.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/2 下午1:48
 */
public class GoodsData {
    private static List<Goods> data = new ArrayList<>();

    public static final void pushData(Goods goods) {
        data.add(goods);
    }

    public static final void removeData() {

    }
}
