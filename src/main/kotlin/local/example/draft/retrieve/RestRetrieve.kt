/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.draft.retrieve

import org.springframework.web.client.RestTemplate

class RestRetrieve(
        private val restTemplate: RestTemplate = RestTemplate()
) {

    @Throws(Exception::class)
    fun doubleUriResponse(): String {
        val doubleResponse: Double?
        doubleResponse = restTemplate.getForObject(
                DOUBLE_URI,
                Double::class.java)
        return doubleResponse.toString()
    }

    @Throws(Exception::class)
    fun longUriResponse(): String {
        val longResponse: Long?
        longResponse = restTemplate.getForObject(
                LONG_URI,
                Long::class.java)
        val stringResponse = longResponse.toString()
        return stringResponse
    }

    @Throws(Exception::class)
    fun hexStringUriResponse(): String? {
        val hexStringResponse: String?
        hexStringResponse = restTemplate.getForObject(
                HEX_STRING_URI,
                String::class.java)
        return hexStringResponse
    }

    companion object {
        protected val DOUBLE_URI = "http://localhost:9090/api/prn/double"
        protected val LONG_URI = "http://localhost:9090/api/prn/long"
        protected val HEX_STRING_URI = "http://localhost:9090/api/str/hex"
    }
}
