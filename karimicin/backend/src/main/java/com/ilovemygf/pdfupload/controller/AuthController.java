/*
 * Kullanici login oldugunda JWT tokeni veriyor
 * 
 * Author: Ahmet
 * Son Guncelleme: 02.10.2025
 * TODO: 
 * 1. UserService eklenecek
 *    - Veritabani baglantisi
 *    - Kullanici dogrulama
 *    - Sifre hash'leme
 * 2. JwtTokenProvider eklenecek
 *    - Token olusturma
 *    - Token dogrulama
 *    - Token suresi ayarlama
 * 3. Hata yonetimi gelistirilecek
 *    - Daha detayli hata mesajlari
 *    - Loglama sistemi
 * 4. "demoUser" ve "FAKE_TOKEN" kaldirilacak
*/
package com.ilovemygf.pdfupload.controller;

import com.ilovemygf.pdfupload.model.LoginRequest;
import com.ilovemygf.pdfupload.model.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        if ("demoUser".equals(request.getUsername()) && "demoPass".equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse("FAKE_TOKEN_ABC123"));
        }
        return ResponseEntity.status(401).body(null);
    }
}