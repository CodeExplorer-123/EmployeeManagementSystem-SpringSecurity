package com.akash.ems.service;

import com.akash.ems.entity.Employee;
import com.akash.ems.entity.UserPrincipal;
import com.akash.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSecurityDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            System.out.println("Employee Not Found");
            throw new UsernameNotFoundException("Employee not found");
        }
        return new UserPrincipal(employee);
    }
}
