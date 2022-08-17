package com.medical_declaration.model;

public class Medical {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String vehicle;
    private String vehicleNumber;
    private String seats;
    private String departureDay;
    private String endDay;
    private String route;

    public Medical() {
    }

    public Medical(String name, String dateOfBirth, String gender, String nationality, String idCard,
                   String vehicle, String vehicleNumber, String seats, String departureDay, String endDay, String route) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.departureDay = departureDay;
        this.endDay = endDay;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
