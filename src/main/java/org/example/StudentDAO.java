package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, last_name, first_name, middle_name, birth_date, record_book_number FROM students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String last_name = rs.getString("last_name");
                String first_name = rs.getString("first_name");
                String middle_name = rs.getString("middle_name");
                Date birth_date = rs.getDate("birth_date");
                int record_book_number = rs.getInt("record_book_number");

                Student student = new Student(id, last_name, first_name, middle_name, birth_date, record_book_number);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
