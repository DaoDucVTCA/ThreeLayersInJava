package vn.edu.vtc;

import java.sql.SQLException;

import vn.edu.vtc.dal.*;
import vn.edu.vtc.persistence.*;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        employee_dal emp_dal = new employee_dal();

        employee emp = emp_dal.getEmployeeById(10001);
        System.out.println(emp.employee_first_name);
    }
}
