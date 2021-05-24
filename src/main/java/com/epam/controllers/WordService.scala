package com.epam.controllers

import org.apache.spark.rdd.RDD
import org.springframework.stereotype.Component

import java.lang
import scala.collection.JavaConverters.asJavaIterableConverter

/**
 * @author Evgeny Borisov
 */
@Component
class WordService {
  def topX(rdd: RDD[String], x:Int): lang.Iterable[String] ={
    rdd.map((_,1))
      .reduceByKey(_+_)
      .map(_.swap)
      .sortByKey(ascending = false)
      .map(_._2)
      .take(x)
      .toList
      .asJava





  }

}
