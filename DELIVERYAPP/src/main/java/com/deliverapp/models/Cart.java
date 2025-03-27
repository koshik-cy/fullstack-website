package com.deliverapp.models;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int restaurantId;
    private Map<Integer, CartItem> map;

    public Cart() {
        map = new HashMap<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return map;
    }

    public void addCartItm(CartItem ci) {
        if (map.containsKey(ci.getItemid())) {
            CartItem existingCart = map.get(ci.getItemid());
            existingCart.setQuantity(existingCart.getQuantity() + ci.getQuantity());
        } else {
            map.put(ci.getItemid(), ci);
        }
    }

    public void updateCart(int itemid, int quantity) {
        if (map.containsKey(itemid)) {
            if (quantity <= 0) {
                map.remove(itemid);
            } else {
                CartItem existing = map.get(itemid);
                existing.setQuantity(quantity);
            }
        }
    }

    public void delete(int itemid) {
        map.remove(itemid);
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : map.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        map.clear();
    }
}




//public Collection<CartItem> getItems() {
//    return map.values();
//}
