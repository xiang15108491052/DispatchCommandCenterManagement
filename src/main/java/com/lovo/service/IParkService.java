package com.lovo.service;

import com.lovo.entity.ParkEntity;

import java.util.List;

public interface IParkService {

    void addPark(ParkEntity parkEntity);

    void updatePark(ParkEntity parkEntity);

    void deletePark(String parkId);

    ParkEntity findParkById(String parkId);

    List<ParkEntity> findAllPark();



}
