package com.budgetOwl.repositories;

import com.budgetOwl.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UsersRepository extends PagingAndSortingRepository<Users, UUID>, CrudRepository<Users, UUID>, JpaRepository<Users, UUID> {
    Users findBySubscriptionId(String subscriptionId);

    Users findByFwid(String fwid);
}
