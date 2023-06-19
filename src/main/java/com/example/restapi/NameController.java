package com.example.restapi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class NameController {
    @GetMapping("/name")
    String getName(
            @Validated @NotNull @NotBlank @Length(max = 20) @RequestParam("name") String name, @RequestParam("date") String date) {

        return "名前:" + name + System.lineSeparator() + "生年月日:" + date;
    }

    @PostMapping("/name")
    public ResponseEntity<String> create(@RequestBody NameDateFormat form) {
        // 登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/name")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name,date, successfully created");
    }

    @PatchMapping("/name/{number}")
    public String update(@PathVariable("number") int number, @RequestBody UpdateForm form) {
        //　更新処理は省略
        return ( "message, successfully updated" );
    }

    @DeleteMapping("/name/{number}")
    public String deleteName(@PathVariable("number") int number) {
        // 更新処理は省略
        return ( "message,name successfully deleted" );
    }
}
