package com.yogesh.ItemsApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogesh.ItemsApi.repository.ItemRepository;
import com.yogesh.ItemsApi.repository.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceMySQL
    implements ItemService
{
    private final ItemRepository itemRepository;

    public ItemServiceMySQL( @Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save( Item item )
    {
        return itemRepository.save( item );
    }

    @Override
    public void delete( int itemId )
    {
        itemRepository.deleteById( itemId );
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Item findById( int itemId )
    {
        return itemRepository.findById( itemId ).get();
    }
}