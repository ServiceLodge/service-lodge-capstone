package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.Drill;
import net.servicelodge.servicelodge.repositories.DrillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DrillService")
public class DrillService {

    private final DrillRepository drillDao;

    public DrillService(DrillRepository drillDao) {
        this.drillDao = drillDao;
    }

    public List<Drill> getDrills(){
        return drillDao.findAll();
    }

    public void createDrill(Drill drill){
        drillDao.save(drill);
        // emailService.prepareAndSend(ad, subject, description);
    }

    public List<Drill> findAllByWingId(long wing_id) { return drillDao.findAllByWingId(wing_id); }

    public Drill findById(long id) {
        return drillDao.getReferenceById(id);
    }

    public void deleteHotel(Drill drill) {
        drillDao.delete(drill);
    }

    public void editHotel(Drill drill) {
        drillDao.save(drill);
    }
}