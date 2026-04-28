package co.simplon.wishmegift.service;
import java.util.List;
import org.springframework.stereotype.Service;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.repository.GiftRepository;

@Service
public class GiftService{
    private final GiftRepository giftRepository; 

    public GiftService(GiftRepository giftRepositoryInjected){
        this.giftRepository = giftRepositoryInjected;
    }
    public List<GiftEntity> findGifts(){
    List<GiftEntity> giftList =  this.giftRepository.findAll();
    return giftList;
    }
}
