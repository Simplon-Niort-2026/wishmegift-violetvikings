package co.simplon.wishmegift.service;

import java.util.List;
import org.springframework.stereotype.Service;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.repository.GiftRepository;

@Service

public class GiftService {

    private GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepositoryInjected) {
        this.giftRepository = giftRepositoryInjected;
    }

    public List<GiftEntity> findGifts() {
        List<GiftEntity> giftList = (List<GiftEntity>) this.giftRepository.findAll();
        return giftList;
    }

    public GiftEntity saveGift(GiftEntity gift) {
        return giftRepository.save(gift);
    }

    public GiftEntity updateGift(Long id, GiftEntity gift) {
        GiftEntity existingGift = giftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gift not found"));

        existingGift.setName(gift.getName());
        existingGift.setPrice(gift.getPrice());
        existingGift.setDescription(gift.getDescription());

        return giftRepository.save(existingGift);
    }

    public void deleteGift(final Long id) {
        giftRepository.deleteById(id);
    }
}
