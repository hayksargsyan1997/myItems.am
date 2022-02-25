package manager;

import db.DBConnectionProvider;
import model.Category;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    public Category getById(int id) {
        String sql = "SELECT * FROM category WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                return getCategoryFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Category getCategoryFromResultSet(ResultSet resultSet) {
        try {
            return Category.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean create(Category category) {
        String sql = "INSERT INTO category (name) VALUES(?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                category.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public List<Category> getAllCategory() {
        String sql = "SELECT * FROM category";
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categories.add(getCategoryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }


    public void delete(int id) {
        String sql = "DELETE FROM category WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean update(Category category) {

        String sql = "UPDATE category SET name = ?  WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());


            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




//    public void updateUser(User user) {
//        try {
//            Statement statement = connection.createStatement();
//            String query = String.format("Update user set name='%s', surname='%s',email='%s',password='%s' WHERE id=" + user.getId(),
//                    user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
//            statement.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
