package com.sdmproject.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.sdmproject.login.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
