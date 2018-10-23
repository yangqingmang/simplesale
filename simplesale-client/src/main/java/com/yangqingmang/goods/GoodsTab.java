package com.yangqingmang.goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yangqingmang.utils.HttpUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/9/30 下午5:07
 */
public class GoodsTab extends Tab {

    private final TableView tableView = new TableView();

    private final VBox pane = new VBox();

    private ObservableList<Goods> data = FXCollections.observableArrayList();

    public GoodsTab(String title) {
        super(title);
        init();
    }

    public GoodsTab() {
        this("商品管理");
    }

    public void init() {
        setContent(pane);

        ObservableList<Node> list = pane.getChildren();

        Button addButton = new Button(" 新 增 ");
        addButton.setOnAction(e -> {
            createGoods();
        });

        Button delButton = new Button(" 删 除 ");
        delButton.setOnAction(e -> {
            deleteGoods();
        });

        Button qryButton = new Button(" 查 询 ");
        qryButton.setOnAction(e -> {
            queryGoods();
        });

        FlowPane menuPane = new FlowPane();
        menuPane.getChildren().addAll(addButton, delButton, qryButton);
        list.add(menuPane);

        TableColumn<String, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<String, String>("id"));
        TableColumn<String, String> nameColumn = new TableColumn<>("名字");
        nameColumn.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
        TableColumn<String, String> codeColumn = new TableColumn<>("编码");
        codeColumn.setCellValueFactory(new PropertyValueFactory<String, String>("code"));
        TableColumn<String, String> unitColumn = new TableColumn<>("单位");
        unitColumn.setCellValueFactory(new PropertyValueFactory<String, String>("unit"));
        TableColumn<String, String> priceColumn = new TableColumn<>("价格");
        priceColumn.setCellValueFactory(new PropertyValueFactory<String, String>("price"));
        tableView.getColumns().addAll(idColumn, nameColumn, codeColumn, unitColumn, priceColumn);
        tableView.setItems(data);
        list.add(tableView);


    }

    public void createGoods() {
        GoodsDialog dialog = new GoodsDialog();
        Optional<Goods> result = dialog.showAndWait();
        result.ifPresent( goods -> {
            String response = HttpUtil.sendPostRequest("goods/new", JSON.toJSONString(goods));
            if (response != null) {
                JSONObject jsonResponse = JSON.parseObject(response);
                String code = jsonResponse.getString("code");
                if ("0".equals(code)) {
                    Goods goods1 = jsonResponse.getObject("result", Goods.class);
                    data.addAll(goods1);
                }
            }
        });
    }

    public void queryGoods() {
        String response = HttpUtil.sendGetRequest("goods/list", new HashMap<String, String>(0));
        if (response != null) {
            JSONObject jsonResponse = JSON.parseObject(response);
            String code = jsonResponse.getString("code");
            if ("0".equals(code)) {
                data.clear();
                JSONArray goodsArray = jsonResponse.getJSONArray("result");
                for (int i = 0; i < goodsArray.size(); i ++) {
                    Goods goods = goodsArray.getJSONObject(i).toJavaObject(Goods.class);
                    data.add(goods);
                }
            }
        }
    }

    public void deleteGoods() {

        int selectIndex = tableView.getSelectionModel().getSelectedIndex();
        Goods goods = data.get(selectIndex);
        String response = HttpUtil.sendPostRequest("goods/del/" + goods.getId());
        if (response != null) {
            JSONObject jsonResponse = JSON.parseObject(response);
            String code = jsonResponse.getString("code");
            if ("0".equals(code)) {
                data.remove(selectIndex);
            }
        }
    }
}
