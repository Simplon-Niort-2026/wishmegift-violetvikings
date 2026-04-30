
**Dans `Wishlist.java`** : `@ManyToOne` (Plusieurs listes pour un utilisateur).
-(enlever authors en private User user )

**Dans `User.java`** : `@OneToMany` (Un utilisateur pour plusieurs listes). et crée la list <wishlist> 

Dans Gift.java: @ManyToOne` (Plusieurs cadeaux pour une liste).
-private Wishlist wishlist 

Dans Wishlist.java : @OneToMany` (Une liste pour plusieurs cadeaux).
list <Gift> 

plus faire les modif si besoin 


crée tout les test dans bruno pour faire la presentation. 
