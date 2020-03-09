package com.prototype.report.main;

import com.prototype.report.entities.Employees;

import java.text.DecimalFormat;
import java.util.List;

public class CompanyPayrollFormatter{
    private static Double grandTotal = (double) 0;
    private static Double totalSalary = (double) 0;
    private static Double salary;

    private static String numberFormat(Double number) throws NumberFormatException{
        DecimalFormat decimalFormat = new DecimalFormat(CompanyPayrollFormat.NUM_FORMAT);
        return decimalFormat.format(number).replaceAll("[.]", ",");
    }

    public static String reportFormatter(List<Employees> list){
        StringBuilder stringBuilder = new StringBuilder();
        boolean headerFlag = true;
        try {
            for(int i=0;i<list.size();i++){
                totalSalary += list.get(i).getSalary();
                grandTotal += list.get(i).getSalary();
                if(headerFlag){
                    stringBuilder.append(CompanyPayrollFormat.HEADER)
                            .append(CompanyPayrollFormat.LINE_BREAKER);
                    headerFlag = false;
                }
                stringBuilder.append(list.get(i).getEmployee_name())
                        .append(CompanyPayrollFormat.PIPE)
                        .append(numberFormat(list.get(i).getSalary()))
                        .append(CompanyPayrollFormat.PIPE)
                        .append(list.get(i).getDepartment().getDepartment_name())
                        .append(CompanyPayrollFormat.LINE_BREAKER);

                if(i != list.size()-1 ? !list.get(i)
                        .getDepartment()
                        .getDepartment_name()
                        .equals(list.get(i+1)
                                .getDepartment()
                                .getDepartment_name()) : i == list.size()-1){
                    stringBuilder.append(CompanyPayrollFormat.TOTAL)
                            .append(CompanyPayrollFormat.PIPE)
                            .append(list.get(i).getDepartment().getDepartment_name())
                            .append(CompanyPayrollFormat.PIPE)
                            .append(numberFormat(totalSalary))
                            .append(CompanyPayrollFormat.LINE_BREAKER)
                            .append(CompanyPayrollFormat.LINE_BREAKER);
                    headerFlag = true;
                    totalSalary = 0d;
                }
            }
            stringBuilder.append(CompanyPayrollFormat.TOTAL)
                    .append(CompanyPayrollFormat.PIPE)
                    .append(numberFormat(grandTotal));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
