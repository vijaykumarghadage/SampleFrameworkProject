package com.cybage.mobitvassignment.details;

import com.cybage.mobitvassignment.details.model.Details;
import com.cybage.mobitvassignment.details.model.SimilarClipsList;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.framework.network.NetworkConnector;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Details Helper JUnit Test class
 * Created by vijaykumargh on 07/10/2016.
 */

public class DetailsHelperTest {

    private DetailsHelper mDetailsHelper;

    @Before
    public void setUp() throws Exception {
        mDetailsHelper = new DetailsHelper(null, Constants.GET_DETAILS);
    }

    @Test
    public void testDetailsResponse() throws Exception {
        assertNotNull(mDetailsHelper);
        assertEquals(1002, Constants.GET_DETAILS);
        Details details = NetworkConnector.getInstance().getDetailsResponse("i1");
        assertNotNull(details);
        Response<Details> response = Response.success(details);
        assertNotNull(response);
        assertEquals(200, response.code());
        assertNotNull(response.body());
    }

    @Test
    public void testClipsResponse() throws Exception {
        mDetailsHelper = new DetailsHelper(null, Constants.GET_SIMILAR_CLIPS);
        assertNotNull(mDetailsHelper);
        assertEquals(1003, Constants.GET_SIMILAR_CLIPS);
        SimilarClipsList clipsList = NetworkConnector.getInstance().getSimilarClipsResponse("clipId1");
        assertNotNull(clipsList);
        Response<SimilarClipsList> response = Response.success(clipsList);
        assertNotNull(response);
        assertEquals(200, response.code());
        assertNotNull(response.body());

    }
}
