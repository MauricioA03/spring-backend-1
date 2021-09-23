/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.service;

import com.sales.market.model.Item;
import com.sales.market.model.ItemInstance;
import com.sales.market.model.ItemInstanceStatus;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ItemInstanceRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemInstanceServiceImpl extends GenericServiceImpl<ItemInstance> implements ItemInstanceService {
    private final ItemInstanceRepository itemInstanceRepository;
    private final ItemService itemService;

    public ItemInstanceServiceImpl(ItemInstanceRepository itemInstanceRepository, ItemService itemService) {
        this.itemInstanceRepository = itemInstanceRepository;
        this.itemService = itemService;
    }

    @Override
    protected GenericRepository<ItemInstance> getRepository() {
        return itemInstanceRepository;
    }

    @Override
    public ItemInstance bunchSave(ItemInstance itemInstance) {
        // here make all objects save other than this resource
        if (itemInstance.getItem() != null) {
            // todo habria que distinguir si permitiremos guardar y  actualizar o ambos mitando el campo id
            itemService.save(itemInstance.getItem());
        }
        return super.bunchSave(itemInstance);
    }

    @Override
    public List<ItemInstance> getItemInstanceByItemAndEqualStatus(Item item, ItemInstanceStatus itemInstanceStatus) {
        List<ItemInstance> itemInstances = itemInstanceRepository.findAll();
        return itemInstances.stream().filter(itemInstance -> itemInstance.getItem().getId().equals(item.getId()) &&
                itemInstance.getItemInstanceStatus().equals(itemInstanceStatus) ).collect(Collectors.toList());
    }

    @Override
    public void setStateAll(String itemInstanceSkus, ItemInstanceStatus status) {
        List<ItemInstance> itemInstances = Arrays.stream(arraySkus(itemInstanceSkus))
                .map(itemInstanceRepository::getByIdentifier).collect(Collectors.toList());
        itemInstances.forEach(itemInstance -> {
            itemInstance.setItemInstanceStatus(status);
            itemInstanceRepository.save(itemInstance);
        });
    }

    @Override
    public void saveAllItemBySkus(String itemInstanceSkus, Item item) {
        Arrays.stream(arraySkus(itemInstanceSkus)).forEach(sku -> {
            ItemInstance itemInstance = new ItemInstance();
            itemInstance.setItemInstanceStatus(ItemInstanceStatus.AVAILABLE);
            itemInstance.setIdentifier(sku);
            itemInstance.setItem(item);
            itemInstance.setPrice(10D);
            itemInstanceRepository.save(itemInstance);
        });
    }

    @Override
    public ItemInstance getByIdentifier(String sku) {
        return itemInstanceRepository.getByIdentifier(sku);
    }

    private String[] arraySkus(String itemInstanceSkus) {
        return itemInstanceSkus.split(" ");
    }
}
