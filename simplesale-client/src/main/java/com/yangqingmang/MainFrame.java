package com.yangqingmang;

import com.yangqingmang.goods.GoodsTab;
import com.yangqingmang.sale.SaleTab;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/9/30 下午4:40
 */
public class MainFrame extends SplitPane{

    TabPane tabPane = new TabPane();

    VBox menuPane = new VBox();

    GoodsTab goodsTab = new GoodsTab();

    SaleTab saleTab = new SaleTab();

    public MainFrame() {
        init();
        ObservableList<Node> observableList = getItems();
        observableList.addAll(menuPane, tabPane);
    }

    public void init() {
        setDividerPositions(0.25);
        setPrefWidth(800);
        setPrefHeight(600);

        ObservableList<Tab> tabs = tabPane.getTabs();
        tabPane.setPrefWidth(600);
        tabPane.setPrefHeight(400);

        Button rootButton = new Button("首页");
        rootButton.setMaxWidth(Double.MAX_VALUE);
        rootButton.setOnAction(e -> {

        });
        Button goodsButton = new Button("商品管理");
        goodsButton.setMaxWidth(Double.MAX_VALUE);
        goodsButton.setOnAction(e -> {
            if (!tabs.contains(goodsTab)) {
                tabs.add(goodsTab);
            }
            tabPane.getSelectionModel().select(goodsTab);
        });
        Button saleButton = new Button("销售管理");
        saleButton.setMaxWidth(Double.MAX_VALUE);
        saleButton.setOnAction(e -> {
            if (!tabs.contains(saleTab)) {
                tabs.add(saleTab);
            }
            tabPane.getSelectionModel().select(saleTab);
        });
        menuPane.getChildren().addAll(rootButton, goodsButton, saleButton);

    }

}
