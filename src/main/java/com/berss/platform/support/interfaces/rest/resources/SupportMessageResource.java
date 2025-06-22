package com.berss.platform.support.interfaces.rest.resources;

import java.time.LocalDateTime;

public record SupportMessageResource(Long id, String content, Long companyId, LocalDateTime requestDate, LocalDateTime receivedAt, String status) {
}