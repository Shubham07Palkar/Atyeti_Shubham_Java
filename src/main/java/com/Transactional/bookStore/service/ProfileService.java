package com.Transactional.bookStore.service;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final String activeBean;

    public ProfileService(String activeBean) {
        this.activeBean = activeBean;
    }

    public void printActiveBean(){
        System.out.println("ActiveBean: "+activeBean);
    }
}
