package com.srsproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srsproject.model.OpusCard;

import antlr.collections.List;

@Repository("cardRepository")
public interface OpusCardRepository extends CrudRepository<OpusCard, Long> {
	OpusCard findById(long id);
	List findByUserHavingIsNull();
}
