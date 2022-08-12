package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartItemService;
import com.etiya.northwind.business.requests.cartItems.CreateCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.DeleteCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.UpdateCartItemsRequest;
import com.etiya.northwind.business.responses.CartItems.CartItemsListResponse;
import com.etiya.northwind.business.responses.CartItems.CartItemsReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public class CartItemManager implements CartItemService {
    @Override
    public Result add(CreateCartItemsRequest createCartItemRequest) {
        return null;
    }

    @Override
    public Result update(UpdateCartItemsRequest updateCartItemsRequest) {
        return null;
    }

    @Override
    public Result delete(DeleteCartItemsRequest deleteCartItemsRequest) {
        return null;
    }

    @Override
    public DataResult<CartItemsReadResponse> getById(int cartItemId) {
        return null;
    }

    @Override
    public DataResult<List<CartItemsListResponse>> getAll() {
        return null;
    }
}
