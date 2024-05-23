package cs.ui.ac.id.advprog.eshop.service;

import cs.ui.ac.id.advprog.eshop.model.Car;
import cs.ui.ac.id.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car){
        carRepository.create(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        Iterator<Car> CarIterator = carRepository.findAll();
        List<Car> allCar = new ArrayList<>();
        CarIterator.forEachRemaining(allCar::add);
        return allCar;
    }

    @Override
    public Car findById(String carId){
        Car car = carRepository.findById(carId);
        return car;
    }

    @Override
    public void deleteCarById(String carId){
        carRepository.delete(carId);
    }

    @Override
    public void update(String id, Car editedCar){
        carRepository.update(id, editedCar);
    }

}