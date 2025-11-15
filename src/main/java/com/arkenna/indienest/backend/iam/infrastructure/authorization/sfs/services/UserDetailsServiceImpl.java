package com.arkenna.indienest.backend.iam.infrastructure.authorization.sfs.services;

import com.arkenna.indienest.backend.iam.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.UserName;
import com.arkenna.indienest.backend.iam.infrastructure.authorization.sfs.model.UserDetailsImpl;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.AccountRepository;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for providing the user details to the Spring Security framework.
 * It implements the UserDetailsService interface.
 */
@Service(value = "defaultUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * This method is responsible for loading the user details from the database.
     * @param username The username.
     * @return The UserDetails object.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findByName(new UserName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        var account = accountRepository.findByUserId(new UserId(user.getId()))
                .orElseThrow(() -> new UsernameNotFoundException("Account not found for user: " + username));

        return UserDetailsImpl.build(user, account);
    }
}

