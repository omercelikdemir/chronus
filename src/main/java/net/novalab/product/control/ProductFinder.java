package net.novalab.product.control;

import net.novalab.product.entity.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ProductFinder {

    @Inject
    EntityManager em;

    public Product findProduct(String product){
        return em.find(Product.class, product);
    }
}
