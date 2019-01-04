package com.sarojdongol.kinesisspark;

import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;
import com.amazonaws.services.kinesis.model.ShardIteratorType;
import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec;
import org.apache.hadoop.yarn.webapp.view.HtmlPage;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kinesis.KinesisUtils;
import scala.Tuple2;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class SparkStreaming {

    SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
    JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));


    JavaReceiverInputDStream<byte[]> kinesisStream = KinesisUtils.createStream(
            jssc, "sarojdongol", "kinesis-analytics-demo-stream", "kinesis.us-east-1.amazonaws.com",
            "us-east-1", InitialPositionInStream.TRIM_HORIZON, Durations.seconds(1),StorageLevels.MEMORY_AND_DISK_2);


    JavaDStream<String> lines = kinesisStream.map(Tuple2::_2);
    jssc.












}
