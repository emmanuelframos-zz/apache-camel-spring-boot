package com.poc.service;

import com.poc.domain.AuditStep;
import com.poc.repository.AuditStepRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AuditStepService {

    private static final Logger logger = LoggerFactory.getLogger(AuditStepService.class);

    @Autowired
    private AuditStepRepository repository;

    private void audit(Long index, String name, String fileName, String inputContent, String outputContent, String trace, String login) {
        AuditStep step = new AuditStep();
        step.setName(name);
        step.setProcessedAt(new Date());
        step.setInputContent(inputContent);
        step.setOutputContent(outputContent);
        step.setIndex(index);
        step.setErrorTrace(trace);
        step.setFileName(fileName);
        step.setLogin(login);
        repository.save(step);
    }

}
