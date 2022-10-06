package com.example.nongsan.data.dao.model;

public class Favourite {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE favourites (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "price NUMERIC," +
                    "image TEXT,"+
                    "product_id INTEGER)";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS favourites";
    public int id;
    public String name;
    public double price;
    public String image;
    public int product_id;

    public Favourite(int id, String name, double price, String image, int product_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.product_id = product_id;
    }
}
