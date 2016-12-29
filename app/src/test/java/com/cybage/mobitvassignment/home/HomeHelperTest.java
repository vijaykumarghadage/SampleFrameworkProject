package com.cybage.mobitvassignment.home;

import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.framework.network.NetworkConnector;
import com.cybage.mobitvassignment.home.model.CategoryList;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JUnit test class for HomeHelper
 * Created by vijaykumargh on 07/10/2016.
 */

public class HomeHelperTest {

    private HomeHelper mHomeHelper;

    @Before
    public void setUp() throws Exception {
        mHomeHelper = new HomeHelper(null, Constants.GET_CATEGORIES);
    }

    @Test
    public void testCategoryResponse() throws Exception {
        assertNotNull(mHomeHelper);
        assertEquals(1001, Constants.GET_CATEGORIES);

        CategoryList categories = NetworkConnector.getInstance().getCategories();
        assertNotNull(categories);
        Response<CategoryList> response = Response.success(categories);
        assertNotNull(response);
        assertEquals(200, response.code());
        assertNotNull(response.body());
    }
}
