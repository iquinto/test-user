package edu.uoc.epcsd.user.domain.repository;

import edu.uoc.epcsd.user.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository {

    List<Category> findAllCategories();

    Optional<Category> findCategoryById(Long id);

    Long createCategory(Category category);

    void deleteCategory(Long id);
}
