package br.lippe.devaneios.devaneios.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Remove @RepositoryRestResource below to disable auto REST api:
@RepositoryRestResource
public interface UserRepo extends CrudRepository<User_old, Long>{}
