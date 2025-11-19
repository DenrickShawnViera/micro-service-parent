package ca.gbc.comp3095.inventoryservice.service;

public interface InventoryService {

    boolean isInStock(String skuCode, Integer quantity);

}
