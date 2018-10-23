package com.yangqingmang.goods;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/1 下午8:34
 */
public class GoodsDialog extends Dialog {

    public GoodsDialog() {
        init();
    }

    public void init() {
        setTitle("新增商品");
        setHeaderText("请输入商品信息");

        ButtonType loginButtonType = new ButtonType("保存", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField codeField = new TextField();
        codeField.setPromptText("编码");
        TextField nameField = new TextField();
        nameField.setPromptText("名字");
        TextField unitField = new TextField();
        unitField.setPromptText("单位");
        TextField priceField = new TextField();
        priceField.setPromptText("价格");

        grid.add(new Label("编码:"), 0, 0);
        grid.add(codeField, 1, 0);
        grid.add(new Label("名字:"), 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(new Label("单位:"), 0, 2);
        grid.add(unitField, 1, 2);
        grid.add(new Label("价格:"), 0, 3);
        grid.add(priceField, 1, 3);

        // Enable/Disable save button depending on whether a username was entered.
        Node saveButton = getDialogPane().lookupButton(loginButtonType);
        saveButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        codeField.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.trim().isEmpty());
        });

        getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> codeField.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                Goods goods = new Goods("", codeField.getText(), nameField.getText(), unitField.getText(), priceField.getText());
                return goods;
            }
            return null;
        });
    }
}
