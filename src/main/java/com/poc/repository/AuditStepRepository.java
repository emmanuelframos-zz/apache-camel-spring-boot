package com.poc.repository;


import com.poc.domain.AuditStep;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditStepRepository extends MongoRepository<AuditStep, String> { }
