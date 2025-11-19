package ca.gbc.comp3095.inventoryservice.bootstrap;

import ca.gbc.comp3095.inventoryservice.model.Inventory;
import ca.gbc.comp3095.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading inventory data...");

        if (inventoryRepository.count() == 0) {
            Inventory inventory1 = Inventory.builder()
                    .skuCode("sku_123456")
                    .quantity(10)
                    .build();

            Inventory inventory2 = Inventory.builder()
                    .skuCode("sku_789012")
                    .quantity(0)
                    .build();

            Inventory inventory3 = Inventory.builder()
                    .skuCode("sku_321765")
                    .quantity(5)
                    .build();

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
            inventoryRepository.save(inventory3);

            log.info("Inventory data loaded successfully");
        } else {
            log.info("Inventory data already exists, skipping seed");
        }
    }
}
