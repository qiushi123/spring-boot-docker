package com.neo.service.impl;

import com.neo.model.Pv2048;
import com.neo.repository.IPRepository;
import com.neo.service.IPService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPServiceImpl implements IPService {

    @Autowired
    private IPRepository userRepository;


    @Override
    public List<Pv2048> getIPList() {
        return userRepository.findAll();
    }
}


