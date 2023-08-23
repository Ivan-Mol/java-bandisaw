package com.main.repository;

import com.main.exception.NotFoundException;
import com.main.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
    default View getByIdAndCheck(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException("View with id " + id + " is not found"));
    }

    View findByIdAndAuthorId(Long viewId, Long authorId);

    void deleteByIdAndAuthorId(Long viewId, Long authorId);
}