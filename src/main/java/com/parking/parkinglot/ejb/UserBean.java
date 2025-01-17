package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.User;
import com.parking.parkinglot.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PasswordBean passwordBean;

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");
        try {
            TypedQuery<User> typedQuery =
                    entityManager.createQuery("SELECT c FROM User c", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public User findById(String username) {
        LOG.info("findbyId");
        try {
            TypedQuery<User> typedQuery =
                    entityManager.createQuery("SELECT u FROM User u WHERE u.email = :username", User.class)
                            .setParameter("username", username);
            return typedQuery.getSingleResult();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> userDto = new LinkedList<UserDto>();

        for (int i = 0; i < users.size(); i++) {
            UserDto dto = new UserDto(users.get(i).getId(),
                    users.get(i).getEmail(),
                    users.get(i).getPassword(),
                    users.get(i).getUsername());
            userDto.add(dto);
        }

        return userDto;
    }

    public void createUser(String username, String email, String password, Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }

    private void assignGroupsToUser(String username, Collection<String> groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
        }
    }
}
