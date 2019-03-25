package com.nc.memory.repos;

import com.nc.memory.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
