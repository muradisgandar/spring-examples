package com.company.graphql.api;

import com.company.graphql.dto.VehicleDto;
import com.company.graphql.entity.Vehicle;
import com.company.graphql.repo.VehicleRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto){
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setLaunchDate(new Date());
        vehicle.setModelCode(vehicleDto.getModelCode());

        return vehicle;
    }
}
