package com.telerikacademy.spirnghibernatedemo.data.base;

import com.telerikacademy.spirnghibernatedemo.models.Address;

import java.util.List;

public interface AddressRepository {
    Address getById(int id);
    List<Address> getAll();
}
