package co.simplon.wishmegift.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.wishmegift.entity.Wishlist;
import co.simplon.wishmegift.repository.WishlistRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





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
        @PostMapping
        public Wishlist createWishList(@RequestBody Wishlist newWishlist) {
            
            return repository.save(newWishlist);
        }
        
        @DeleteMapping("/{id}")
            public void deleteWishList(@PathVariable Long id){
                repository.deleteById(id);
            }
        
        @PutMapping("/{id}")
        public Wishlist updateWishList(@PathVariable Long id, @RequestBody Wishlist updateWishList) {
            return repository.findById(id)
            .map(WishList ->{
                WishList.setName(updateWishList.getName());
                WishList.setDescription(updateWishList.getDescription());
                WishList.setTheme(updateWishList.getTheme());
                WishList.setAuthor(updateWishList.getAuthor());
                return repository.save(WishList);
            })
            .orElseGet(() ->{
                updateWishList.setId(id);
                return repository.save(updateWishList);
            });
        }
        }
