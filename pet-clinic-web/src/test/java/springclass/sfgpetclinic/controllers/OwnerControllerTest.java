package springclass.sfgpetclinic.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import springclass.sfgpetclinic.model.Owner;
import springclass.sfgpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OwnerController.class) // Loads only OwnerController
class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Simulates HTTP requests

    @MockBean
    private OwnerService ownerService; // Fake OwnerService

    @Test
    void shouldReturnOwnersList() throws Exception {
        // Arrange: Create fake owners list
        Set<Owner> owners = new HashSet<>();
        
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jane");
        owner2.setLastName("Smith");

        owners.add(owner1);
        owners.add(owner2);

        // Mock service call
        when(ownerService.findAll()).thenReturn(owners);

        // Act & Assert: Perform GET request and check response
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())  // Expect HTTP 200 OK
                .andExpect(view().name("owners/index"))  // Expect view "owners/index"
                .andExpect(model().attributeExists("owners"))  // Expect "owners" attribute
                .andExpect(model().attribute("owners", owners));  // Expect correct data
    }

    @Test
    void shouldReturnNotImplementedForFindOwners() throws Exception {
        // Act & Assert: Perform GET request and expect "notImplemented" view
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())  // Expect HTTP 200 OK
                .andExpect(view().name("notImplemented")); // Expect "notImplemented" view
    }
}
