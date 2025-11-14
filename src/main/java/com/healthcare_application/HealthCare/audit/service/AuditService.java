package com.healthcare_application.HealthCare.audit.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.audit.entity.AuditLog;
import com.healthcare_application.HealthCare.audit.respository.AuditLogRepository;

@Service
public class AuditService 
{


	private final AuditLogRepository auditLogRepository;


	public AuditService(AuditLogRepository auditLogRepository) 
	{
		this.auditLogRepository = auditLogRepository;
	}


	public AuditLog logAction(String username, String action) 
	{
		AuditLog log = new AuditLog();
		log.setUsername(username);
		log.setAction(action);
		log.setTimestamp(LocalDateTime.now());
		return auditLogRepository.save(log);
	}
}
