package com.tsb.mapper;

import com.tsb.model.dto.FinishedMatchDto;
import com.tsb.model.entity.FinishedMatch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FinishedMatchMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstPlayer", source = "player1.name")
    @Mapping(target = "secondPlayer", source = "player2.name")
    @Mapping(target = "winner", source = "winner.name")
    FinishedMatchDto fromFinishedMatch(FinishedMatch finishedMatch);
}
