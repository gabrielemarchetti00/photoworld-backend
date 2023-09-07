package com.example.photoworld.resource;

import com.example.photoworld.model.Photo;
import com.example.photoworld.service.PhotoService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoResource {
    private final PhotoService photoService;

    public PhotoResource(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Photo>> getAllPhotos () {
        List<Photo> photos = photoService.findAllPhotos();
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Photo> getPhotoById (@PathVariable("id") Long id) {
        Photo photo = photoService.findPhotoById(id);
        return new ResponseEntity<>(photo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Photo> addPhoto (@RequestBody Photo photo) {
        Photo newPhoto = photoService.addPhoto(photo);
        return new ResponseEntity<>(newPhoto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Photo> updatePhoto (@RequestBody Photo photo) {
        Photo updatePhoto = photoService.updatePhoto(photo);
        return new ResponseEntity<>(updatePhoto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deletePhoto(@PathVariable("id") Long id) {
        photoService.deletePhoto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
