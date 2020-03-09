package com.prototype.report.main;

import com.prototype.report.entities.Employees;
import org.hibernate.HibernateException;
import java.time.LocalDateTime;

public class CompanyPayrollGen {
    public static void generateReport(){
        try {
            CompanyPayrollDAO<Employees> companyPayrollDAO = new CompanyPayrollDAO<Employees>();
            String query = CompanyPayrollFileHandler.read("files/Queries/query.txt");
            String result = CompanyPayrollFormatter.reportFormatter(companyPayrollDAO.fetchByCustomQuery(query));
            String localDateTime = LocalDateTime.now().toString().replaceAll("[-:]", "_");
            CompanyPayrollFileHandler.write(result, "files/Reports/Report_"+localDateTime+".txt");
        } catch (NullPointerException | HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateReport();
    }
}
