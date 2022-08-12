package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.cart.CreateCartRequest;
import com.etiya.northwind.business.requests.cart.DeleteCartRequest;
import com.etiya.northwind.business.requests.cart.UpdateCartRequest;
import com.etiya.northwind.business.requests.cartItems.CreateCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.DeleteCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.UpdateCartItemsRequest;
import com.etiya.northwind.business.responses.CartItems.CartItemsListResponse;
import com.etiya.northwind.business.responses.CartItems.CartItemsReadResponse;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.CartReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface CartItemService {
    Result add(CreateCartItemsRequest createCartItemRequest);
    Result update(UpdateCartItemsRequest updateCartItemsRequest);
    Result delete(DeleteCartItemsRequest deleteCartItemsRequest);
    DataResult<CartItemsReadResponse> getById(int cartItemId);
    DataResult<List<CartItemsListResponse>> getAll();
}
