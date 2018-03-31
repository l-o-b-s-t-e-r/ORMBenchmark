package com.lobster.ormbenchmark.domain.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.lobster.ormbenchmark.domain.mapper.CountriesWrapper
import com.lobster.ormbenchmark.domain.response.CountryResponse

import java.io.IOException
import java.util.ArrayList
import java.util.HashMap

/**
 * Created by Lobster on 03.03.18.
 */

class CountriesWrapperDeserializer : StdDeserializer<CountriesWrapper>(CountriesWrapper::class.java) {

    companion object {
        private val NAMES_KEY = "name"
    }

    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): CountriesWrapper {
        val countries = ArrayList<CountryResponse>()
        val mainNode = jp.codec.readTree<JsonNode>(jp)
        val mainNodeIterator = mainNode.fields()

        while (mainNodeIterator.hasNext()) {
            val subNode = mainNodeIterator.next()
            val namesNode = subNode.value.get(NAMES_KEY)
            if (namesNode != null) {
                val names = HashMap<String, String>()  /* Entry<Language Code, Product Name> */
                val nameNodeIterator = namesNode.fields()
                while (nameNodeIterator.hasNext()) {
                    val nameNode = nameNodeIterator.next()
                    val name = nameNode.value.asText()
                    names.put(nameNode.key, name)

                }

                countries.add(CountryResponse(subNode.key, names))
            }
        }

        return CountriesWrapper(countries)
    }
}