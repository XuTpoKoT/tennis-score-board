package com.tsb.mapper;

import com.tsb.model.core.OngoingMatch;
import com.tsb.model.dto.FinishedMatchDto;
import com.tsb.model.dto.OngoingMatchDto;
import com.tsb.model.entity.FinishedMatch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper
public interface MatchMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstPlayer", source = "player1.name")
    @Mapping(target = "secondPlayer", source = "player2.name")
    @Mapping(target = "winner", source = "winner.name")
    FinishedMatchDto fromFinishedMatch(FinishedMatch finishedMatch);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstPlayer", source = "match.player1.name")
    @Mapping(target = "secondPlayer", source = "match.player2.name")
    OngoingMatchDto fromOngoingMatch(UUID id, OngoingMatch match);
}
