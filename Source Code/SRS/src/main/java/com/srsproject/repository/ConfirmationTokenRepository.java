package com.srsproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.srsproject.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
