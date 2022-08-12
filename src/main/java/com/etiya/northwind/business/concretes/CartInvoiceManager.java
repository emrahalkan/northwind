package com.etiya.northwind.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartInvoiceService;
import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CartInvoiceRepository;
import com.etiya.northwind.dataAccess.abstracts.CartItemRepository;
import com.etiya.northwind.entities.concretes.CartInvoice;
import com.etiya.northwind.entities.concretes.CartItem;

@Service
public class CartInvoiceManager implements CartInvoiceService {
	private ModelMapperService modelMapperService;
	private CartInvoiceRepository cartInvoiceRepository;
	private CartItemRepository cartItemRepository;
	
    public CartInvoiceManager(ModelMapperService modelMapperService, CartInvoiceRepository cartInvoiceRepository) {
		this.modelMapperService = modelMapperService;
		this.cartInvoiceRepository = cartInvoiceRepository;
	}

	@Override
    public Result add(CreateCartInvoiceRequest createCartInvoiceRequest) {
    	CartInvoice cartInvoice = this.modelMapperService.forRequest().map(createCartInvoiceRequest, CartInvoice.class);
    	cartInvoice.setTotalPrice(totalPrice(createCartInvoiceRequest.getCartId()));
    	this.cartInvoiceRepository.save(cartInvoice);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(UpdateCartInvoiceRequest updateCartInvoiceRequest) {
        return null;
    }

    @Override
    public Result delete(DeleteCartInvoiceRequest deleteCartInvoiceRequest) {
        return null;
    }

    @Override
    public DataResult<CartInvoiceReadResponse> getById(int cartInvoiceId) {
        return null;
    }

    @Override
    public DataResult<List<CartInvoiceListResponse>> getAll() {
        return null;
    }
    
    private double totalPrice(int cartId) {
		List<CartItem> cartItems = this.cartItemRepository.getByCartCartId(cartId);
		double totalPrice = 0;
		for (CartItem item : cartItems) {
			totalPrice += item.getUnitPrice() * item.getQuantity();
		}
		return totalPrice;
	}
}
