package com.main.service;


import com.main.model.Band;

import java.util.List;

public interface BandService {
    List<Band> getBandsByName(String bandName);
}
