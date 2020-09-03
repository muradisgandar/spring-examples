package com.company.graphql.api;

import com.company.graphql.entity.Vehicle;
import com.company.graphql.repo.VehicleRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type){
        return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id){
        return vehicleRepository.findById(id);
    }
}
