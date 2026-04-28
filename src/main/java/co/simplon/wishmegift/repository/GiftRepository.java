package co.simplon.wishmegift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.wishmegift.entity.GiftEntity;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity, Long> {
}