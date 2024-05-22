package com.example.Investmentinsight.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Investmentinsight.Document.MyUserPrincipal;
import com.example.Investmentinsight.Document.User;
import com.example.Investmentinsight.Repository.UserRepository;

import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username.toLowerCase());
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {
            return new MyUserPrincipal(user.get());
        }
    }
}
