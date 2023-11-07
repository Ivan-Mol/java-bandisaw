package com.main.service.impl;

import com.github.loki.afro.metallum.search.API;
import com.github.loki.afro.metallum.search.query.entity.BandQuery;
import com.github.loki.afro.metallum.search.query.entity.SearchBandResult;
import com.main.model.Band;
import com.main.service.BandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BandServiceImpl implements BandService {

    @Override
    public List<Band> getBandsByName(String bandName) {
        List<Band> bands = new ArrayList<>();
        BandQuery query = BandQuery.builder()
                .name(bandName).exactBandNameMatch(true)
                .build();
        for (SearchBandResult result : API.getBands(query)) {
            Band foundBand = Band
                    .builder()
                    .id(result.getId())
                    .name(result.getName())
                    .genre(result.getGenre().toString())
                    .country(result.getCountry().toString())
                    .build();
            bands.add(foundBand);
            System.out.println("BandName: " + result.getName());
            System.out.println("BandId: " + result.getId());
        }
        return bands;
    }


}
