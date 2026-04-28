package co.simplon.wishmegift.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.wishmegift.service.GiftService;

@RestController

public class GiftController {
    private final GiftService giftService;

    public GiftController(GiftService giftServiceInjected) {
        this.giftService = giftServiceInjected;
    }

    @GetMapping("/gifts")
    public List<?> getAllGiftEntities() {
        return this.giftService.findGifts();
    }
}
