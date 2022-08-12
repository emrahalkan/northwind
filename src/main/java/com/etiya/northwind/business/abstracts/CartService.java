package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.cart.CreateCartRequest;
import com.etiya.northwind.business.requests.cart.DeleteCartRequest;
import com.etiya.northwind.business.requests.cart.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.CartReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Cart;

import java.util.List;

public interface CartService {
    Result add(CreateCartRequest createCartRequest);
    Result update(UpdateCartRequest updateCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);
    DataResult<CartReadResponse> getById(int cartId);
    DataResult<List<CartListResponse>> getAll();
}
