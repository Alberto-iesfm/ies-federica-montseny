package org.iesfm.company;

public interface ICompany {

    void printDepartmentNames();

    Employee[] getDepartmentEmployees(String depName);

    void printDepartmentEmployees (String depName);

    void printEmployees();

    void printDepartmentsDirectors();

    Employee getDepartmentDirector(String depName);

    Employee[] getDepartmentDirectors();
}
