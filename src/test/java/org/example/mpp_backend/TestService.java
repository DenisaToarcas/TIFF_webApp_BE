package org.example.mpp_backend;

import org.example.mpp_backend.model.TIFFRoles;
import org.example.mpp_backend.repository.Repository;
import org.example.mpp_backend.service.Service;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TestService {

    @Test
    public void testGetAllRoles()
    {
        final Repository repo = new Repository();
        final Service service = new Service(repo);

        assert service.getAllRoles().size() == 4;

        List<TIFFRoles> roles = service.getAllRoles();
        List<TIFFRoles> correctRoles = new ArrayList<TIFFRoles>(
                List.of(
                        new TIFFRoles(1, "Indoor", "Cinema Star", "We are looking for 45 volunteers", "4-6 hour shifts, according to the location schedule. The last shift ends after the public enters the last screening of the day.", "To have an eye for details, good organizational skills, a friendly attitude, availability to offer information and manage surprises."),
                        new TIFFRoles(2, "Open Air", "Cinema Star", "We are looking for 40 volunteers", "The shifts vary depending on the screenings and events taking place in your location. The activity generally starts around 18:00 and lasts until clearing, after the last event.", "To work well in a team but to not be afraid of acting on your own. To be prepared for outdoor physical activity. To be punctual and responsible."),
                        new TIFFRoles(3, "Screening Hot Shot", "Screening Hot Shot", "We are looking for 90 volunteers", "5 to 6-hour shifts (the length of two movie projections); time frame: 10:30 a.m.-01:00 p.m.", "You will have to prove your attention to details, a friendly attitude but also a contained attitude if needed and also seriousness. Punctuality and the capacity to work well in a team are particularly appreciated."),
                        new TIFFRoles(4, "Warehouse", "Logistics Hero", "We are looking for 10 volunteers", "Approximately 6-hour shifts; time frame: 09:00 a.m.- 09:00 p.m. during the festival. A few days before and after the festival: flexible shifts.", "Show us that you are well-organized and that you pay attention to details. Punctuality and seriousness are as important as your sense of humor. Also, it is recommended that you have a good physical condition.")
                )
        );

        assert roles.size() == correctRoles.size();

        for (int i = 0; i < roles.size(); i++) {
            TIFFRoles role = roles.get(i);
            TIFFRoles correctRole = correctRoles.get(i);

            assert Objects.equals(role.getId(), correctRole.getId());
            assert Objects.equals(role.getType(), correctRole.getType());
            assert Objects.equals(role.getOpenRoles(), correctRole.getOpenRoles());
            assert Objects.equals(role.getSchedule(), correctRole.getSchedule());
            assert Objects.equals(role.getExpectation(), correctRole.getExpectation());
        }

    }

    @Test
    public void testAddRole()
    {
        final Repository repo = new Repository();
        final Service service = new Service(repo);

        int currentSize = service.getAllRoles().size();

        TIFFRoles newRole = new TIFFRoles(0, "newRole", "newType", "openRoles", "schedule", "expectation");
        TIFFRoles addedRole = service.addRole(newRole);

        assert addedRole.getId() == currentSize * 100 + 1;
        assert Objects.equals(addedRole.getRoleName(), newRole.getRoleName());
        assert Objects.equals(addedRole.getType(), newRole.getType());
        assert Objects.equals(addedRole.getOpenRoles(), newRole.getOpenRoles());
        assert Objects.equals(addedRole.getSchedule(), newRole.getSchedule());
        assert Objects.equals(addedRole.getExpectation(), newRole.getExpectation());

        assert service.getAllRoles().size() == currentSize + 1;

        TIFFRoles invalidRoleName = new TIFFRoles(0, "", "newType", "openRoles", "schedule", "expectation");
        TIFFRoles invalidRoleType = new TIFFRoles(0, "roleName", "", "openRoles", "schedule", "expectation");
        TIFFRoles invalidOpenRoles = new TIFFRoles(0, "newRole", "newType", "", "schedule", "expectation");
        TIFFRoles invalidSchedule = new TIFFRoles(0, "newRole", "newType", "openRoles", "", "expectation");
        TIFFRoles invalidExpectation = new TIFFRoles(0, "newRole", "newType", "opeRoles", "schedule", "");

        try{
            service.addRole(invalidRoleName);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(invalidRoleType);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(invalidOpenRoles);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(invalidSchedule);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(invalidExpectation);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        assert service.getAllRoles().size() == currentSize + 1;

        TIFFRoles nullRoleName = new TIFFRoles(0, null, "newType", "openRoles", "schedule", "expectation");
        TIFFRoles nullRoleType = new TIFFRoles(0, "roleName", null, "openRoles", "schedule", "expectation");
        TIFFRoles nullOpenRoles = new TIFFRoles(0, "newRole", "newType", null, "schedule", "expectation");
        TIFFRoles nullSchedule = new TIFFRoles(0, "newRole", "newType", "openRoles", null, "expectation");
        TIFFRoles nullExpectation = new TIFFRoles(0, "newRole", "newType", "opeRoles", "schedule", null);

        try{
            service.addRole(nullRoleName);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(nullRoleType);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(nullOpenRoles);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(nullSchedule);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.addRole(nullExpectation);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        assert service.getAllRoles().size() == currentSize + 1;
    }

    @Test
    public void testGetByID()
    {
        final Repository repo = new Repository();
        final Service service = new Service(repo);

        TIFFRoles firstRole = service.getByID(1);
        TIFFRoles correctFirstRole = new TIFFRoles(1, "Indoor", "Cinema Star", "We are looking for 45 volunteers", "4-6 hour shifts, according to the location schedule. The last shift ends after the public enters the last screening of the day.", "To have an eye for details, good organizational skills, a friendly attitude, availability to offer information and manage surprises.");
        assert Objects.equals(firstRole.getId(), correctFirstRole.getId());
        assert Objects.equals(firstRole.getRoleName(), correctFirstRole.getRoleName());
        assert Objects.equals(firstRole.getOpenRoles(), correctFirstRole.getOpenRoles());
        assert Objects.equals(firstRole.getSchedule(), correctFirstRole.getSchedule());
        assert Objects.equals(firstRole.getExpectation(), correctFirstRole.getExpectation());

        TIFFRoles secondRole = service.getByID(2);
        TIFFRoles correctSecondRole = new TIFFRoles(2, "Open Air", "Cinema Star", "We are looking for 40 volunteers", "The shifts vary depending on the screenings and events taking place in your location. The activity generally starts around 18:00 and lasts until clearing, after the last event.", "To work well in a team but to not be afraid of acting on your own. To be prepared for outdoor physical activity. To be punctual and responsible.");
        assert Objects.equals(secondRole.getId(), correctSecondRole.getId());
        assert Objects.equals(secondRole.getRoleName(), correctSecondRole.getRoleName());
        assert Objects.equals(secondRole.getOpenRoles(), correctSecondRole.getOpenRoles());
        assert Objects.equals(secondRole.getSchedule(), correctSecondRole.getSchedule());
        assert Objects.equals(secondRole.getExpectation(), correctSecondRole.getExpectation());

        TIFFRoles thirdRole = service.getByID(3);
        TIFFRoles correctThirdRole = new TIFFRoles(3, "Screening Hot Shot", "Screening Hot Shot", "We are looking for 90 volunteers", "5 to 6-hour shifts (the length of two movie projections); time frame: 10:30 a.m.-01:00 p.m.", "You will have to prove your attention to details, a friendly attitude but also a contained attitude if needed and also seriousness. Punctuality and the capacity to work well in a team are particularly appreciated.");
        assert Objects.equals(thirdRole.getId(), correctThirdRole.getId());
        assert Objects.equals(thirdRole.getRoleName(), correctThirdRole.getRoleName());
        assert Objects.equals(thirdRole.getOpenRoles(), correctThirdRole.getOpenRoles());
        assert Objects.equals(thirdRole.getSchedule(), correctThirdRole.getSchedule());
        assert Objects.equals(thirdRole.getExpectation(), correctThirdRole.getExpectation());

        TIFFRoles fourthRole = service.getByID(4);
        TIFFRoles correctFourthRole = new TIFFRoles(4, "Warehouse", "Logistics Hero", "We are looking for 10 volunteers", "Approximately 6-hour shifts; time frame: 09:00 a.m.- 09:00 p.m. during the festival. A few days before and after the festival: flexible shifts.", "Show us that you are well-organized and that you pay attention to details. Punctuality and seriousness are as important as your sense of humor. Also, it is recommended that you have a good physical condition.");
        assert Objects.equals(fourthRole.getId(), correctFourthRole.getId());
        assert Objects.equals(fourthRole.getRoleName(), correctFourthRole.getRoleName());
        assert Objects.equals(fourthRole.getOpenRoles(), correctFourthRole.getOpenRoles());
        assert Objects.equals(fourthRole.getSchedule(), correctFourthRole.getSchedule());
        assert Objects.equals(fourthRole.getExpectation(), correctFourthRole.getExpectation());
    }

    @Test
    public void testUpdateRole()
    {
        final Repository repo = new Repository();
        final Service service = new Service(repo);

        int currentSize = service.getAllRoles().size();

        TIFFRoles updateRole = new TIFFRoles(1, "updatedRoleName", "updatedRoleType", "updatedOpenRoles", "updatedSchedule", "updatedExpectation");
        TIFFRoles roleUpdated = service.updateRole(1, updateRole);

        assert Objects.equals(roleUpdated.getId(), updateRole.getId());
        assert Objects.equals(roleUpdated.getRoleName(), updateRole.getRoleName());
        assert Objects.equals(roleUpdated.getOpenRoles(), updateRole.getOpenRoles());
        assert Objects.equals(roleUpdated.getSchedule(), updateRole.getSchedule());
        assert Objects.equals(roleUpdated.getExpectation(), updateRole.getExpectation());

        assert service.getAllRoles().size() == currentSize;

        try{
            service.updateRole(100, updateRole);
            assert false;
        }
        catch (Exception e){
            assert true;
        }

        TIFFRoles invalidRoleName = new TIFFRoles(1, "", "newType", "openRoles", "schedule", "expectation");
        TIFFRoles invalidRoleType = new TIFFRoles(1, "roleName", "", "openRoles", "schedule", "expectation");
        TIFFRoles invalidOpenRoles = new TIFFRoles(1, "newRole", "newType", "", "schedule", "expectation");
        TIFFRoles invalidSchedule = new TIFFRoles(1, "newRole", "newType", "openRoles", "", "expectation");
        TIFFRoles invalidExpectation = new TIFFRoles(1, "newRole", "newType", "opeRoles", "schedule", "");

        try{
            service.updateRole(1, invalidRoleName);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, invalidRoleType);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, invalidOpenRoles);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, invalidSchedule);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, invalidExpectation);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        assert service.getAllRoles().size() == currentSize;

        TIFFRoles nullRoleName = new TIFFRoles(0, null, "newType", "openRoles", "schedule", "expectation");
        TIFFRoles nullRoleType = new TIFFRoles(0, "roleName", null, "openRoles", "schedule", "expectation");
        TIFFRoles nullOpenRoles = new TIFFRoles(0, "newRole", "newType", null, "schedule", "expectation");
        TIFFRoles nullSchedule = new TIFFRoles(0, "newRole", "newType", "openRoles", null, "expectation");
        TIFFRoles nullExpectation = new TIFFRoles(0, "newRole", "newType", "opeRoles", "schedule", null);

        try{
            service.updateRole(1, nullRoleName);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, nullRoleType);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, nullOpenRoles);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, nullSchedule);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        try{
            service.updateRole(1, nullExpectation);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        assert service.getAllRoles().size() == currentSize;
    }

    @Test
    public void testRemoveRole()
    {
        final Repository repo = new Repository();
        final Service service = new Service(repo);

        int currentSize = service.getAllRoles().size();

        try {
            service.removeRole(3);
            assert true;
        }
        catch (Exception e) {
            assert false;
        }
        assert service.getAllRoles().size() == currentSize - 1;

        try{
            service.removeRole(100);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }

        assert service.getAllRoles().size() == currentSize - 1;
    }

    @Test
    public void testFilterRoles()
    {
        final Repository repo = new Repository();
        final Service service = new Service(repo);

        assert service.getAllRoles().size() == 4;

        List<TIFFRoles> roles = service.filterRoles();
        List<TIFFRoles> correctRoles = new ArrayList<TIFFRoles>(
                List.of(
                        new TIFFRoles(1, "Indoor", "Cinema Star", "We are looking for 45 volunteers", "4-6 hour shifts, according to the location schedule. The last shift ends after the public enters the last screening of the day.", "To have an eye for details, good organizational skills, a friendly attitude, availability to offer information and manage surprises."),
                        new TIFFRoles(2, "Open Air", "Cinema Star", "We are looking for 40 volunteers", "The shifts vary depending on the screenings and events taking place in your location. The activity generally starts around 18:00 and lasts until clearing, after the last event.", "To work well in a team but to not be afraid of acting on your own. To be prepared for outdoor physical activity. To be punctual and responsible."),
                        new TIFFRoles(3, "Screening Hot Shot", "Screening Hot Shot", "We are looking for 90 volunteers", "5 to 6-hour shifts (the length of two movie projections); time frame: 10:30 a.m.-01:00 p.m.", "You will have to prove your attention to details, a friendly attitude but also a contained attitude if needed and also seriousness. Punctuality and the capacity to work well in a team are particularly appreciated."),
                        new TIFFRoles(4, "Warehouse", "Logistics Hero", "We are looking for 10 volunteers", "Approximately 6-hour shifts; time frame: 09:00 a.m.- 09:00 p.m. during the festival. A few days before and after the festival: flexible shifts.", "Show us that you are well-organized and that you pay attention to details. Punctuality and seriousness are as important as your sense of humor. Also, it is recommended that you have a good physical condition.")
                )
        );

        assert roles.size() == correctRoles.size();

        for (int i = 0; i < roles.size(); i++) {
            TIFFRoles role = roles.get(i);
            TIFFRoles correctRole = correctRoles.get(i);

            assert Objects.equals(role.getId(), correctRole.getId());
            assert Objects.equals(role.getType(), correctRole.getType());
            assert Objects.equals(role.getOpenRoles(), correctRole.getOpenRoles());
            assert Objects.equals(role.getSchedule(), correctRole.getSchedule());
            assert Objects.equals(role.getExpectation(), correctRole.getExpectation());
        }

        TIFFRoles newRole = new TIFFRoles(0, "hi", "newType", "openRoles", "schedule", "expectation");
        service.addRole(newRole);
        assert service.getAllRoles().size() == correctRoles.size() + 1;

        List<TIFFRoles> filteredRoles = service.filterRoles();
        assert filteredRoles.size() == correctRoles.size();

        for (int i = 0; i < filteredRoles.size(); i++) {
            TIFFRoles role = filteredRoles.get(i);
            TIFFRoles correctRole = correctRoles.get(i);

            assert Objects.equals(role.getId(), correctRole.getId());
            assert Objects.equals(role.getType(), correctRole.getType());
            assert Objects.equals(role.getOpenRoles(), correctRole.getOpenRoles());
            assert Objects.equals(role.getSchedule(), correctRole.getSchedule());
            assert Objects.equals(role.getExpectation(), correctRole.getExpectation());
        }

    }
}
