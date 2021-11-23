package com.daelim.paguda.service;

import com.daelim.paguda.domain.user.User;
import com.daelim.paguda.domain.user.UserRepository;
import com.daelim.paguda.dto.UserDto;
import com.daelim.paguda.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
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

    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다.")
        );
        return new UserResponseDto(entity);
    }
}
