package com.oauthdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauthdemo.entity.GithubUser;

public interface UserRepository extends JpaRepository<GithubUser, Long> {

	GithubUser findByLogin(String username);

}
