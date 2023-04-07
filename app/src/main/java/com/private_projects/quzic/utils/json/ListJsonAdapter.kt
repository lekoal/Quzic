package com.private_projects.quzic.utils.json

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class ListJsonAdapter<T>(private val elementAdapter: JsonAdapter<T>) : JsonAdapter<List<T>>() {
    override fun fromJson(reader: JsonReader): List<T> {
        val result = mutableListOf<T>()
        reader.beginArray()
        while (reader.hasNext()) {
            val element = elementAdapter.fromJson(reader)
            if (element != null) {
                result.add(element)
            }
        }
        reader.endArray()
        return result
    }

    override fun toJson(writer: JsonWriter, value: List<T>?) {
        writer.beginArray()
        value?.forEach { element ->
            elementAdapter.toJson(writer, element)
        }
        writer.endArray()
    }

}