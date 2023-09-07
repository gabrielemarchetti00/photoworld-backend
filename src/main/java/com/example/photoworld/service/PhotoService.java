package com.example.photoworld.service;

import com.example.photoworld.exception.UserNotFoundException;
import com.example.photoworld.model.Photo;
import com.example.photoworld.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    private final PhotoRepo photoRepo;

    @Autowired
    public PhotoService(PhotoRepo photoRepo) {
        this.photoRepo = photoRepo;
    }

    public Photo addPhoto(Photo photo) {
        return photoRepo.save(photo);
    }

    public List<Photo> findAllPhotos() {
        return photoRepo.findAll();
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepo.save(photo);
    }

    public Photo findPhotoById(Long id) {
        return photoRepo.findPhotoById(id)
                .orElseThrow(() -> new UserNotFoundException("Photo by id " + id + " was not found"));
    }

    public void deletePhoto(Long id) {
        photoRepo.deletePhotoById(id);
    }
}
