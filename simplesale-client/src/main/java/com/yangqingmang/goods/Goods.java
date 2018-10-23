package com.yangqingmang.goods;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/1 下午8:03
 */
public class Goods {

    public Goods() {
        this.id = new SimpleStringProperty("-");
        this.name = new SimpleStringProperty("缺省");
        this.code = new SimpleStringProperty("QS");
        this.price = new SimpleStringProperty("0.01");
        this.unit = new SimpleStringProperty("个");
    }

    public Goods(String id, String code, String name, String unit, String price) {
        this.id = new SimpleStringProperty(id);
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.unit = new SimpleStringProperty(unit);
        this.price = new SimpleStringProperty(price);
    }

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty code;
    private SimpleStringProperty unit;
    private SimpleStringProperty price;

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getUnit() {
        return unit.get();
    }

    public void setUnit(String unit) {
        this.unit.set(unit);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
