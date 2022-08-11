package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductGetResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
		this.productRepository = productRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ProductListResponse>> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> responses = result.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ProductListResponse>>(responses);
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		checkIfCategoryCount(createProductRequest.getCategoryId());
		checkIfProductNameExists(createProductRequest.getProductName());
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);

		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {
		this.productRepository.deleteById(deleteProductRequest.getProductId());
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productRepository.save(product);
		
		return new SuccessResult("Updated");
	}

	@Override
	public DataResult<ProductGetResponse> getById(int id) {
		Product product = this.productRepository.findById(id).get();
		ProductGetResponse productResponse = this.modelMapperService.forResponse().map(product,
				ProductGetResponse.class);
		return new SuccessDataResult<ProductGetResponse>(productResponse);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		List<Product> result = this.productRepository.findAll(pageable).getContent();
		List<ProductListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ProductListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAllSortedByAsc(String field) {
		Sort sort = Sort.by(Sort.Order.asc(field));

		List<Product> result = this.productRepository.findAll(sort);
		List<ProductListResponse> response = result.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAllSortedByDesc(String field) {
		Sort sort = Sort.by(Sort.Order.desc(field));

		List<Product> result = this.productRepository.findAll(sort);
		List<ProductListResponse> response = result.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	private void checkIfCategoryCount(int categoryId) {
		List<Product> products = this.productRepository.getByCategoryCategoryId(categoryId);
		if (products.size() >= 15) {
			throw new BusinessException("Category limit exceeded");
		}
	}
	
	private void checkIfProductNameExists(String productName) {
		Product product = this.productRepository.getByProductName(productName);
		if (product != null) {
			throw new BusinessException("ALREADY.EXISTS");
		}
	}

}
