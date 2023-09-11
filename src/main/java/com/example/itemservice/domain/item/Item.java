package com.example.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // Integer인 이유는 null 값 허용
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) { // ID는 수정 X
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
