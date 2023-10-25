package com.sentryc.graphql.repo;

import com.sentryc.graphql.data.Seller;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SellerRepo extends JpaRepository<Seller, UUID> {
    List<Seller> findAll(Specification<Seller> specification);
}
