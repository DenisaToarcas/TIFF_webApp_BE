package org.example.mpp_be.repository;

import com.github.javafaker.Faker;
import org.example.mpp_be.model.TIFFRoles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Repository
public class Repository implements IRepository<TIFFRoles, Integer> {

    private final List<TIFFRoles> roles;

    /*
    public Repository() {
        roles =  new ArrayList<>(
                List.of(
                        new TIFFRoles(1, "Indoor", "Cinema Star", "We are looking for 45 volunteers", "4-6 hour shifts, according to the location schedule. The last shift ends after the public enters the last screening of the day.", "To have an eye for details, good organizational skills, a friendly attitude, availability to offer information and manage surprises."),
                        new TIFFRoles(2, "Open Air", "Cinema Star", "We are looking for 40 volunteers", "The shifts vary depending on the screenings and events taking place in your location. The activity generally starts around 18:00 and lasts until clearing, after the last event.", "To work well in a team but to not be afraid of acting on your own. To be prepared for outdoor physical activity. To be punctual and responsible."),
                        new TIFFRoles(3, "Screening Hot Shot", "Screening Hot Shot", "We are looking for 90 volunteers", "5 to 6-hour shifts (the length of two movie projections); time frame: 10:30 a.m.-01:00 p.m.", "You will have to prove your attention to details, a friendly attitude but also a contained attitude if needed and also seriousness. Punctuality and the capacity to work well in a team are particularly appreciated."),
                        new TIFFRoles(4, "Warehouse", "Logistics Hero", "We are looking for 10 volunteers", "Approximately 6-hour shifts; time frame: 09:00 a.m.- 09:00 p.m. during the festival. A few days before and after the festival: flexible shifts.", "Show us that you are well-organized and that you pay attention to details. Punctuality and seriousness are as important as your sense of humor. Also, it is recommended that you have a good physical condition.")
                )
        );
     */

    public Repository() {
        roles = new ArrayList<>();

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            int roleID = i;
            String roleName = faker.starTrek().character();
            String type = faker.starTrek().specie();
            String openRoles = "We are looking for " + faker.number().numberBetween(10, 100) + " volunteers!";
            String schedule = "all day at " + faker.address().fullAddress();
            String expectation = faker.backToTheFuture().quote();

            TIFFRoles role = new TIFFRoles(roleID, roleName, type, openRoles, schedule, expectation);
            roles.add(role);
        }
    }

    @Override
    public TIFFRoles getByID(Integer ID) {
        return roles.stream().filter(role -> Objects.equals(role.getId(), ID)).findFirst().orElse(null);
    }

    @Override
    public void add(TIFFRoles entity) {
        roles.add(entity);
    }

    @Override
    public TIFFRoles update(Integer ID, TIFFRoles entity) {
        TIFFRoles roleToUpdate = getByID(ID);

        roleToUpdate.setRoleName(entity.getRoleName());
        roleToUpdate.setType(entity.getType());
        roleToUpdate.setOpenRoles(entity.getOpenRoles());
        roleToUpdate.setSchedule(entity.getSchedule());
        roleToUpdate.setExpectation(entity.getExpectation());

        return roleToUpdate;
    }

    @Override
    public void delete(Integer ID) {
        roles.removeIf(role -> Objects.equals(role.getId(), ID));
    }

    @Override
    public List<TIFFRoles> getAll() {
        return roles;
    }

    @Override
    public int numberOfEntities() {
        return roles.size();
    }

    @Override
    public boolean contains(Integer ID) {
        return roles.stream().anyMatch(role -> Objects.equals(role.getId(), ID));
    }

    public int freeID()
    {
        return roles.size() * 100 + 1;
    }
}
