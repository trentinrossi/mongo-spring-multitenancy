package br.com.fullcustom.multitenancy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fullcustom.multitenancy.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}