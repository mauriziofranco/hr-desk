package franco.maurizio.hr.desk.com.unit.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import franco.maurizio.hr.desk.com.CeReProBackendApplication;
import franco.maurizio.hr.desk.com.persistence.entity.Role;
import franco.maurizio.hr.desk.com.persistence.repository.RoleRepository;
import franco.maurizio.hr.desk.com.service.RoleService;

/**
 *
  * @author maurizio.franco@ymail.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CeReProBackendApplication.class)
public class RoleServiceTest {

	public final static String ROLE_LABEL_TEST = "aaa" ;
	public final static String ROLE_DESCRIPTION_TEST = "bbb" ;
	public final static int ROLE_LEVEL_TEST = 999 ;
	
	public static final Logger logger = LoggerFactory.getLogger(RoleServiceTest.class);
 
    @Spy
    private RoleService roleService;
    
    @Mock
    private RoleRepository roleRepository ;
    
    @BeforeEach
    public void setup() {
    	roleService = new RoleService();    	
   	    ReflectionTestUtils.setField(roleService, "roleRepository", roleRepository);
    }
    
    @Test
    public void testGetAllFullOk() {
   	    logger.info("testGetAllFullOk - START");
   	    List<Role> rolesList = new ArrayList<Role>();
   	    rolesList.add(new Role(ROLE_LABEL_TEST, ROLE_DESCRIPTION_TEST, ROLE_LEVEL_TEST));   	 
   	    when(roleRepository.findAll()).thenReturn(rolesList);
	    assertEquals(1, roleService.getAll().size());
	    assertEquals(ROLE_LABEL_TEST,       roleService.getAll().get(0).getLabel());
	    assertEquals(ROLE_DESCRIPTION_TEST, roleService.getAll().get(0).getDescription());
	    assertEquals(ROLE_LEVEL_TEST, roleService.getAll().get(0).getLevel());
	    logger.info("testGetAllFullOk - END");
    }
    
    @Test
    public void testGetAllEmptyOk() {
   	    logger.info("testGetAllEmptyOk - START");
   	    List<Role> rolesList = new ArrayList<Role>();
	    when(roleRepository.findAll()).thenReturn(rolesList);
	    assertEquals(0, roleService.getAll().size());	    
	    logger.info("testGetAllEmptyOk - END");
    }

}
