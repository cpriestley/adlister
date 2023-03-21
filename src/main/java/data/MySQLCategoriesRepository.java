package data;

import configs.AdlisterConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MySQLCategoriesRepository implements Categories {

    private final Connection connection;

    @Override
    public long insertAdCategory(long foreignKeyId, String category) {
        String query = "INSERT INTO ads_categories (ad_id, category_id) VALUES (?, ?)";
        System.out.println("insertAdCategory()");
        System.out.println(query);
        try {
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, foreignKeyId);
            long categoryId = getCategoryId(category);
            statement.setLong(2, categoryId);
            System.out.printf("Statement: %s%n", statement);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            System.out.println("ResultSet: " + rs);
            return categoryId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long getCategoryId(String category) {
        String query = "SELECT id FROM categories WHERE name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, category);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getLong("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Long> insertAdSubategories(long fKeyAdId, long fKeyCategoryId, String[] subCategories) {
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ads_sub_categories (ad_id, category_id, sub_category_id) VALUES ");

        queryBuilder.append("(?, ?, ?), ".repeat(Math.max(0, subCategories.length - 1)));
        queryBuilder.append("(?, ?, ?);");

        try {
            PreparedStatement statement = connection.prepareStatement(queryBuilder.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            List<Long> ids = new ArrayList<>();
            int i = 0;
            for (String subCategory : subCategories) {
                long subCategoryId = getSubCategoryId(subCategory);
                statement.setLong(++i, fKeyAdId);
                statement.setLong(++i, fKeyCategoryId);
                statement.setLong(++i, subCategoryId);
                ids.add(subCategoryId);
            }
            statement.executeUpdate();
            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private long getSubCategoryId(String subCategory) {
        String query = "SELECT id FROM sub_categories WHERE name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, subCategory);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getLong("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MySQLCategoriesRepository(AdlisterConnection connection) {
        this.connection = connection.getConnection();
    }

    @Override
    public List<String> getCategories() {
        String query = "SELECT name FROM categories;";
        try {
            List<String> categories = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("name"));
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, List<String>> getAllSubCategories() {
        String query = "select c.name as category, sc.name as subCategory from categories c join sub_categories sc on c.id = sc.categories_id;";
        Map<String, List<String>> subCategories = new HashMap<>();
        Set<String> categories = new HashSet<>(getCategories());
        categories
                .forEach(c -> subCategories.put(c, new ArrayList<>()));
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                subCategories
                        .get(rs.getString("category"))
                        .add(rs.getString("subCategory"));
            }
            return subCategories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
