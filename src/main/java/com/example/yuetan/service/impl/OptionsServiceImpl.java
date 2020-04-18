package com.example.yuetan.service.impl;

import com.example.yuetan.dao.OptionsDao;
import com.example.yuetan.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionsDao optionsDao;

    private static List<String> locations;

    @Override
    public List<String> getLocations() {

        if (locations.isEmpty()){
            locations=optionsDao.getLocations();
        }
        return locations;
    }
}
