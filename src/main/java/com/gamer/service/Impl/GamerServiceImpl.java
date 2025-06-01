package com.gamer.service.Impl;

import com.gamer.common.constant.GeographyConstant;
import com.gamer.common.constant.MessageConstant;
import com.gamer.common.component.GamerGameComponent;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.SearchDTO;
import com.gamer.model.entity.Gamer;
import com.gamer.model.vo.AutoMatchGamerVO;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.GamerGameService;
import com.gamer.service.GamerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GamerServiceImpl implements GamerService {

    private final GamerRepository gamerRepository;
    private final GameRepository gameRepository;
    private final GamerGameRepository gamerGameRepository;
    private final GamerGameService gamerGameService;
    private final GamerGameComponent gamerGameComponent;

    @Transactional
    public void save(GamerDTO gamerDTO){

        if (gamerDTO.getGeography() == null || gamerDTO.getGeography().isBlank())
            gamerDTO.setGeography(GeographyConstant.UNKNOWN);

        if (gamerRepository.findByName(gamerDTO.getName()).isPresent()) { // New gamer
            throw new BusinessException(MessageConstant.USER_ALREADY_EXIST + gamerDTO.getName());
        }

        Gamer gamer = Gamer.builder()
                .name(gamerDTO.getName())
                .geography(gamerDTO.getGeography())
                .build();
        gamer = gamerRepository.save(gamer);
        log.info("Gamer [{}] created", gamer.getName());

    }

    @Override
    public List<AutoMatchGamerVO> search(SearchDTO searchDTO) {
        return List.of();
    }

}
