package com.example.lenovo.xiehaojia_20171221.utils;

import android.app.Application;
import android.content.Context;

import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Fresco.initialize(this);
        Fresco.initialize(this,Fresco_ImagePipelineConfigUtil.getDefaultImagePipelineConfig(this));
    }

}