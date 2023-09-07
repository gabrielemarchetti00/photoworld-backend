package com.example.photoworld.repo;

import com.example.photoworld.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepo extends JpaRepository<Photo, Long> {
    void deletePhotoById(Long id);

    Optional<Photo> findPhotoById(Long id);

}
