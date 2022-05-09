package com.codegym.repository.impl;


import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> getProductList() {
        TypedQuery<Product> typedQuery=
                BaseRepository.entityManager.createQuery(
                        "select s from Product s",Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from Product s where s.productId = :id",Product.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(this.findById(id));
        entityTransaction.commit();
    }

    @Override
    public void update(int productId, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> findAllByQuery(String query) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from Product s where s.productName like '%query%'",Product.class);
        return typedQuery.getResultList();
    }

}
