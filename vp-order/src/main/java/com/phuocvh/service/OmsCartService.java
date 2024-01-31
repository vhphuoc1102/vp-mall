package com.phuocvh.service;

import com.phuocvh.entity.OmsCart;

import java.util.List;

public interface OmsCartService {
    void create();

    int update();

    void delete();

    OmsCart get();

    List<OmsCart> listAll();
}
