package clinic.com.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import clinic.com.management.model.AppUser;

public interface UserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);
}

