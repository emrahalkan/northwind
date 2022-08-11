package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
		this.employeeRepository = employeeRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		checkIfReportsToLimitExceeds(createEmployeeRequest.getReportsTo());
		this.employeeRepository.save(employee);	
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		
		return new SuccessResult("Updated");
	}

	@Override
	public DataResult<EmployeeGetResponse> getById(int id) {
		Employee employee = this.employeeRepository.findById(id).get();
		EmployeeGetResponse response = this.modelMapperService.forResponse().map(employee, EmployeeGetResponse.class);
		return new SuccessDataResult<>(response);	
	}
	
	@Override
	public DataResult<List<EmployeeListResponse>> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> responses = result.stream().map(employee -> this.modelMapperService.forResponse()
				.map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(responses);
	}
	
	private void checkIfReportsToLimitExceeds(Integer reportsTo) {
		List<Employee> employees = this.employeeRepository.getByReportsTo(reportsTo);
		if (employees.size() > 10) {
			throw new BusinessException("LIMIT.EXCEEDED");
		}
	}

	
}
