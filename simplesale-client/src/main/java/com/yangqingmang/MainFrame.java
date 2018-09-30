package com.yangqingmang;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/9/30 下午4:40
 */
public class MainFrame extends SplitPane{

    ListView<Label> listView = new ListView<>();

    TabPane tabPane = new TabPane();

    public MainFrame() {
        init();
        ObservableList<Node> observableList = getItems();
        observableList.addAll(listView, tabPane);
    }

    public void init() {
        setDividerPositions(0.3);
        setPrefWidth(800);
        setPrefHeight(600);


        tabPane.setPrefWidth(600);
        tabPane.setPrefHeight(400);
        tabPane.getTabs().add(new GoodsTab());
        tabPane.getTabs().add(new SaleTab());

        listView.getItems().add(new Label("首页"));
        listView.getItems().add(new Label("商品管理"));
    }

}
