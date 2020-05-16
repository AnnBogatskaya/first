package org.bogatskaya.schedule.app.domain.service;

import org.bogatskaya.schedule.app.service.UserService;

public class UserServiceImplTest {

    private UserService service;

    /*
    @Before
    public void setup(){
        service = new UserServiceImpl();
    }

    @Test
    public void testAddAndFindAllSuccess(){
        User user = new User("Vovka","kek");

        service.saveUser(user);

        assertTrue(!service.findAll().isEmpty());
        assertEquals(service.findAll().get(0).getLogin(),"Vovka");
    }

    @Test
    public void testAddDuplicateUser(){
        User user = new User("Vovka","kek");

        service.saveUser(user);
        service.saveUser(user);
        service.saveUser(user);

        assertEquals(service.findAll().size(),1);
    }

    @Test
    public void testFindByEmailSuccess(){
        User user = new User("Vovka","kek");
        User user1 = new User("Popka","sas");

        service.saveUser(user);
        service.saveUser(user1);

        User user2 = service.findByEmail("kek");

        assertEquals(user2,user);
        assertEquals(service.findByEmail("sas").getLogin(),"Popka");

    }*/

}
