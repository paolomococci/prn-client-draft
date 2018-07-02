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

package local.example.draft.retrieve;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author paolo mococci
 */

public class RestRetrieve {

    protected static final String DOUBLE_URI = "http://localhost:9090/api/prn/double";
    protected static final String LONG_URI = "http://localhost:9090/api/prn/long";
    protected static final String HEX_STRING_URI = "http://localhost:9090/api/str/hex";
    
    private final RestTemplate restTemplate;

    public RestRetrieve() {
        super();
        this.restTemplate = new RestTemplate();
    }
    
    public String doubleUriResponse() 
            throws Exception {
        Double doubleResponse = restTemplate.getForObject(DOUBLE_URI, 
                Double.class);
        String stringResponse = String.valueOf(doubleResponse);
        return stringResponse;
    }
    
    public String longUriResponse() 
            throws Exception {
        Long longResponse = restTemplate.getForObject(LONG_URI, 
                Long.class);
        String stringResponse = String.valueOf(longResponse);
        return stringResponse;
    }
    
    public String hexStringUriResponse() 
            throws Exception {
        String hexStringResponse = restTemplate.getForObject(HEX_STRING_URI, 
                String.class);
        return hexStringResponse;
    }
}
