package co.simplon.wishmegift.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.service.GiftService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

public class GiftController {
    private final GiftService giftService;

    public GiftController(GiftService giftServiceInjected) {
        this.giftService = giftServiceInjected;
    }
// Get pour récupérer la liste de cadeaux
// Dans Controller "/gifts" avec un "s", qui correspond au nom de la route Enddpoints (http://localhost:8080/gifts) à tester la requête sur Bruno
    @GetMapping("/gifts")
    public List<?> getAllGiftEntities() {
        return this.giftService.findGifts();

    }

// Post pour créer un cadeau
@PostMapping("/gifts")
public GiftEntity createGift(@RequestBody GiftEntity gift){
    return this.giftService.saveGift(gift);

}
//Put pour modifier un cadeau
@PutMapping("/gifts/{id}")
public ResponseEntity<GiftEntity> updateGift(
        @PathVariable Long id,
        @RequestBody GiftEntity gift) {

    GiftEntity updatedGift = giftService.updateGift(id, gift);
    return ResponseEntity.ok(updatedGift);
}

//Delete pour supprimer un cadeau
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteGift(@PathVariable Long id) {
        giftService.deleteGift(id);
        return ResponseEntity.noContent().build();

}

}

