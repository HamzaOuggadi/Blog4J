package hamzaouggadi.com.blog4j.services;

import hamzaouggadi.com.blog4j.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId) throws Exception;
    void addCategory(Category category);
    void editCategory(Category category);
    void deleteCategoryById(Long categoryId);
}
