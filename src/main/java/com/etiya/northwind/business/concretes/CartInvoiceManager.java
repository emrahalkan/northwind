package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartInvoiceService;
import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public class CartInvoiceManager implements CartInvoiceService {
    @Override
    public Result add(CreateCartInvoiceRequest createCartInvoiceRequest) {
        return null;
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
}
