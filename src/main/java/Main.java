import com.revature.beans.User;
import com.revature.middle.BusinessDelegate;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, NamingException {
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the reimbursement system");
        System.out.println("Please enter your username");
        username = scanner.next();
        System.out.println("Please enter your password");
        password = scanner.next();
        try {
            BusinessDelegate businessDelegate = new BusinessDelegate();
            User user = businessDelegate.login(username, password);
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() + " to the reimbursement system");
            businessDelegate.addReimbursementRequest(username, 14.50, "Soap", "C:/Users/yehur/Desktop/a.gif", 1, "Pending", 4, "OTHER");
            System.out.println(businessDelegate.viewAllReimbursements());
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
