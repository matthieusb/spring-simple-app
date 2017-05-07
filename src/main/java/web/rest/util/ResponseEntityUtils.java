package web.rest.util;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityUtils {

    public static <E> ResponseEntity<?> getResponseEntityForSingleResponse(E elementToReturn) {
        if (elementToReturn == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(elementToReturn, HttpStatus.OK);
        }
    }

    public static <E> ResponseEntity<?> getResponseEntityForMultipleResponses(List<E> listToReturn) {
        if (listToReturn.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listToReturn, HttpStatus.OK);
        }
    }

    public static HttpHeaders getStandardHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
}
