package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    public void addBook(Book book) {

        String sql = "INSERT INTO books(title,author,status) VALUES(?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, "Available");

            ps.executeUpdate();

            System.out.println("\nBook Added Successfully.");

            con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void viewAvailableBooks() {

        String sql = "SELECT * FROM books WHERE status=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Available");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========= Available Books =========");

            while (rs.next()) {

                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Title : " + rs.getString("title"));
                System.out.println("Author : " + rs.getString("author"));
                System.out.println("Status : " + rs.getString("status"));
                System.out.println("----------------------------------");

            }

            con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void issueBook(int id) {

        String sql = "UPDATE books SET status=? WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Issued");
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Issued Successfully.");
            else
                System.out.println("Book Not Found.");

            con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void returnBook(int id) {

        String sql = "UPDATE books SET status=? WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Available");
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Returned Successfully.");
            else
                System.out.println("Book Not Found.");

            con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}