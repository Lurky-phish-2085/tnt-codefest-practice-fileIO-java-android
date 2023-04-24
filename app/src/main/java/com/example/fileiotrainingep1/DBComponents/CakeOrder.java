package com.example.fileiotrainingep1.DBComponents;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cake_table")
public  class CakeOrder {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @Nullable
    private String flavor, size, icing, message, name, contact, date, imgUri, totalAmount;
    @Nullable
    private boolean hasFruit, isCustomImage;
    @Nullable
    private double flavor_val, size_val, icing_val, fruit_val;

    public CakeOrder(@Nullable String flavor, @Nullable String size, @Nullable String icing, @Nullable String message, @Nullable String name, @Nullable String contact, @Nullable String date, @Nullable String imgUri, @Nullable String totalAmount, boolean hasFruit, boolean isCustomImage, double flavor_val, double size_val, double icing_val, double fruit_val) {
        this.flavor = flavor;
        this.size = size;
        this.icing = icing;
        this.message = message;
        this.name = name;
        this.contact = contact;
        this.date = date;
        this.imgUri = imgUri;
        this.totalAmount = totalAmount;
        this.hasFruit = hasFruit;
        this.isCustomImage = isCustomImage;
        this.flavor_val = flavor_val;
        this.size_val = size_val;
        this.icing_val = icing_val;
        this.fruit_val = fruit_val;
    }

    public CakeOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(@Nullable String flavor) {
        this.flavor = flavor;
    }

    @Nullable
    public String getSize() {
        return size;
    }

    public void setSize(@Nullable String size) {
        this.size = size;
    }

    @Nullable
    public String getIcing() {
        return icing;
    }

    public void setIcing(@Nullable String icing) {
        this.icing = icing;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    public void setMessage(@Nullable String message) {
        this.message = message;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getContact() {
        return contact;
    }

    public void setContact(@Nullable String contact) {
        this.contact = contact;
    }

    @Nullable
    public String getDate() {
        return date;
    }

    public void setDate(@Nullable String date) {
        this.date = date;
    }

    @Nullable
    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(@Nullable String imgUri) {
        this.imgUri = imgUri;
    }

    @Nullable
    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(@Nullable String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isHasFruit() {
        return hasFruit;
    }

    public void setHasFruit(boolean hasFruit) {
        this.hasFruit = hasFruit;
    }

    public boolean isCustomImage() {
        return isCustomImage;
    }

    public void setCustomImage(boolean customImage) {
        isCustomImage = customImage;
    }

    public double getFlavor_val() {
        return flavor_val;
    }

    public void setFlavor_val(double flavor_val) {
        this.flavor_val = flavor_val;
    }

    public double getSize_val() {
        return size_val;
    }

    public void setSize_val(double size_val) {
        this.size_val = size_val;
    }

    public double getIcing_val() {
        return icing_val;
    }

    public void setIcing_val(double icing_val) {
        this.icing_val = icing_val;
    }

    public double getFruit_val() {
        return fruit_val;
    }

    public void setFruit_val(double fruit_val) {
        this.fruit_val = fruit_val;
    }
}