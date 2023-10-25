package com.sentryc.graphql.repo;

import com.sentryc.graphql.data.SellerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerInfoRepo extends JpaRepository<SellerInformation, UUID> {
}
