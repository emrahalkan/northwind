package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.cart.CreateCartRequest;
import com.etiya.northwind.business.requests.cart.DeleteCartRequest;
import com.etiya.northwind.business.requests.cart.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.CartReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public class CartManager implements CartService {
    @Override
    public Result add(CreateCartRequest createCartRequest) {
        return null;
    }

    @Override
    public Result update(UpdateCartRequest updateCartRequest) {
        return null;
    }

    @Override
    public Result delete(DeleteCartRequest deleteCartRequest) {
        return null;
    }

    @Override
    public DataResult<CartReadResponse> getById(int cartId) {
        return null;
    }

    @Override
    public DataResult<List<CartListResponse>> getAll() {
        return null;
    }
}
