/*
 * @(#)ReferenceDateClaimsVerifier.java 1.0 27/01/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */

package br.gov.sp.fatec.mapskills.authentication.jwt;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * A classe <code>NotBeforeTimeClaimsVerifier</code> verifica se o JWT sendo
 * verificado esta dentro do limite minimo de tempo, ou, em outras palavras,
 * expirado.
 *
 * @author Roberto Perillo
 * @version 1.0 09/10/2016
 */
@Component
public class ReferenceDateClaimsVerifier implements JwtVerifier {

	/** {@inheritDoc} */
    @Override
    public void verify(final JWT jwt) {
        final JWTClaimsSet claims;
        try {
            claims = jwt.getJWTClaimsSet();
        } catch (final ParseException exception) {
            throw new JwtTokenException("Invalid JWT.", exception);
        }
        final Date expirationTime = claims.getExpirationTime();
        if (expirationTime == null || expirationTime.before(new Date())) {
            throw new JwtTokenException("The token is expired");
        }
    }
}