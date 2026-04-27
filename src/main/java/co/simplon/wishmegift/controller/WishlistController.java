package co.simplon.wishmegift.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.wishmegift.entity.Wishlist;
import co.simplon.wishmegift.repository.WishlistRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

        private final WishlistRepository repository;

        public WishlistController(WishlistRepository repository){
            this.repository = repository;
        }

        @GetMapping()
        public List<Wishlist> getAllWishLists(){
            return repository.findAll();
        } 
        
}
