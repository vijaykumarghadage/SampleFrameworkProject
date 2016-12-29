package com.cybage.mobitvassignment.home.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class for CategoryList
 * Created by vijaykumargh on 05/10/2016.
 */

public class CategoryList {

    @SerializedName("Categories")
    private List<Category> mCategories = new ArrayList<>();

    /**
     * @return The mCategories
     */
    public List<Category> getCategories() {
        return mCategories;
    }

    /**
     * @param categories The Categories
     */
    public void setCategories(List<Category> categories) {
        this.mCategories = categories;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "mCategories=" + mCategories +
                '}';
    }
}