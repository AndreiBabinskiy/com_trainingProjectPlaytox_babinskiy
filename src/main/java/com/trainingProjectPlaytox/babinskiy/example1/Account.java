package com.trainingProjectPlaytox.babinskiy.example1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Account {
    private final String ID;
    private int money;

    // Инициализация логера
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public Account(String ID, int money) {
        this.ID = ID;
        this.money = money;
    }

    public String getID() {
        return ID;
    }

    public synchronized int getMoney() {
        return money;
    }

    public synchronized void transfer(Account target, int amount) {
        if (amount > 0 && this.money >= amount) {
            this.money -= amount;
            target.money += amount;
            System.out.println("Transfered " + amount + " from account " + this.ID + " to account " + target.getID());
            logger.info("Transfered " + amount + " from account " + this.ID + " to account " + target.getID());
        } else {
            System.out.println("Transfer failed from account " + this.ID + " to account " + target.getID() + ". Insufficient funds.");
            logger.error("Transfer failed from account " + this.ID + " to account " + target.getID() + ". Insufficient funds.");
        }
    }
}
