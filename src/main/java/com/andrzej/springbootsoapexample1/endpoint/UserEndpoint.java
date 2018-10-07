package com.andrzej.springbootsoapexample1.endpoint;

import com.andrzej.springbootsoapexample1.service.UserService;
import com.techprimers.spring_boot_soap_example.GetUserRequest;
import com.techprimers.spring_boot_soap_example.GetUserResponse;
import com.techprimers.spring_boot_soap_example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author andrzej
 */
@Endpoint
public class UserEndpoint {

    @Autowired
    UserService userService;

    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = userService.getUser(request.getName());
        response.setUser(user);
        return response;
    }

}
