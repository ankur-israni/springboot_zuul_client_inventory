package com.ankur.zuul.controller;



import com.ankur.zuul.domain.InventoryListAllRequest;
import com.ankur.zuul.domain.InventoryListAllResponse;
import com.ankur.zuul.domain.ServiceErrorResponse;
import com.ankur.zuul.service.InventoryService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/services/inventory")
@Api(value = "/services/inventory", tags = ("Inventory Management"))
@CrossOrigin(allowedHeaders = "*",maxAge = 3600)
public class InventoryController {

    private static final String VALID_USERNAME = "ankur";
    private static final String VALID_PASSWORD = "ankur";

    private static final String CLIENT_ID = "client-id";
    private InventoryService inventoryService;



    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


//    @RequestMapping(value = "all", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    @ApiOperation(value = "all", notes = "Fetch all employees", nickname = "all")
//    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / invalid parameter", response = ServiceErrorResponse.class),
//            @ApiResponse(code = 200, message = "Success", response = InventoryListAllResponse.class)})
//    public ResponseEntity<?> all(@RequestHeader(value = CLIENT_ID) String clientId,
//                                 @Valid @RequestBody InventoryListAllRequest request) {
//            return inventoryService.all();
//    }

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "all", notes = "Fetch all employees", nickname = "all")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / invalid parameter", response = ServiceErrorResponse.class),
            @ApiResponse(code = 200, message = "Success", response = InventoryListAllResponse.class)})
    public ResponseEntity<?> all() {
        return inventoryService.all();
    }

    private boolean isValidCredentials(String username, String password) {
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)
                && StringUtils.equalsIgnoreCase(VALID_USERNAME, username)
                && StringUtils.equalsIgnoreCase(VALID_PASSWORD, password);
    }

    private ResponseEntity<ServiceErrorResponse> errorResponse() {
        ServiceErrorResponse apiError = new ServiceErrorResponse(HttpStatus.UNAUTHORIZED, "9000", "Invalid username or password");
        return new ResponseEntity<>(apiError, (HttpStatus) apiError.getHttpStatus());
    }
}

