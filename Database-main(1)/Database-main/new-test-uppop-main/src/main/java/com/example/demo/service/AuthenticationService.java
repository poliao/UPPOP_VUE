package com.example.demo.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class AuthenticationService {

    // เข้าใช้งานฐานข้อมูลหรือบริการอื่นเพื่อตรวจสอบ username และ password
    private final PersonRepository pserRepository;

    public AuthenticationService(PersonRepository pserRepository) {
        this.pserRepository = pserRepository;
    }

    public boolean authenticate(String email, String password) {
        // ตรวจสอบว่ามีผู้ใช้งานในฐานข้อมูลหรือไม่
        Optional<Person> person = pserRepository.findByEmail(email);

    // If the person is not found, or the password doesn't match
    if (person.isEmpty() || !person.get().getPassword().equals(password)) {
        return false;
    }
        // ถ้า username และ password ถูกต้อง
        return true;
    }
}
