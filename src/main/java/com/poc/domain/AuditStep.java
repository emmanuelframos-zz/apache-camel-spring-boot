package com.poc.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "auditStep")
public class AuditStep {

    private Date processedAt;

    private String fileName;

    private String name;

    private String inputContent;

    private String outputContent;

    private String errorTrace;

    private String login;

    public Long index;

}
