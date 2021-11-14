package com.daelim.paguda.service;

import com.daelim.paguda.domain.UserRepository;
import com.daelim.paguda.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.encodePassword(encoder.encode(userDto.getPassword()));
        return userRepository.save(userDto.toEntity()).getId();
    }

}
