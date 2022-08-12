package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.cart.CreateCartRequest;
import com.etiya.northwind.business.requests.cart.DeleteCartRequest;
import com.etiya.northwind.business.requests.cart.UpdateCartRequest;
import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.CartReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface CartInvoiceService {
    Result add(CreateCartInvoiceRequest createCartInvoiceRequest);
    Result update(UpdateCartInvoiceRequest updateCartInvoiceRequest);
    Result delete(DeleteCartInvoiceRequest deleteCartInvoiceRequest);
    DataResult<CartInvoiceReadResponse> getById(int cartInvoiceId);
    DataResult<List<CartInvoiceListResponse>> getAll();
}
