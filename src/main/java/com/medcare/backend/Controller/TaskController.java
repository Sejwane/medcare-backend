package com.medcare.backend.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @PostMapping("/sort")
    public Map<String, List<String>> sortString(@RequestBody Map<String, String> request) {
        String data = request.get("data"); 

        // Safety check: if data is missing, return an empty list
        if (data == null) {
            return Collections.singletonMap("word", Collections.emptyList());
        }

        // Convert to array, sort alphabetically, and collect into a list
        List<String> sortedList = Arrays.stream(data.split(""))
                                        .sorted()
                                        .collect(Collectors.toList());

        // Return as "word" as per the requirement
        return Collections.singletonMap("word", sortedList);
    }
}