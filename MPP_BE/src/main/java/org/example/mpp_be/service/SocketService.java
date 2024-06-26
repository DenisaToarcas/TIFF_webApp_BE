package org.example.mpp_be.service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import org.example.mpp_be.model.TIFFRoles;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SocketService {
    private SocketIOServer server;
    private final org.example.mpp_be.service.Service service;

    public SocketService(org.example.mpp_be.service.Service service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9090);

        server = new SocketIOServer(config);
        server.start();

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::sendNewTIFFRole, 15, 15, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void destroy() {
        server.stop();
    }

    private void sendNewTIFFRole() {
        Faker faker = new Faker();

        String roleName = faker.starTrek().character();
        String type = faker.starTrek().specie();
        String openRoles = "We are looking for " + faker.number().numberBetween(10, 100) + " volunteers!";
        String schedule = "all day at " + faker.address().fullAddress();
        String expectation = faker.backToTheFuture().quote();

        TIFFRoles role = new TIFFRoles(0, roleName, type, openRoles, schedule, expectation);
        service.addRole(role);

        server.getBroadcastOperations().sendEvent("added a new role", role);
    }
}
