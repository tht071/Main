package com.example.nongsan.data.dao.implement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nongsan.data.dao.DatabaseHelper;
import com.example.nongsan.data.dao.OrderDetailDao;
import com.example.nongsan.data.dao.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImplement extends DatabaseHelper implements OrderDetailDao {
    public OrderDetailDaoImplement(Context context) {
        super(context);
    }

    @Override
    public OrderDetail find(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("orders_details", null, "id = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        OrderDetail product = new OrderDetail(cursor.getInt(0), cursor.getString(1),cursor.getInt(2),cursor.getDouble(3),  cursor.getString(4), cursor.getInt(5));
        return product;
    }

    @Override
    public OrderDetail findByProductId(int productId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("orders_details", null, "product_id = ?", new String[] { String.valueOf(productId) },null, null, null);
        if(cursor != null) {
            if(cursor.moveToFirst()){
                OrderDetail product = new OrderDetail(cursor.getInt(0), cursor.getString(1),cursor.getInt(2),cursor.getDouble(3),  cursor.getString(4), cursor.getInt(5));
                return product;
            }
        }
        return null;
    }

    @Override
    public List<OrderDetail> all() {
        List<OrderDetail>  productList = new ArrayList<>();
        String query = "SELECT * FROM orders_details";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            OrderDetail product = new OrderDetail(cursor.getInt(0), cursor.getString(1),cursor.getInt(2),cursor.getDouble(3),  cursor.getString(4), cursor.getInt(5));
            productList.add(product);
            cursor.moveToNext();
        }
        return productList;
    }

    @Override
    public void insert(OrderDetail product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", product.name);
        values.put("price", product.price);
        values.put("quantity", product.quantity);
        values.put("image", product.image);
        values.put("product_id", product.productId);


        db.insert("orders_details", null, values);
        db.close();
    }

    @Override
    public void update(OrderDetail product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", product.name);
        values.put("quantity", product.quantity);
        values.put("price", product.price);
        values.put("image", product.image);

        db.update("orders_details", values, "id = ?", new String[] { String.valueOf(product.id) });
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("orders_details", "id = ?", new String[] { String.valueOf(id) });
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("orders_details", "id > ?", new String[] { String.valueOf(0) });
        db.close();
    }
}
