package com.moji.spark_hive

import java.util
import java.util.{ArrayList, HashMap, List, Map}

import com.alibaba.fastjson.JSON
import com.moji.java.moji_rpc.UserLayer
import org.apache.spark.TaskContext
import org.apache.spark.sql.{SaveMode, SparkSession}

object ReadHiveAndTransfer {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("ReadHiveAndTransfer_UserLayer").enableHiveSupport().getOrCreate()
    //    val spark = SparkSession.builder().appName("ReadHiveAndTransfer_UserLayer").enableHiveSupport().getOrCreate()
//    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._

    import scala.collection.JavaConversions._
    import scala.collection.JavaConverters._
//        val list = spark.sparkContext.textFile("/Users/yihong.li/Documents/work/csv/part-00000-6872e51d-d927-4260-8bf1-afa52261810a-c000.json").map(JSON.parseObject(_)).take(3).toSeq.asJava
//    spark.sql("select uid,platform,app_version as version,app_aty_days_1m as activeDays,app_start_cnt_1d as appStartCount,mbr_status as vipStatus,new_date as newDate,silent_time_length as silenceDays,sns_id as snsid from dm.dm_user_tag_info_d where stat_date='2020-06-30' and silent_time_length<180")
//      .repartition(10000)
//      .foreachPartition(iters => {
//        val list = iters.map(_ (0).toString).toSeq.asJava
//        val resultJson = new UserLayer().getUserLayer(JSON.toJSON(list).toString)
//        if (resultJson != null && resultJson.get("code").toString.equals("200")) {
//          val resultDf = JSON.parseArray(resultJson.get("result").toString).map(_.toString).toDF()
//          resultDf.write.json("/tmp/test/weather_test/test/userlayer/testt_result/result_" + TaskContext.getPartitionId())
//        }
//      })

    val users = new util.ArrayList[util.Map[String, AnyRef]]
    val param = new util.HashMap[String, AnyRef]
    param.put("uid", "100017731")
    param.put("platform", "android")
    param.put("version", "1006000102")
    param.put("activeDays", "0")
    param.put("lastActiveDays", "0")
    param.put("appStartCount", "0")
    param.put("vipStatus", "2")
    param.put("newDate", "2013-02-28")
    param.put("silenceDays", "0")
    param.put("snsid", "2")

        val params = JSON.toJSON(users).toString
//        val params = JSON.toJSON(list).toString
        val resultJson = new UserLayer().getUserLayer(params)
        if (resultJson != null && resultJson.get("code").toString.equals("200")) {
          print(resultJson.get("result").toString)
          //      val resultDf = JSON.parseArray(resultJson.get("result").toString).map(_.toString).toDF()
          //      resultDf.write.mode(SaveMode.Overwrite).json("/Users/yihong.li/Documents/work/csv/userlayer/result")
        }
//    spark.stop()


  }
}
