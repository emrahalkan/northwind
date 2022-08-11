package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryGetResponse;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
		this.categoryRepository = categoryRepository;
		this.modelMapperService = modelMapperService;
	}


	@Override
	public Result add(CreateCategoryRequest createCategoryRequest) {
		checkIfCategoryNameExists(createCategoryRequest.getCategoryName());
		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		
		return new SuccessDataResult<>("Added");
	}

	@Override
	public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
		this.categoryRepository.deleteById(deleteCategoryRequest.getCategoryId());
		
		return new SuccessDataResult<>("Deleted");

	}

	@Override
	public Result update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		
		return new SuccessDataResult<>("Updated");

	}

	@Override
	public DataResult<CategoryGetResponse> getById(int id) {
		Category category = this.categoryRepository.findById(id).get();		
		CategoryGetResponse response = this.modelMapperService.forRequest().map(category, CategoryGetResponse.class);
		
		return new SuccessDataResult<CategoryGetResponse>(response);
	}
	
	@Override
	public DataResult<List<CategoryListResponse>> getAll() {
		List<Category> result = this.categoryRepository.findAll();
		List<CategoryListResponse> response = result.stream().map(category -> this.modelMapperService.forResponse()
				.map(category, CategoryListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CategoryListResponse>>(response);
	}
	
	private void checkIfCategoryNameExists(String categoryName) {
		Category category = this.categoryRepository.getByCategoryName(categoryName);
		if (category != null) {
			throw new BusinessException("ALREADY.EXISTS");
		}
	}

}
