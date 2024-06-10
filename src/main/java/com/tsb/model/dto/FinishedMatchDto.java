package com.tsb.model.dto;

import java.util.UUID;

public record FinishedMatchDto(UUID id, String firstPlayer, String secondPlayer, String winner) {
}
