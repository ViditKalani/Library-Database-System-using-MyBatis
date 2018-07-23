package com.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.domain.Book;
import com.service.Book_Loans_Service;

public class Library_MyBatis {

	private final static String URL = "jdbc:oracle:thin:@dataserv.mscs.mu.edu:1521:orcl";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rst = null;
	private static Statement stmt1 = null;

	public static void main(String[] args) throws Exception, IOException, SQLException {

		String user = null, pwd = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load the driver" + e.getMessage());
		}

		Scanner scanner;
		scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));

		System.out.println("Please Enter database user name : \n");
		user = scanner.nextLine();

		System.out.println("\n Please Enter database password :  \n");
		// pwd = PasswordField.readPassword("Please Enter database password :");
		pwd = scanner.nextLine();

		// Get a connection
		conn = DriverManager.getConnection(URL, user, pwd);

		Statement stmt1 = conn.createStatement();

		System.out.println(
				"\n \n -----------******* Welcome to the Library Database Management System (Admin) *******-----------");

		boolean exit = false;
		do {
			Menu();
			System.out.print("Please make your choice : ");
			System.out.flush();

			scanner.useDelimiter(System.getProperty("line.separator"));

			String ch = scanner.nextLine();
			System.out.println();
			switch (ch.charAt(0)) {
			case '1':
				BookList(conn);
				break;
			case '2':
				Rating(conn);
				break;
			case '3':
				exit = true;
				break;
			default:
				System.out.println(" Not a valid option ");
			} // switch
		} while (!exit);
		System.out.println("You Successfully Exit from Library......");

		stmt1.close();
		conn.close();

	}

	private static void Menu() {
		System.out.println("\n -------------- \n MENU \n -------------- \n" + "\n\n"
				+ " ----------------------------------------------------------------------------------------------------- ");
		System.out.println("\n (1) Print the list of books which are overdue and not yet returned  ");
		System.out.println("\n (2) Print the BookId, book title and average rating received for each book ");
		System.out.println("\n (3) Exit \n");
		System.out.println(
				" ----------------------------------------------------------------------------------------------------- \n");
	}

	private static void Rating(Connection conn) {
		// TODO Auto-generated method stub


		List<Book> bookList = new ArrayList<Book>();

		Book_Loans_Service bookService = new Book_Loans_Service();
		bookList = bookService.getRatingList();

		for (Book e : bookList) {
			System.out.println(e.getBookId() + " " + e.getTitle() + " :- " + e.getRating());}
	}

	private static void BookList(Connection conn) {
		// TODO Auto-generated method stub

		List<Book> bookList = new ArrayList<Book>();

		Book_Loans_Service bookService = new Book_Loans_Service();
		bookList = bookService.getRatingList();

		for (Book e : bookList) {
			System.out.println(e.getBookId() + " " + e.getTitle());
		}

	}

}
