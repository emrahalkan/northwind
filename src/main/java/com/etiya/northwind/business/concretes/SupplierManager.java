package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.SupplierGetResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService {
	private SupplierRepository supplierRepository;
	private ModelMapperService modelMapperService;
	
	public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {
		this.supplierRepository = supplierRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<SupplierListResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> responses = result.stream().map(supplier->this.modelMapperService.forResponse()
				.map(supplier, SupplierListResponse.class)).collect(Collectors.toList());
		return responses;
	}

	@Override
	public void add(CreateSupplierRequest createSupplierRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DeleteSupplierRequest deleteSupplierRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateSupplierRequest updateSupplierRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SupplierGetResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
		
//		for (Supplier supplier : result) {
//			SupplierListResponse responseSupplier = new SupplierListResponse();
//			responseSupplier.setAddress(supplier.getAddress());
//			responseSupplier.setCompanyName(supplier.getCompanyName());
//			responseSupplier.setContactName(supplier.getContactName());
//			responseSupplier.setContactTitle(supplier.getContactTitle());
//			responseSupplier.setSupplierId(supplier.getSupplierId());
//			
//			responses.add(responseSupplier);
//		}
		
	
}
