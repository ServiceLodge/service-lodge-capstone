package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.Unit;
import net.servicelodge.servicelodge.repositories.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitRepository unitDao;

    public UnitService(UnitRepository unitDao) {
        this.unitDao = unitDao;
    }

    public List<Unit> getUnits(){
        return unitDao.findAll();
    }

    public Unit findById(long id){
        return unitDao.findById(id);
    }

}