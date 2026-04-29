package co.simplon.wishmegift.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.wishmegift.entity.GiftEntity;

@Repository
public interface GiftRepository extends CrudRepository<GiftEntity, Long> {
}