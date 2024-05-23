package cs.ui.ac.id.advprog.eshop.service;

import cs.ui.ac.id.advprog.eshop.model.Car;

import java.util.List;

public interface CarService {
    public Car create(Car car);
    public List<Car> findAll();
    Car findById(String productId);
    public void update(String id, Car editedCar);
    public void deleteCarById(String id);
}
