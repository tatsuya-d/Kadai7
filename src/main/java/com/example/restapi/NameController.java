package com.example.restapi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class NameController {

    @GetMapping("/name")
    public NameDateResponse getName(
            @Validated @NotNull @NotBlank @Length(max = 20) @RequestParam("name") String name, @RequestParam("date") String date) {
        return new NameDateResponse("tatsuya", "1993-10-30");
    }

    @PostMapping("/name")
    ResponseEntity<Map<String, String>> create(@RequestBody NameDateResponse form) {
        // 登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/name")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name and date was successfully created"));
    }

    @PatchMapping("/name/{number}")
    ResponseEntity<Map<String, String>> update(@PathVariable("number") int number, @RequestBody UpdateForm form) {
        //　更新処理は省略
        return ResponseEntity.ok(Map.of("message", "successfully updated"));
    }

    @DeleteMapping("/name/{number}")
    public ResponseEntity<Void> delete(@PathVariable("number") int deleteNumber) {
        return ResponseEntity.noContent().build();
    }
}
