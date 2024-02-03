package com.example.pathfinder.service;

import com.example.pathfinder.model.Route;
import com.example.pathfinder.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository repository){
        this.routeRepository=routeRepository;
    }

    public List<Route> getMostCommented()  {
        return routeRepository.findMostCommented();
    }
}
