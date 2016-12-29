package com.cybage.mobitvassignment.framework.network;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.security.cert.CertificateException;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Class used to create picasso client
 * Created by vijaykumargh on 19/10/2016.
 */

public class PicassoClient {

    private static PicassoClient mInstance;
    private Picasso mPicassoInstance;

    private PicassoClient(Context context) {
        // create Picasso.Builder object
        Picasso.Builder picassoBuilder = new Picasso.Builder(context);

        picassoBuilder.downloader(
                new OkHttpDownloader(
                        getUnsafeOkHttpClient()//supports https requests also
                )
        );
        // Picasso.Builder creates the Picasso object to do the actual requests
        mPicassoInstance = picassoBuilder.build();
    }

    /**
     * Method used to get picasso client
     *
     * @param context context
     * @return PicassoClient
     */
    public static PicassoClient getClient(Context context) {
        if (mInstance == null) {
            mInstance = new PicassoClient(context);
        }
        return mInstance;
    }

    /**
     * Method returns picasso instance
     *
     * @return Picasso
     */
    public Picasso getPicassoInstance() {
        return mPicassoInstance;
    }


    /**
     * Method used to get https client
     *
     * @return OkHttpClient
     */
    private OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setSslSocketFactory(sslSocketFactory);
            okHttpClient.setProtocols(Arrays.asList(Protocol.HTTP_1_1));
            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
