package com.riabushenkp.auth.ejb;

import com.riabushenkp.auth.domain.Credentials;
import com.riabushenkp.auth.domain.Client;
import org.apache.commons.lang3.StringUtils;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AuthenticationManager {
    @PersistenceContext(unitName = "JPATest")
    private EntityManager entityManager;

    public Client.Role login (String email, String password) {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            return null;
        }
        Credentials credentials = entityManager.find(Credentials.class, email);
        if (credentials == null) {
            return null;
        }
        if (!password.equals(credentials.getPassword())) {
            return null;
        }

       Client user = credentials.getClient();
        if (user == null) {
            return null;
        }
        return Client.getRole;

    }
    }

