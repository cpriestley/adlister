package data;

import java.util.List;
import java.util.Map;

public interface CategoriesRepository {
    List<String> getCategories();
    Map<String, List<String>> getAllSubCategories();
    long insertAdCategory(long foreignKeyId, String category);
    List<Long> insertAdSubategories(long fKeyAdId, long fKeyCategoryId, String[] subCategories);
    long getCategoryId(String category);
}
