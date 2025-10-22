package ru.artemii.employee.payload;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorPayload(String message, String detailMessage, LocalDateTime atCurrent) {
}

