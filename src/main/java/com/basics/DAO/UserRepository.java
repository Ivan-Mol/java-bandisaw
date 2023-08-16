package com.basics.DAO;

import com.basics.exception.NotFoundException;
import com.basics.exception.ValidationException;
import com.basics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default User getByIdAndCheck(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException("User with id " + id + " is not found"));
    }

    default User saveUnique(User user) {
        if (getByEmail(user.getEmail()) != null) {
            throw new ValidationException("Email is already exists");
        }
        return save(user);
    }

    User getByEmail(String email);
}
