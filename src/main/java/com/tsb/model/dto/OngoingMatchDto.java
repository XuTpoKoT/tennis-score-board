package com.tsb.model.dto;

import java.util.UUID;

public record OngoingMatchDto(UUID id, String firstPlayer, String secondPlayer) {
}
