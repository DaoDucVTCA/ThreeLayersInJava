package vn.edu.vtc.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn.edu.vtc.persistence.*;

public class employee_dal
{
    private String querry;
    private ResultSet rs;
    public employee getEmployeeById(int emp_id) throws SQLException
    {
        querry = "SELECT emp_no, first_name, last_name FROM employees WHERE emp_no = " + emp_id + ";";
        dbhelper.GetJDBCConnection();
        rs = dbhelper.ExecQuerry(querry);

        employee emp = null;
        while(rs.next())
        {
            emp = getEmployeeInfo(rs);
        }

        dbhelper.CloseConnection();
        return emp;
    }

    private employee getEmployeeInfo(ResultSet rs2) throws SQLException {
        employee emp = new employee();
        emp.employee_id = rs.getInt("emp_no");
        emp.employee_first_name = rs.getString("first_name");
        emp.employee_last_name = rs.getNString("last_name");

        return emp;
    }
}