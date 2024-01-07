package com.ashutosh.rest.restapp.service;

import com.ashutosh.rest.restapp.dao.FinderSpecification;
import com.ashutosh.rest.restapp.dao.HibernateDAO;
import com.ashutosh.rest.restapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private HibernateDAO<Employee> hibernateDAO;
    @Autowired
    public EmployeeService(HibernateDAO<Employee> hibernateDAO) {
        this.hibernateDAO = hibernateDAO;
    }
    public void save(Employee employee){
        hibernateDAO.save(employee);
    }
    public List<Employee> findAll(){
       return hibernateDAO.findAll(new FinderSpecification<Employee>() {
            @Override
            public Class<Employee> getType() {
                return Employee.class;
            }
        });
    }

    public Employee findById(Long id){
       return hibernateDAO.findById(new FinderSpecification<Employee>() {
            @Override
            public Class<Employee> getType() {
                return Employee.class;
            }
        },id);
    }

    public void update(Employee employee){
        hibernateDAO.update(employee);
    }

}
