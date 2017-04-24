package com.bawei.tianshuo.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient = new OkHttpClient();
        text = (TextView) findViewById(R.id.text);
        getData();
       // getPost();
    }

    public void getData() {
        String url = "http://publicobject.com/helloworld.txt";
        Request request=new Request.Builder().url(url).build();
        //得到call
         Call call=okHttpClient.newCall(request);
        //请求加入调度
      call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            text.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
       /* try {
            Response response=call.execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
           *//* for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }*//*

           text.setText(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public void getPost() {

        String url = "http://api.ehuigou.com/Orders/searchCartsLog";
        //创建FormEncodingBuilder用来封装参数
        FormEncodingBuilder mFeb = new FormEncodingBuilder();
        //store_id = 3850
        mFeb.add("store_id", "3850");
        //创建Request
        Request mReuest = new Request.Builder().url(url).post(mFeb.build()).build();
        Call call = okHttpClient.newCall(mReuest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            text.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
