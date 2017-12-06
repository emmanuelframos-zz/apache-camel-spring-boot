package com.poc.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by amanda on 06/02/17.
 */
@EqualsAndHashCode
@Configuration
public class MailConfig {

    @Value("${cit.mail.protocol}")
    @Getter
    private String protocol;

    @Value("${cit.mail.host}")
    @Getter
    private String host;

    @Value("${cit.mail.from}")
    @Getter
    private String from;

    @Value("${cit.mail.to.info}")
    @Getter
    private String toInfoEmail;

    @Value("${cit.mail.to.error}")
    @Getter
    private String toErrorEmail;

    @Value("${cit.mail.to.test}")
    @Getter
    private String toTestEmail;

    public String getErrorEmailUri() {
        return protocol + "://" + host + "?from=" + from + "&to=" + toErrorEmail;
    }

    public String getTestEmailUri() {
        return protocol + "://" + host + "?from=" + from + "&to=" + toTestEmail;
    }

    public String getInfoEmailUri() {
        return protocol + "://" + host + "?from=" + from + "&to=" + toInfoEmail;
    }

    public String getEmailUriWithDestination(String emailDestination) {
        return protocol + "://" + host + "?from=" + from + "&to=" + emailDestination;
    }
}
