package com.switchfully.parkshark.member.domain;

public enum MembershipLevel {
    BRONZE(0.0, 0.0, 4),
    SILVER(10.0,0.20, 6),
    GOLD(40.0, 0.3, 24);

    private double monthlyCost;
    private double reductionPercentage;
    private int maxAllowedParkingTime;

    MembershipLevel(double monthlyCost, double reductionPercentage, int maxAllowedParkingTime) {
        this.monthlyCost = monthlyCost;
        this.reductionPercentage = reductionPercentage;
        this.maxAllowedParkingTime = maxAllowedParkingTime;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getReductionPercentage() {
        return reductionPercentage;
    }

    public int getMaxAllowedParkingTime() {
        return maxAllowedParkingTime;
    }
}
