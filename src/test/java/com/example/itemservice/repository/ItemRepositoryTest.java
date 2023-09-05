package com.example.itemservice.repository;

import com.example.itemservice.domain.item.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save() throws Exception {
        //given
        Item item = new Item("item", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void updateItem() {
    //given
    Item item = new Item("item1", 10000, 10);
    Item savedItem = itemRepository.save(item);
    Long itemId = savedItem.getId();
    //when
    Item updateParam = new Item("item2", 20000, 30);
    itemRepository.update(itemId, updateParam);
    Item findItem = itemRepository.findById(itemId);
    //then
    assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
    assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}