package com.yangqingmang.sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/9/30 下午5:09
 */
public class SaleTab extends Tab {

    private final TableView tableView = new TableView();

    private final VBox root = new VBox();

    private ObservableList<?> data = FXCollections.observableArrayList();

    public SaleTab() {
        this("销售管理");
    }

    public SaleTab(String title) {
        super(title);
        init();
    }

    public void init() {
        setContent(root);
        ObservableList<Node> nodes = root.getChildren();

        Menu menu = new Menu("新增");

        nodes.addAll(new MenuBar(menu), tableView);
    }
}
