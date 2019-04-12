package com.lovo.service.impl;

import com.lovo.dao.IParkDao;
import com.lovo.entity.ParkEntity;
import com.lovo.service.IParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "parkService")
public class ParkServiceImpl implements IParkService {

    @Autowired
    private IParkDao parkDao;

    @Override
    public void addPark(ParkEntity parkEntity) {
        parkDao.save(parkEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePark(ParkEntity parkEntity) {
        ParkEntity park = findParkById(parkEntity.getId());

        park.setParkName(parkEntity.getParkName());
        park.setCapacity(parkEntity.getCapacity());
        park.setPrice(parkEntity.getPrice());

    }

    @Override
    public void deletePark(String parkId) {
        parkDao.delete(parkId);
    }

    @Override
    public ParkEntity findParkById(String parkId) {
        return parkDao.findOne(parkId);
    }

    @Override
    public List<ParkEntity> findAllPark() {
        return (List<ParkEntity>) parkDao.findAll();
    }
}
