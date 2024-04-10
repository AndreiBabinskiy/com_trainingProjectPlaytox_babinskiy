package com.trainingProjectPlaytox.babinskiy.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main1 {
    public static void main(String[] args) {
        // Создаем список счетов
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            accounts.add(new Account(String.valueOf(i + 1), 10000));
        }

        // Создаем и запускаем потоки
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            threads.add(new Thread(new TransferTask(accounts)));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    static class TransferTask implements Runnable {
        private final List<Account> accounts;
        private final Random random;

        public TransferTask(List<Account> accounts) {
            this.accounts = accounts;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                try {
                    // Выбираем случайные счета для перевода
                    Account fromAccount = accounts.get(random.nextInt(accounts.size()));
                    Account toAccount = accounts.get(random.nextInt(accounts.size()));

                    // Проверяем, чтобы fromAccount и toAccount были разными
                    while (fromAccount == toAccount) {
                        toAccount = accounts.get(random.nextInt(accounts.size()));
                    }

                    // Выбираем случайную сумму для перевода
                    int amount = random.nextInt(1000) + 1;

                    // Выполняем перевод средств
                    fromAccount.transfer(toAccount, amount);

                    // Засыпаем на случайное время от 1000 до 2000 мс
                    Thread.sleep(random.nextInt(1001) + 1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
