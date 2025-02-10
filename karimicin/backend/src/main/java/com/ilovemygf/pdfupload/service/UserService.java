/*
 * Kullanicilari maymun gibi elle giriyoruz.
 * Bunun yerine, database'den alinmasi gerekiyor.
 * Complexity discretion analizi yapilabilir.
 * Eger database ekleyeceksem Elasticsearch kullanip ekstra bir servis yazmak istiyorum.
 * Ancak ucuncu parti servis karisinda pek bir etkisi olmayabilir.
 * Daha sonra karar verecegim.
 * 
 * Author: Ahmet
 * Son Guncelleme: 10.02.2025
*/
package com.ilovemygf.pdfupload.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {

    private final Map<String, String> users = new HashMap<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService() {
        // Örnek kullanıcılar (gerçek uygulamada database'den gelecek)
        users.put("ahmet", passwordEncoder.encode("ahmet123"));
        users.put("mehmet", passwordEncoder.encode("mehmet123"));
        users.put("ayse", passwordEncoder.encode("ayse123"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encodedPassword = users.get(username);
        if (encodedPassword == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new User(username, encodedPassword, new ArrayList<>());
    }
} 