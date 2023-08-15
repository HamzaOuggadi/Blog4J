package hamzaouggadi.com.blog4j.services;

import hamzaouggadi.com.blog4j.entities.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();
    Image getImageById(Long imageId);
    void addImage(Image image);
    void deleteImageById(Long imageId);
}
