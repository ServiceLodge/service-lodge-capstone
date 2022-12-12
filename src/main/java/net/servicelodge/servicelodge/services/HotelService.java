package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.Hotel;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.HotelRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HotelService")
public class HotelService {

    private final HotelRepository hotelsDao;

    public HotelService(HotelRepository hotelsDao) {
        this.hotelsDao = hotelsDao;
    }

    public List<Hotel> getHotels(){
        return hotelsDao.findAll();
    }

    public void createHotel(Hotel hotel){
        hotelsDao.save(hotel);
        // emailService.prepareAndSend(ad, subject, description);
    }

    public List<Hotel> findAllByState(String state) { return hotelsDao.findAllByState(state); }

    public Hotel findById(long id) {
        return hotelsDao.getReferenceById(id);
    }

    public void deleteHotel(Hotel hotel) {
        hotelsDao.delete(hotel);
    }

    public void editHotel(Hotel hotel) {
        hotelsDao.save(hotel);
    }
}