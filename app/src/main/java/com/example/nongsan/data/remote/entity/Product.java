package com.example.nongsan.data.remote.entity;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("price")
    public double price;

    @SerializedName("image")
    public String image;

    @SerializedName("categories_id")
    public int categoryId;

}
