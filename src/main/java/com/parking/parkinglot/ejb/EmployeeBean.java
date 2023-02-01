package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.EmployeeDto;
import com.parking.parkinglot.entities.Employee;
import com.parking.parkinglot.entities.Job;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.Status;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeBean {
    private static final Logger LOG = Logger.getLogger(EmployeeBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<EmployeeDto> findAllEmployees() {
        LOG.info("findAllEmployees");
        try {
            TypedQuery<Employee> typedQuery =
                    entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> jobs = typedQuery.getResultList();
            return copyEmployeeToDto(jobs);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<EmployeeDto> copyEmployeeToDto(List<Employee> employees) {
        List<EmployeeDto> employeeDtos = new LinkedList<>();

        for (Employee employee : employees) {
            EmployeeDto dto = new EmployeeDto(
                    employee.getId(),
                    employee.getUser(),
                    employee.getJob());
            employeeDtos.add(dto);
        }

        return employeeDtos;
    }

    public void createEmployee(User user, Job job, Long salary) throws NamingException, SystemException, NotSupportedException {
        LOG.info("createEmployee");
        InitialContext initialContext = new InitialContext();
        UserTransaction userTransaction = (UserTransaction) initialContext.lookup("java:comp/UserTransaction");
        userTransaction.begin();

        try {
            Employee employee = new Employee();

            employee.setUser(user);
            employee.setJob(job);
            employee.setSalary(salary);

            entityManager.persist(employee);

            userTransaction.commit();
        } catch (Exception e) {
            if (userTransaction.getStatus()== Status.STATUS_ACTIVE){
                userTransaction.rollback();
            }
        }
    }

    public EmployeeDto findById(Long employeeId) {
        LOG.info("findJobbyId");
        try {
            TypedQuery<Employee> typedQuery =
                    entityManager.createQuery("SELECT j FROM Job j WHERE j.id = :employeeId", Employee.class)
                            .setParameter("employeeId", employeeId);
            Employee employee = typedQuery.getSingleResult();
            return new EmployeeDto(employee.getId(), employee.getUser(), employee.getJob());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void updateEmployee(
            Long employeeId,
            Job job,
            Long salary
    ) {
        LOG.info("updateJob");

        Employee employee = entityManager.find(Employee.class, employeeId);
        employee.setJob(job);
        employee.setSalary(salary);
    }

    public void deleteEmployeesByIds(Collection<Long> employeeIds) throws NamingException, SystemException, NotSupportedException {
        LOG.info("deleteEmployeesByIds");
        InitialContext initialContext = new InitialContext();
        UserTransaction userTransaction = (UserTransaction) initialContext.lookup("java:comp/UserTransaction");
        userTransaction.begin();

        try {
            for (Long employeeId : employeeIds) {
                Employee employee = entityManager.find(Employee.class, employeeId);
                entityManager.remove(employee);
            }

            userTransaction.commit();
        } catch (Exception e) {
            userTransaction.rollback();
        }
    }
}
